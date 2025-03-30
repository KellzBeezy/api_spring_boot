package com.beezy.virtual_invoices_sync.model;

import com.beezy.virtual_invoices_sync.converters.BuyerContactConverter;
import com.beezy.virtual_invoices_sync.converters.SupplierDataContactConverter;
import jakarta.persistence.Convert;

@Convert(converter = SupplierDataContactConverter.class)
public class SupplierDataContact {
    String email;
String phoneNo;

    public SupplierDataContact() {
    }

    public SupplierDataContact(String email, String phoneNo) {
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
