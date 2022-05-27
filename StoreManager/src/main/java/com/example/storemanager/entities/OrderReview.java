package com.example.storemanager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "orderReview")
public non-sealed class OrderReview extends GenericEntity{

    private int deliveryReview; //from 0 to 5
    private int distributorReview;
    private int productsReview;
    private String commentary;
}
