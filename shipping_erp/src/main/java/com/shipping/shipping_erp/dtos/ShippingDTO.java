package com.shipping.shipping_erp.dtos;

import java.util.UUID;

public class ShippingDTO {
    
    private UUID shippingId;
    //private UUID customerId;

    private double distance;

    private String unit;

    private AddressClienteDTO origin;

    private AddressClienteDTO destination;

    public ShippingDTO() {
    }

    public UUID getShippingId() {
        return shippingId;
    }

    public void setShippingId(UUID shippingId) {
        this.shippingId = shippingId;
    }

    public AddressClienteDTO getOrigin() {
        return origin;
    }

    public void setOrigin(AddressClienteDTO origin) {
        this.origin = origin;
    }

    public AddressClienteDTO getDestination() {
        return destination;
    }

    public void setDestination(AddressClienteDTO destination) {
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
