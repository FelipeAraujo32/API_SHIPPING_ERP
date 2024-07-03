package com.shipping.shipping_erp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipping.shipping_erp.models.ValueShipping;

@Repository
public interface ValueShippingRepository extends JpaRepository<ValueShipping, UUID>{
    
}
