package com.shipping.shipping_erp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shipping.shipping_erp.models.AddressClient;

public interface AddressClientRepository  extends JpaRepository<AddressClient, UUID>{
    
}
