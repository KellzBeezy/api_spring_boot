package com.beezy.virtual_invoices_sync.model;

import jakarta.persistence.*;

@Entity()
@Table(name = "receiptVerification")
public class ReceiptVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer receiptGlobalNumber;
    String invoiceNumber;
    String receiptFdmsSignature;
    String verificationCode;
    String qrCode;
    String revmaxSignature;
    Double  receiptTotal;
    Integer fiscalDayNumber;

    public ReceiptVerification() {
    }

    public ReceiptVerification(Integer receiptGlobalNumber, String invoiceNumber, String receiptFdmsSignature, String verificationCode, String qrCode, String revmaxSignature, Double receiptTotal, Integer fiscalDayNumber) {
        this.receiptGlobalNumber = receiptGlobalNumber;
        this.invoiceNumber = invoiceNumber;
        this.receiptFdmsSignature = receiptFdmsSignature;
        this.verificationCode = verificationCode;
        this.qrCode = qrCode;
        this.revmaxSignature = revmaxSignature;
        this.receiptTotal = receiptTotal;
        this.fiscalDayNumber = fiscalDayNumber;
    }

    public ReceiptVerification(Integer id, Integer receiptGlobalNumber, String invoiceNumber, String receiptFdmsSignature, String verificationCode, String qrCode, String revmaxSignature, Double receiptTotal, Integer fiscalDayNumber) {
        this.id = id;
        this.receiptGlobalNumber = receiptGlobalNumber;
        this.invoiceNumber = invoiceNumber;
        this.receiptFdmsSignature = receiptFdmsSignature;
        this.verificationCode = verificationCode;
        this.qrCode = qrCode;
        this.revmaxSignature = revmaxSignature;
        this.receiptTotal = receiptTotal;
        this.fiscalDayNumber = fiscalDayNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReceiptGlobalNumber() {
        return receiptGlobalNumber;
    }

    public void setReceiptGlobalNumber(Integer receiptGlobalNumber) {
        this.receiptGlobalNumber = receiptGlobalNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getReceiptFdmsSignature() {
        return receiptFdmsSignature;
    }

    public void setReceiptFdmsSignature(String receiptFdmsSignature) {
        this.receiptFdmsSignature = receiptFdmsSignature;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getRevmaxSignature() {
        return revmaxSignature;
    }

    public void setRevmaxSignature(String revmaxSignature) {
        this.revmaxSignature = revmaxSignature;
    }

    public Double getReceiptTotal() {
        return receiptTotal;
    }

    public void setReceiptTotal(Double receiptTotal) {
        this.receiptTotal = receiptTotal;
    }

    public Integer getFiscalDayNumber() {
        return fiscalDayNumber;
    }

    public void setFiscalDayNumber(Integer fiscalDayNumber) {
        this.fiscalDayNumber = fiscalDayNumber;
    }

    @Override
    public String toString() {
        return "ReceiptVerification{" +
                "id=" + id +
                ", receiptGlobalNumber=" + receiptGlobalNumber +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", receiptFdmsSignature='" + receiptFdmsSignature + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", revmaxSignature='" + revmaxSignature + '\'' +
                ", receiptTotal=" + receiptTotal +
                ", fiscalDayNumber=" + fiscalDayNumber +
                '}';
    }
}
