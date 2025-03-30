package com.beezy.virtual_invoices_sync.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "receipt_payments")
public class ReceiptPayments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String moneyTypeCode;

    Double paymentAmount;

    public ReceiptPayments() {
    }

    public ReceiptPayments(Long id, String moneyTypeCode, Double paymentAmount) {
        this.id = id;
        this.moneyTypeCode = moneyTypeCode;
        this.paymentAmount = paymentAmount;
    }

    public ReceiptPayments(String moneyTypeCode, Double paymentAmount) {
        this.moneyTypeCode = moneyTypeCode;
        this.paymentAmount = paymentAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoneyTypeCode() {
        return moneyTypeCode;
    }

    public void setMoneyTypeCode(String moneyTypeCode) {
        this.moneyTypeCode = moneyTypeCode;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
