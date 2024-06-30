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
    private List<AddressClient> cep;

    public Shipping() {
    }

    public Shipping(String origin, String destination, List<ValueShipping> value_shipping, List<AddressClient> cep) {
        this.origin = origin;
        this.destination = destination;
        this.value_shipping = value_shipping;
        this.cep = cep;
    }

    public UUID getShippingId() {
        return shippingId;
    }

    public void setShippingId(UUID shippingId) {
        this.shippingId = shippingId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<ValueShipping> getValue_shipping() {
        return value_shipping;
    }

    public void setValue_shipping(List<ValueShipping> value_shipping) {
        this.value_shipping = value_shipping;
    }

    public List<AddressClient> getCep() {
        return cep;
    }

    public void setCep(List<AddressClient> cep) {
        this.cep = cep;
    }

    
    
    

    
}
