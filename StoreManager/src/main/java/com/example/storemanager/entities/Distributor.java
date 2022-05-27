package com.example.storemanager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "distributor")
public non-sealed class Distributor extends GenericEntity{

    static int totalDistributors;
    private int rating;
}
