package com.airfare.airfareapp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "airfare")
public class Airfare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "destinycity")
    private String destinyCity;

    @Column(name = "origincity")
    private String originCity;

    @Column(name = "price")
    private String price;

    @Column(name = "note")
    private String note;


}
