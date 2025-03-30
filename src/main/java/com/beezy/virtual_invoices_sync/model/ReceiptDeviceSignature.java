package com.beezy.virtual_invoices_sync.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "receipt_device_signatures")
public class ReceiptDeviceSignature implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String hash ;

    String signature;

    public ReceiptDeviceSignature() {
    }

    public ReceiptDeviceSignature(Long id, String hash, String signature) {
        this.id = id;
        this.hash = hash;
        this.signature = signature;
    }

    public ReceiptDeviceSignature(String hash, String signature) {
        this.hash = hash;
        this.signature = signature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
