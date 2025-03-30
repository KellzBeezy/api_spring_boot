package com.beezy.virtual_invoices_sync.converters;


import com.beezy.virtual_invoices_sync.model.ReceiptLines;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Converter(autoApply = true)
public class ReceiptLinesConverter implements AttributeConverter<List<ReceiptLines>, String> {
    private static final Gson gson = new Gson();
    private static final Type listType = new TypeToken<List<ReceiptLines>>() {}.getType();

    @Override
    public String convertToDatabaseColumn(List<ReceiptLines> list) {
        String json = gson.toJson(list);
        System.out.println("Generated JSON: " + json);
        return gson.toJson(list);
    }

    @Override
    public List<ReceiptLines> convertToEntityAttribute(String value) {
        return gson.fromJson(value, listType);
    }
}
