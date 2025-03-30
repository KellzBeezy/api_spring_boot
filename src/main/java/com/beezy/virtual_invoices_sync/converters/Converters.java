//package com.beezy.virtual_invoices_sync.converters;
//
//import com.beezy.virtual_invoices_sync.model.ReceiptTaxes;
//import com.google.gson.Gson;
//import jakarta.persistence.Converter;
//
//import java.util.ArrayList;
//
//public class Converters {
//
//        @Converter
//        public static Buyer fromString(String value) {
//            return new Gson().fromJson(value, Buyer.class);
//        }
//
//        @Converter
//        public static String buyerToString(Buyer buyer) {
//            return new Gson().toJson(buyer);
//        }
//
//        @Converter
//        public static CreditDebitNote creditDebitNoteFromString(String value) {
//            return new Gson().fromJson(value, CreditDebitNote.class);
//        }
//
//        @Converter
//        public static String creditDebitNoteToString(CreditDebitNote note) {
//            return new Gson().toJson(note);
//        }
//
//        @Converter
//        public static ReceiptDeviceSignature receiptDeviceSignatureFromString(String value) {
//            return new Gson().fromJson(value, ReceiptDeviceSignature.class);
//        }
//
//        @Converter
//        public static String receiptDeviceSignatureToString(ReceiptDeviceSignature signature) {
//            return new Gson().toJson(signature);
//        }
//
//        @Converter
//        public static ArrayList<ReceiptLines> receiptLinesFromString(String value) {
//            Type listType = new TypeToken<ArrayList<ReceiptLines>>() {}.getType();
//            return new Gson().fromJson(value, listType);
//        }
//
//        @Converter
//        public static String receiptLinesToString(ArrayList<ReceiptLines> list) {
//            return new Gson().toJson(list);
//        }
//
//        @Converter
//        public static ArrayList<ReceiptTaxes> receiptTaxesFromString(String value) {
//            Type listType = new TypeToken<ArrayList<ReceiptTaxes>>() {}.getType();
//            return new Gson().fromJson(value, listType);
//        }
//
//
//        @Converter
//        public static String receiptTaxesToString(ArrayList<ReceiptTaxes> list) {
//            return new Gson().toJson(list);
//        }
//
//
//        @Converter
//        public static ArrayList<ReceiptPayments> receiptPaymentsFromString(String value) {
//            Type listType = new TypeToken<ArrayList<ReceiptPayments>>() {}.getType();
//            return new Gson().fromJson(value, listType);
//        }
//
//        @Converter
//        public static String receiptPaymentsToString(ArrayList<ReceiptPayments> list) {
//            return new Gson().toJson(list);
//        }
//    }
//
//}
