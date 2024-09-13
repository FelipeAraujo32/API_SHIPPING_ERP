package com.shipping.shipping_erp.converter;

import com.shipping.shipping_erp.dtos.AddressClienteDTO;
import com.shipping.shipping_erp.dtos.ApiDistanceClientDTO;
import com.shipping.shipping_erp.dtos.ShippingDTO;
import com.shipping.shipping_erp.models.Shipping;

public class ShippingConverter {
    
    public static Shipping toEntity(ShippingDTO dto) {
        Shipping shipping = new Shipping();
        shipping.setOrigin(AddressConverter.toAddressOrigin(dto.getOrigin()));
        shipping.setDestination(AddressConverter.toAddressDestination(dto.getDestination()));
        shipping.setDistance(dto.getDistance());
        shipping.setUnit(dto.getUnit());
        return shipping;
    }

    public static ShippingDTO toDTO(Shipping shipping) {
        ShippingDTO dto = new ShippingDTO();
        dto.setOrigin(AddressConverter.toAddressClienteDTO(shipping.getOrigin()));
        dto.setDestination(AddressConverter.toAddressClienteDTO(shipping.getDestination()));
        dto.setDistance(shipping.getDistance());
        dto.setUnit(shipping.getUnit());
        return dto;
    }

    public static ShippingDTO toShippingDTO(AddressClienteDTO origin, AddressClienteDTO destination, ApiDistanceClientDTO distance) {
        ShippingDTO shippingDTO = new ShippingDTO();
        shippingDTO.setOrigin(origin);
        shippingDTO.setDestination(destination);
        shippingDTO.setDistance(distance.getDistance());
        shippingDTO.setUnit(distance.getUnit());
        return shippingDTO;
    }
}
