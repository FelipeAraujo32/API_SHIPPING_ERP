package com.shipping.shipping_erp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shipping.shipping_erp.models.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, UUID>{
    
}
