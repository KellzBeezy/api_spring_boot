package com.beezy.virtual_invoices_sync.converters;

import com.beezy.virtual_invoices_sync.model.SupplierDataContact;
import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SupplierDataContactConverter implements AttributeConverter<SupplierDataContact, String> {

    private static final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(SupplierDataContact attribute) {
        if (attribute == null) {
            return null;
        }
        return gson.toJson(attribute);
    }

    @Override
    public SupplierDataContact convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return gson.fromJson(dbData, SupplierDataContact.class);
    }
}
