package com.airfare.airfareapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "airfare")
public class Airfare {

    @JoinColumn(name = "user", referencedColumnName = "id")
    private int id_user;

    @Column(name = "destinycity")
    private String destinyCity;

    @Column(name = "origincity")
    private String originCity;

    @Column(name = "price")
    private Double price;

    @Column(name = "depart_date")
    private Date departDate;

    @Column(name = "return_date")
    private Date returnDate;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDestinyCity() {
        return destinyCity;
    }

    public void setDestinyCity(String destinyCity) {
        this.destinyCity = destinyCity;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
