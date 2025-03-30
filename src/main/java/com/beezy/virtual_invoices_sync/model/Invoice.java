package com.beezy.virtual_invoices_sync.model;

import com.beezy.virtual_invoices_sync.converters.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity()
@Table(name = "invoices")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private String receiptType;
    @Column( nullable = false)
    private String receiptCurrency;
    @Column( nullable = false)
    private Integer receiptCounter;
    @Column( nullable = false)
    private Integer receiptGlobalNo;
    @Column(unique = true, nullable = false)
    private String invoiceNo;

    @Convert(converter = BuyerConverter.class)
    @Column(columnDefinition = "TEXT")
    private Buyer buyerData;

    private String receiptNotes;
    private String receiptDate;

    @Convert(converter = CreditDebitNoteConverter.class)
    @Column(columnDefinition = "TEXT")
    private CreditDebitNote creditDebitNote;

    private Boolean receiptLinesTaxInclusive;

    @Convert(converter = ReceiptLinesConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<ReceiptLines> receiptLines;

    @Convert(converter = ReceiptTaxesConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<ReceiptTaxes> receiptTaxes;

    @Convert(converter = ReceiptPaymentsConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<ReceiptPayments> receiptPayments;

    @Convert(converter = SupplierDataConverter.class)
    @Column(columnDefinition = "TEXT")
    private SupplierData supplierData;

    private Double receiptTotal;
    private String receiptPrintForm;

    @Convert(converter = ReceiptDeviceSignatureConverter.class)
    @Column(columnDefinition = "TEXT")
    private ReceiptDeviceSignature receiptDeviceSignature;

    public Invoice() {
    }

    public Invoice(Long id, String deviceId, String receiptType, String receiptCurrency, Integer receiptCounter, Integer receiptGlobalNo, String invoiceNo, Buyer buyerData, String receiptNotes, String receiptDate, CreditDebitNote creditDebitNote, Boolean receiptLinesTaxInclusive, List<ReceiptLines> receiptLines, List<ReceiptTaxes> receiptTaxes, List<ReceiptPayments> receiptPayments, SupplierData supplierData, Double receiptTotal, String receiptPrintForm, ReceiptDeviceSignature receiptDeviceSignature) {
        this.id = id;
        this.deviceId = deviceId;
        this.receiptType = receiptType;
        this.receiptCurrency = receiptCurrency;
        this.receiptCounter = receiptCounter;
        this.receiptGlobalNo = receiptGlobalNo;
        this.invoiceNo = invoiceNo;
        this.buyerData = buyerData;
        this.receiptNotes = receiptNotes;
        this.receiptDate = receiptDate;
        this.creditDebitNote = creditDebitNote;
        this.receiptLinesTaxInclusive = receiptLinesTaxInclusive;
        this.receiptLines = receiptLines;
        this.receiptTaxes = receiptTaxes;
        this.receiptPayments = receiptPayments;
        this.supplierData = supplierData;
        this.receiptTotal = receiptTotal;
        this.receiptPrintForm = receiptPrintForm;
        this.receiptDeviceSignature = receiptDeviceSignature;
    }

    public Invoice(String deviceId, String receiptType, String receiptCurrency, Integer receiptCounter, Integer receiptGlobalNo, String invoiceNo, Buyer buyerData, String receiptNotes, String receiptDate, CreditDebitNote creditDebitNote, Boolean receiptLinesTaxInclusive, List<ReceiptLines> receiptLines, List<ReceiptTaxes> receiptTaxes, List<ReceiptPayments> receiptPayments, SupplierData supplierData, Double receiptTotal, String receiptPrintForm, ReceiptDeviceSignature receiptDeviceSignature) {
        this.deviceId = deviceId;
        this.receiptType = receiptType;
        this.receiptCurrency = receiptCurrency;
        this.receiptCounter = receiptCounter;
        this.receiptGlobalNo = receiptGlobalNo;
        this.invoiceNo = invoiceNo;
        this.buyerData = buyerData;
        this.receiptNotes = receiptNotes;
        this.receiptDate = receiptDate;
        this.creditDebitNote = creditDebitNote;
        this.receiptLinesTaxInclusive = receiptLinesTaxInclusive;
        this.receiptLines = receiptLines;
        this.receiptTaxes = receiptTaxes;
        this.receiptPayments = receiptPayments;
        this.supplierData = supplierData;
        this.receiptTotal = receiptTotal;
        this.receiptPrintForm = receiptPrintForm;
        this.receiptDeviceSignature = receiptDeviceSignature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptCurrency() {
        return receiptCurrency;
    }

    public void setReceiptCurrency(String receiptCurrency) {
        this.receiptCurrency = receiptCurrency;
    }

    public Integer getReceiptCounter() {
        return receiptCounter;
    }

    public void setReceiptCounter(Integer receiptCounter) {
        this.receiptCounter = receiptCounter;
    }

    public Integer getReceiptGlobalNo() {
        return receiptGlobalNo;
    }

    public void setReceiptGlobalNo(Integer receiptGlobalNo) {
        this.receiptGlobalNo = receiptGlobalNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Buyer getBuyerData() {
        return buyerData;
    }

    public void setBuyerData(Buyer buyerData) {
        this.buyerData = buyerData;
    }

    public String getReceiptNotes() {
        return receiptNotes;
    }

    public void setReceiptNotes(String receiptNotes) {
        this.receiptNotes = receiptNotes;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public CreditDebitNote getCreditDebitNote() {
        return creditDebitNote;
    }

    public void setCreditDebitNote(CreditDebitNote creditDebitNote) {
        this.creditDebitNote = creditDebitNote;
    }

    public Boolean getReceiptLinesTaxInclusive() {
        return receiptLinesTaxInclusive;
    }

    public void setReceiptLinesTaxInclusive(Boolean receiptLinesTaxInclusive) {
        this.receiptLinesTaxInclusive = receiptLinesTaxInclusive;
    }

    public List<ReceiptLines> getReceiptLines() {
        return receiptLines;
    }

    public void setReceiptLines(List<ReceiptLines> receiptLines) {
        this.receiptLines = receiptLines;
    }

    public List<ReceiptTaxes> getReceiptTaxes() {
        return receiptTaxes;
    }

    public void setReceiptTaxes(List<ReceiptTaxes> receiptTaxes) {
        this.receiptTaxes = receiptTaxes;
    }

    public List<ReceiptPayments> getReceiptPayments() {
        return receiptPayments;
    }

    public void setReceiptPayments(List<ReceiptPayments> receiptPayments) {
        this.receiptPayments = receiptPayments;
    }

    public SupplierData getSupplierData() {
        return supplierData;
    }

    public void setSupplierData(SupplierData supplierData) {
        this.supplierData = supplierData;
    }

    public Double getReceiptTotal() {
        return receiptTotal;
    }

    public void setReceiptTotal(Double receiptTotal) {
        this.receiptTotal = receiptTotal;
    }

    public String getReceiptPrintForm() {
        return receiptPrintForm;
    }

    public void setReceiptPrintForm(String receiptPrintForm) {
        this.receiptPrintForm = receiptPrintForm;
    }

    public ReceiptDeviceSignature getReceiptDeviceSignature() {
        return receiptDeviceSignature;
    }

    public void setReceiptDeviceSignature(ReceiptDeviceSignature receiptDeviceSignature) {
        this.receiptDeviceSignature = receiptDeviceSignature;
    }
}
