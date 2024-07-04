package com.shipping.shipping_erp.models;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "shipping")
@Table(name = "shippings")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID shippingId;
    private UUID customerId;

    @ManyToOne(cascade = CascadeType.ALL)
    private AddressOrigin origin;

    @ManyToOne(cascade = CascadeType.ALL)
    private AddressDestination destination;

    @OneToOne(cascade = CascadeType.ALL)
    private DistanceShipping value_shipping;

}
