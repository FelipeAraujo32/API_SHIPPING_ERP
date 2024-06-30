package com.shipping.shipping_erp.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "address_client")
@Table(name = "address_client")
public class AddressClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID cepId;
    private String street;
    private String neighborhood;
    private String city;
    private String state;

    @ManyToOne
    private Shipping shipping;

    public AddressClient() {
    }

    public AddressClient(String street, String neighborhood, String city, String state) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
