package com.example.storemanager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "product")
public non-sealed class Product extends GenericEntity{

    private String name;
    private String category;
    private int price;
    private int weight;
    private int warranty; //how many years does it have warranty
    //private Distributor distributor;
}
