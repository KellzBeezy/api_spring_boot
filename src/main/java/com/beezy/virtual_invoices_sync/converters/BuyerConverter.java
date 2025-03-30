package com.beezy.virtual_invoices_sync.converters;


import com.beezy.virtual_invoices_sync.model.Buyer;
import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
    public class BuyerConverter implements AttributeConverter<Buyer, String> {
        private static final Gson gson = new Gson();

        @Override
        public String convertToDatabaseColumn(Buyer buyer) {
            return gson.toJson(buyer);
        }

        @Override
        public Buyer convertToEntityAttribute(String value) {
            return gson.fromJson(value, Buyer.class);
        }


}
