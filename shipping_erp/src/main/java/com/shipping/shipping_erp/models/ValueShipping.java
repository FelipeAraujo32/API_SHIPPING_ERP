package com.shipping.shipping_erp.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "value_shipping")
@Table(name = "values_shippings")
public class ValueShipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID valueShiippingID;

    @ManyToOne
    private Shipping shipping;
}
