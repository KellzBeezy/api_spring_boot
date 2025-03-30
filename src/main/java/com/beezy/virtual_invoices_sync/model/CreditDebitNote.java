package com.beezy.virtual_invoices_sync.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "credit_debit_notes")
public class CreditDebitNote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    BigInteger receiptID;

    Integer deviceID;

    Integer receiptGlobalNo;

    Integer fiscalDayNo;

    public CreditDebitNote() {
    }

    public CreditDebitNote(BigInteger receiptID, Integer deviceID, Integer receiptGlobalNo, Integer fiscalDayNo) {
        this.receiptID = receiptID;
        this.deviceID = deviceID;
        this.receiptGlobalNo = receiptGlobalNo;
        this.fiscalDayNo = fiscalDayNo;
    }

    public CreditDebitNote(Long id, BigInteger receiptID, Integer deviceID, Integer receiptGlobalNo, Integer fiscalDayNo) {
        this.id = id;
        this.receiptID = receiptID;
        this.deviceID = deviceID;
        this.receiptGlobalNo = receiptGlobalNo;
        this.fiscalDayNo = fiscalDayNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(BigInteger receiptID) {
        this.receiptID = receiptID;
    }

    public Integer getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(Integer deviceID) {
        this.deviceID = deviceID;
    }

    public Integer getReceiptGlobalNo() {
        return receiptGlobalNo;
    }

    public void setReceiptGlobalNo(Integer receiptGlobalNo) {
        this.receiptGlobalNo = receiptGlobalNo;
    }

    public Integer getFiscalDayNo() {
        return fiscalDayNo;
    }

    public void setFiscalDayNo(Integer fiscalDayNo) {
        this.fiscalDayNo = fiscalDayNo;
    }
}
