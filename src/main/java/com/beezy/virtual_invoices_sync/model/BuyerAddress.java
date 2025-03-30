package com.beezy.virtual_invoices_sync.model;

import com.beezy.virtual_invoices_sync.converters.BuyerAddressConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BuyerAddress implements Serializable {

//    @Column(columnDefinition = "TEXT") // Store JSON as text
//    @Convert(converter = BuyerAddressConverter.class)
    String province;

//    @Column(columnDefinition = "TEXT") // Store JSON as text
//    @Convert(converter = BuyerAddressConverter.class)
    String city;

//    @Column(columnDefinition = "TEXT") // Store JSON as text
//    @Convert(converter = BuyerAddressConverter.class)
    String street;

//    @Column(columnDefinition = "TEXT") // Store JSON as text
//    @Convert(converter = BuyerAddressConverter.class)
    String houseNo;

    public BuyerAddress() {
    }

    public BuyerAddress(Long id, String province, String city, String street, String houseNo) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
    }

    public BuyerAddress(String province, String city, String street, String houseNo) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
}
