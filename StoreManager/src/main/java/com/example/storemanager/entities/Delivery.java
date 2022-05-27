package com.example.storemanager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public abstract sealed class Delivery permits InternationalDelivery, NationalDelivery{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int deliveryId;

    protected LocalDate deliveryDate;
    protected Boolean delivered;
}
