package com.example.storemanager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "client")
public non-sealed class Client extends GenericEntity{

    static int totalClients;
    private String username;
    private String name;
    private String email;
    private String address;

    //private int juridicPerson;
}
