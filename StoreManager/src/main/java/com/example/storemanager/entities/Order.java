package com.example.storemanager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Table(name = "order")
public non-sealed class Order extends GenericEntity{

    static int aux4=0;
    static int totalOrders;
    private double maximumFreeWeight;
    private double costOverWeight;
    private double orderTotalCost;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderReview_id")
    private OrderReview orderReview;


}
