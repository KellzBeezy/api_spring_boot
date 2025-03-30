package com.beezy.virtual_invoices_sync.dto;

import com.google.gson.annotations.SerializedName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ReceiptBody {

    InvoiceRequest receipt;

    public ReceiptBody() {
    }

    public ReceiptBody(InvoiceRequest receipt) {
        this.receipt = receipt;
    }

    public InvoiceRequest getReceipt() {
        return receipt;
    }

    public void setReceipt(InvoiceRequest receipt) {
        this.receipt = receipt;
    }
}
