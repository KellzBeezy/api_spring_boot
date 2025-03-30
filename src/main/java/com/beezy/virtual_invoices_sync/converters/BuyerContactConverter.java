package com.beezy.virtual_invoices_sync.converters;

import com.beezy.virtual_invoices_sync.model.BuyerContact;
import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BuyerContactConverter implements AttributeConverter<BuyerContact, String> {

    private static final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(BuyerContact attribute) {
        if (attribute == null) {
            return null;
        }
        return gson.toJson(attribute);
    }

    @Override
    public BuyerContact convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return gson.fromJson(dbData, BuyerContact.class);
    }
}
