package com.beezy.virtual_invoices_sync.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "receipt_taxes")
public class ReceiptTaxes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String taxCode;

    Double taxPercent;

    Integer taxID;

    Double taxAmount;

    Double salesAmountWithTax;

    public ReceiptTaxes() {
    }

    public ReceiptTaxes(Long id, String taxCode, Double taxPercent, Integer taxID, Double taxAmount, Double salesAmountWithTax) {
        this.id = id;
        this.taxCode = taxCode;
        this.taxPercent = taxPercent;
        this.taxID = taxID;
        this.taxAmount = taxAmount;
        this.salesAmountWithTax = salesAmountWithTax;
    }

    public ReceiptTaxes(String taxCode, Double taxPercent, Integer taxID, Double taxAmount, Double salesAmountWithTax) {
        this.taxCode = taxCode;
        this.taxPercent = taxPercent;
        this.taxID = taxID;
        this.taxAmount = taxAmount;
        this.salesAmountWithTax = salesAmountWithTax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public Integer getTaxID() {
        return taxID;
    }

    public void setTaxID(Integer taxID) {
        this.taxID = taxID;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getSalesAmountWithTax() {
        return salesAmountWithTax;
    }

    public void setSalesAmountWithTax(Double salesAmountWithTax) {
        this.salesAmountWithTax = salesAmountWithTax;
    }
}
