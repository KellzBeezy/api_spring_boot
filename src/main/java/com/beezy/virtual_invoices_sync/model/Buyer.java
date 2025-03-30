package com.beezy.virtual_invoices_sync.model;

import com.beezy.virtual_invoices_sync.converters.BuyerAddressConverter;
import com.beezy.virtual_invoices_sync.converters.BuyerContactConverter;
import com.beezy.virtual_invoices_sync.converters.BuyerConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "buyer_details")
public class Buyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String buyerRegisterName;

    String buyerTradeName;

    String buyerTIN;

    String vatNumber;

    @Convert(converter = BuyerContactConverter.class)
    BuyerContact buyerContacts;

    @Convert(converter = BuyerAddressConverter.class)
    BuyerAddress buyerAddress;

    public Buyer() {
    }

    public Buyer(Long id, String buyerRegisterName, String buyerTradeName, String buyerTIN, String vatNumber, BuyerContact buyerContacts, BuyerAddress buyerAddress) {
        this.id = id;
        this.buyerRegisterName = buyerRegisterName;
        this.buyerTradeName = buyerTradeName;
        this.buyerTIN = buyerTIN;
        this.vatNumber = vatNumber;
        this.buyerContacts = buyerContacts;
        this.buyerAddress = buyerAddress;
    }

    public Buyer(String buyerRegisterName, String buyerTradeName, String buyerTIN, String vatNumber, BuyerContact buyerContacts, BuyerAddress buyerAddress) {
        this.buyerRegisterName = buyerRegisterName;
        this.buyerTradeName = buyerTradeName;
        this.buyerTIN = buyerTIN;
        this.vatNumber = vatNumber;
        this.buyerContacts = buyerContacts;
        this.buyerAddress = buyerAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyerRegisterName() {
        return buyerRegisterName;
    }

    public void setBuyerRegisterName(String buyerRegisterName) {
        this.buyerRegisterName = buyerRegisterName;
    }

    public String getBuyerTradeName() {
        return buyerTradeName;
    }

    public void setBuyerTradeName(String buyerTradeName) {
        this.buyerTradeName = buyerTradeName;
    }

    public String getBuyerTIN() {
        return buyerTIN;
    }

    public void setBuyerTIN(String buyerTIN) {
        this.buyerTIN = buyerTIN;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public BuyerContact getBuyerContacts() {
        return buyerContacts;
    }

    public void setBuyerContacts(BuyerContact buyerContacts) {
        this.buyerContacts = buyerContacts;
    }

    public BuyerAddress getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(BuyerAddress buyerAddress) {
        this.buyerAddress = buyerAddress;
    }
}
