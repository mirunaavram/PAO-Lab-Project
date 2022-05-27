package com.example.storemanager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract sealed class GenericEntity permits Client,Product,Distributor,Order,OrderReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
}
