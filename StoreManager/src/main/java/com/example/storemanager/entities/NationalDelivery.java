package com.example.storemanager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "nationalDelivery")
public non-sealed class NationalDelivery extends Delivery{

    private double costEasyBox;
}
