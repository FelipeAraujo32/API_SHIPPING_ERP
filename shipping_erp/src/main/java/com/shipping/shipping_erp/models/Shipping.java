package com.shipping.shipping_erp.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "shipping")
@Table(name = "shippings")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID shippingId;
    private UUID customerId;
    private String origin;
    private String destination;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ValueShipping> value_shipping;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CepShipping> cep;

    
    

    
}
