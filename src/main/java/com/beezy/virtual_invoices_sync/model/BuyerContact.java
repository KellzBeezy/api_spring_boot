package com.beezy.virtual_invoices_sync.model;

import com.beezy.virtual_invoices_sync.converters.BuyerAddressConverter;
import com.beezy.virtual_invoices_sync.converters.BuyerContactConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Convert(converter = BuyerContactConverter.class)
public class BuyerContact implements Serializable {

    private Long id;

//    @Column(columnDefinition = "TEXT") // Store JSON as text
//    @Convert(converter = BuyerContactConverter.class)
    String phoneNo;

//    @Column(columnDefinition = "TEXT") // Store JSON as text
//    @Convert(converter = BuyerContactConverter.class)
    String email;

    public BuyerContact() {
    }

    public BuyerContact(Long id, String phoneNo, String email) {
        this.id = id;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public BuyerContact(String phoneNo, String email) {
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
