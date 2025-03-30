package com.beezy.virtual_invoices_sync.converters;

import com.beezy.virtual_invoices_sync.model.ReceiptTaxes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Converter(autoApply = true)
public class ReceiptTaxesConverter implements AttributeConverter<List<ReceiptTaxes>, String> {
    private static final Gson gson = new Gson();
    private static final Type listType = new TypeToken<List<ReceiptTaxes>>() {}.getType();

    @Override
    public String convertToDatabaseColumn(List<ReceiptTaxes> list) {
        return gson.toJson(list);
    }

    @Override
    public List<ReceiptTaxes> convertToEntityAttribute(String value) {
        return gson.fromJson(value, listType);
    }
}

