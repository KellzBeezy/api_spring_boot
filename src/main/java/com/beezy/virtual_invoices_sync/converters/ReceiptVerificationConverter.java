package com.beezy.virtual_invoices_sync.converters;

import com.beezy.virtual_invoices_sync.model.ReceiptDeviceSignature;
import com.beezy.virtual_invoices_sync.model.ReceiptVerification;
import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ReceiptVerificationConverter implements AttributeConverter<ReceiptVerification, String> {

  private static final Gson gson = new Gson();

        @Override
        public String convertToDatabaseColumn(ReceiptVerification signature) {
            return gson.toJson(signature);
        }

        @Override
        public ReceiptVerification convertToEntityAttribute(String value) {
            return gson.fromJson(value, ReceiptVerification.class);
        }

}
