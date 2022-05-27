package com.example.storemanager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "internationalDelivery")
public non-sealed class InternationalDelivery extends Delivery{

    private static double customsTaxes;
    private static double costInternationalDelivery;

}
