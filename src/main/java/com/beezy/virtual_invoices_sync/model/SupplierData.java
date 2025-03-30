package com.beezy.virtual_invoices_sync.model;

public class SupplierData {
    String VATNumber;
    String supplierAddress;
    String supplierRegisterName;
    String supplierTIN;
    String supplierTradeName;
    String deviceSerialNumber;
    SupplierDataContact supplierContacts;

    public SupplierData() {
    }

    public SupplierData(String VATNumber, String supplierAddress, String supplierRegisterName, String supplierTIN, String supplierTradeName, String deviceSerialNumber, SupplierDataContact supplierContacts) {
        this.VATNumber = VATNumber;
        this.supplierAddress = supplierAddress;
        this.supplierRegisterName = supplierRegisterName;
        this.supplierTIN = supplierTIN;
        this.supplierTradeName = supplierTradeName;
        this.deviceSerialNumber = deviceSerialNumber;
        this.supplierContacts = supplierContacts;
    }

    public String getVATNumber() {
        return VATNumber;
    }

    public void setVATNumber(String VATNumber) {
        this.VATNumber = VATNumber;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierRegisterName() {
        return supplierRegisterName;
    }

    public void setSupplierRegisterName(String supplierRegisterName) {
        this.supplierRegisterName = supplierRegisterName;
    }

    public String getSupplierTIN() {
        return supplierTIN;
    }

    public void setSupplierTIN(String supplierTIN) {
        this.supplierTIN = supplierTIN;
    }

    public String getSupplierTradeName() {
        return supplierTradeName;
    }

    public void setSupplierTradeName(String supplierTradeName) {
        this.supplierTradeName = supplierTradeName;
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public SupplierDataContact getSupplierContacts() {
        return supplierContacts;
    }

    public void setSupplierContacts(SupplierDataContact supplierContacts) {
        this.supplierContacts = supplierContacts;
    }
}