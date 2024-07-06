package com.shipping.shipping_erp.models;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "shipping")
@Table(name = "shippings")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID shippingId;
    //private UUID customerId;

    @ManyToOne(cascade = CascadeType.ALL)
    private AddressOrigin origin;

    @ManyToOne(cascade = CascadeType.ALL)
    private AddressDestination destination;

    private double distance;

    private String unit;

    public Shipping() {
    }

    public Shipping(AddressOrigin origin, AddressDestination destination, double distance, String unit) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.unit = unit;
    }

    public UUID getShippingId() {
        return shippingId;
    }

    public void setShippingId(UUID shippingId) {
        this.shippingId = shippingId;
    }

    public AddressOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(AddressOrigin origin) {
        this.origin = origin;
    }

    public AddressDestination getDestination() {
        return destination;
    }

    public void setDestination(AddressDestination destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    

    

}
