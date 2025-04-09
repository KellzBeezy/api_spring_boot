package com.beezy.virtual_invoices_sync.model.composte;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InvoiceNoDeviceId implements Serializable {

    private String device;
    private String invoice;

    // Default constructor
    public InvoiceNoDeviceId() {}

    public InvoiceNoDeviceId(String deviceId, String invoiceNumber) {
        this.device = deviceId;
        this.invoice = invoiceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceNoDeviceId that = (InvoiceNoDeviceId) o;
        return Objects.equals(device, that.device) &&
                Objects.equals(invoice, that.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(device, invoice);
    }
}
