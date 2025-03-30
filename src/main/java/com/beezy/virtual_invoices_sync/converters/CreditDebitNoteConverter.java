package com.beezy.virtual_invoices_sync.converters;

import com.beezy.virtual_invoices_sync.model.CreditDebitNote;
import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CreditDebitNoteConverter implements AttributeConverter<CreditDebitNote, String> {
    private static final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(CreditDebitNote note) {
        return gson.toJson(note);
    }

    @Override
    public CreditDebitNote convertToEntityAttribute(String value) {
        return gson.fromJson(value, CreditDebitNote.class);
    }
}

