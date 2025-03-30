package com.beezy.virtual_invoices_sync.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "receipt_lines")
public class ReceiptLines implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String receiptLineType;

    Integer receiptLineNo;

    String receiptLineHSCode;

    String receiptLineName;

    Double receiptLinePrice;

    Double receiptLineQuantity;

    Double receiptLineTotal;

    String taxCode;

    Double taxPercent;

    Integer taxID;

    public ReceiptLines(Long id, String receiptLineType, Integer receiptLineNo, String receiptLineHSCode, String receiptLineName, Double receiptLinePrice, Double receiptLineQuantity, Double receiptLineTotal, String taxCode, Double taxPercent, Integer taxID) {
        this.id = id;
        this.receiptLineType = receiptLineType;
        this.receiptLineNo = receiptLineNo;
        this.receiptLineHSCode = receiptLineHSCode;
        this.receiptLineName = receiptLineName;
        this.receiptLinePrice = receiptLinePrice;
        this.receiptLineQuantity = receiptLineQuantity;
        this.receiptLineTotal = receiptLineTotal;
        this.taxCode = taxCode;
        this.taxPercent = taxPercent;
        this.taxID = taxID;
    }

    public ReceiptLines(String receiptLineType, Integer receiptLineNo, String receiptLineHSCode, String receiptLineName, Double receiptLinePrice, Double receiptLineQuantity, Double receiptLineTotal, String taxCode, Double taxPercent, Integer taxID) {
        this.receiptLineType = receiptLineType;
        this.receiptLineNo = receiptLineNo;
        this.receiptLineHSCode = receiptLineHSCode;
        this.receiptLineName = receiptLineName;
        this.receiptLinePrice = receiptLinePrice;
        this.receiptLineQuantity = receiptLineQuantity;
        this.receiptLineTotal = receiptLineTotal;
        this.taxCode = taxCode;
        this.taxPercent = taxPercent;
        this.taxID = taxID;
    }

    public ReceiptLines() {
    }

    public String getReceiptLineType() {
        return receiptLineType;
    }

    public void setReceiptLineType(String receiptLineType) {
        this.receiptLineType = receiptLineType;
    }

    public Integer getReceiptLineNo() {
        return receiptLineNo;
    }

    public void setReceiptLineNo(Integer receiptLineNo) {
        this.receiptLineNo = receiptLineNo;
    }

    public String getReceiptLineHSCode() {
        return receiptLineHSCode;
    }

    public void setReceiptLineHSCode(String receiptLineHSCode) {
        this.receiptLineHSCode = receiptLineHSCode;
    }

    public String getReceiptLineName() {
        return receiptLineName;
    }

    public void setReceiptLineName(String receiptLineName) {
        this.receiptLineName = receiptLineName;
    }

    public Double getReceiptLinePrice() {
        return receiptLinePrice;
    }

    public void setReceiptLinePrice(Double receiptLinePrice) {
        this.receiptLinePrice = receiptLinePrice;
    }

    public Double getReceiptLineQuantity() {
        return receiptLineQuantity;
    }

    public void setReceiptLineQuantity(Double receiptLineQuantity) {
        this.receiptLineQuantity = receiptLineQuantity;
    }

    public Double getReceiptLineTotal() {
        return receiptLineTotal;
    }

    public void setReceiptLineTotal(Double receiptLineTotal) {
        this.receiptLineTotal = receiptLineTotal;
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
}

