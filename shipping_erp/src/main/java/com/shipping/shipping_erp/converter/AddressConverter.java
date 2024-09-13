package com.shipping.shipping_erp.converter;

import com.shipping.shipping_erp.dtos.AddressClienteDTO;
import com.shipping.shipping_erp.models.AddressDestination;
import com.shipping.shipping_erp.models.AddressOrigin;

public class AddressConverter {
    
    public static AddressOrigin toAddressOrigin(AddressClienteDTO dto) {
        AddressOrigin address = new AddressOrigin();
        address.setStreet(dto.getStreet());
        address.setNeighborhood(dto.getNeighborhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setLatitude(dto.getLatitude());
        address.setLongitude(dto.getLongitude());
        return address;
    }

    public static AddressDestination toAddressDestination(AddressClienteDTO dto) {
        AddressDestination address = new AddressDestination();
        address.setStreet(dto.getStreet());
        address.setNeighborhood(dto.getNeighborhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setLatitude(dto.getLatitude());
        address.setLongitude(dto.getLongitude());
        return address;
    }

    public static AddressClienteDTO toAddressClienteDTO(AddressOrigin address) {
        AddressClienteDTO dto = new AddressClienteDTO();
        dto.setStreet(address.getStreet());
        dto.setNeighborhood(address.getNeighborhood());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setLatitude(address.getLatitude());
        dto.setLongitude(address.getLongitude());
        return dto;
    }

    public static AddressClienteDTO toAddressClienteDTO(AddressDestination address) {
        AddressClienteDTO dto = new AddressClienteDTO();
        dto.setStreet(address.getStreet());
        dto.setNeighborhood(address.getNeighborhood());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setLatitude(address.getLatitude());
        dto.setLongitude(address.getLongitude());
        return dto;
    }
}
