package com.beezy.virtual_invoices_sync.converters;

import com.beezy.virtual_invoices_sync.model.BuyerAddress;
import com.beezy.virtual_invoices_sync.model.ReceiptDeviceSignature;
import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BuyerAddressConverter implements AttributeConverter<BuyerAddress, String> {

    private static final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(BuyerAddress signature) {
        return gson.toJson(signature);
    }

    @Override
    public BuyerAddress convertToEntityAttribute(String value) {
        return gson.fromJson(value, BuyerAddress.class);
    }
}
