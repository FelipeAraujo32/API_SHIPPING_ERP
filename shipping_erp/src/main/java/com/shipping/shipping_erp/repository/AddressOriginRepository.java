package com.shipping.shipping_erp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipping.shipping_erp.models.AddressOrigin;

@Repository
public interface AddressOriginRepository  extends JpaRepository<AddressOrigin, UUID>{
    
}
