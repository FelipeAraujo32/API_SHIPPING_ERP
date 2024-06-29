package com.shipping.shipping_erp.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "cep_shipping")
@Table(name = "cep_shipping")
public class CepShipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID cepId;

    @ManyToOne
    private Shipping shipping;

}
