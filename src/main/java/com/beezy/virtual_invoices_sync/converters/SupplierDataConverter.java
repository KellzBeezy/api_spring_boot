package com.beezy.virtual_invoices_sync.converters;

import com.beezy.virtual_invoices_sync.model.SupplierData;
import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SupplierDataConverter implements AttributeConverter<SupplierData, String> {

    private static final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(SupplierData supplierData) {
        return gson.toJson(supplierData);
    }


    @Override
    public SupplierData convertToEntityAttribute(String value) {
        return gson.fromJson(value, SupplierData.class);
    }


}
