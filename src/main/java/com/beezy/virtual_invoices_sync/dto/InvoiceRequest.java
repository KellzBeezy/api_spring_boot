package com.beezy.virtual_invoices_sync.dto;

import com.beezy.virtual_invoices_sync.converters.*;
import com.beezy.virtual_invoices_sync.model.*;
import jakarta.persistence.Convert;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.util.List;

public record InvoiceRequest(
        Long id,

        String deviceId,
        @NotNull @NotBlank
        String receiptType,
        @NotNull @NotBlank
        String receiptCurrency,
        @NotNull @NotBlank
        Integer receiptCounter,
        @NotNull @NotBlank
        Integer receiptGlobalNo,
        @NotNull @NotBlank
        String invoiceNo,

        @Convert(converter = BuyerConverter.class)
        Buyer buyerData,

        String receiptNotes,
        @NotNull @NotBlank
        String receiptDate,

        @Convert(converter = CreditDebitNoteConverter.class)
        CreditDebitNote creditDebitNote,

        @NotNull @NotBlank
        Boolean receiptLinesTaxInclusive,

        @Convert(converter = ReceiptLinesConverter.class)
        @NotNull @NotEmpty
        List<ReceiptLines> receiptLines,

        @Convert(converter = ReceiptTaxesConverter.class)
        @NotNull @NotEmpty
        List<ReceiptTaxes> receiptTaxes,

        @Convert(converter = ReceiptPaymentsConverter.class)
        @NotNull @NotEmpty
        List<ReceiptPayments> receiptPayments,

        @NotNull @NotBlank
        Double receiptTotal,
        @NotNull @NotBlank
        String receiptPrintForm,

        @Convert(converter = ReceiptDeviceSignatureConverter.class)
        @NotNull @NotBlank
        ReceiptDeviceSignature receiptDeviceSignature,

        @Convert(converter = SupplierDataConverter.class)
        @NotNull @NotBlank
        SupplierData supplierData

) {
}
