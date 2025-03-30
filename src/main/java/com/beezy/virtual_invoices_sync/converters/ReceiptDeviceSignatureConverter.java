package com.beezy.virtual_invoices_sync.converters;

import com.beezy.virtual_invoices_sync.model.ReceiptDeviceSignature;
import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ReceiptDeviceSignatureConverter implements AttributeConverter<ReceiptDeviceSignature, String> {
    private static final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(ReceiptDeviceSignature signature) {
        return gson.toJson(signature);
    }

    @Override
    public ReceiptDeviceSignature convertToEntityAttribute(String value) {
        return gson.fromJson(value, ReceiptDeviceSignature.class);
    }
}
