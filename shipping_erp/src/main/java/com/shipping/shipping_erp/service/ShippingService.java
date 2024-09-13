package com.shipping.shipping_erp.service;

import org.springframework.stereotype.Service;

import com.shipping.shipping_erp.converter.AddressConverter;
import com.shipping.shipping_erp.converter.ShippingConverter;
import com.shipping.shipping_erp.dtos.AddressClienteDTO;
import com.shipping.shipping_erp.dtos.ApiDistanceClientDTO;
import com.shipping.shipping_erp.dtos.ShippingDTO;
import com.shipping.shipping_erp.models.AddressDestination;
import com.shipping.shipping_erp.models.AddressOrigin;
import com.shipping.shipping_erp.models.Shipping;
import com.shipping.shipping_erp.repository.ShippingRepository;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;
    private final AddressService addressService;
    private final DistanceShippingService distanceShippingService;

    public ShippingService(ShippingRepository shippingRepository, AddressService addressService,
            DistanceShippingService distanceShippingService) {
        this.shippingRepository = shippingRepository;
        this.addressService = addressService;
        this.distanceShippingService = distanceShippingService;
    }

    public ShippingDTO tosave(String cepOrigin, String cepDestination) {

        var origin = getByAddressOrigin(cepOrigin);
        var destination = getByAddressDestination(cepDestination);
        var distance = calculateDistance(origin, destination);
        var shippingDTO = ShippingConverter.toShippingDTO(
                AddressConverter.toAddressClienteDTO(origin),
                AddressConverter.toAddressClienteDTO(destination),
                distance);

        Shipping shipping = ShippingConverter.toEntity(shippingDTO);
        shipping = shippingRepository.save(shipping);

        return ShippingConverter.toDTO(shipping);
    }

    private AddressOrigin getByAddressOrigin(String cep) {
        AddressClienteDTO address = addressService.getAddressBy(cep);
        AddressOrigin addressConverter = AddressConverter.toAddressOrigin(address);
        return addressConverter;
    }

    private AddressDestination getByAddressDestination(String cep) {
        AddressClienteDTO address = addressService.getAddressBy(cep);
        AddressDestination addressConverter = AddressConverter.toAddressDestination(address);
        return addressConverter;
    }

    private ApiDistanceClientDTO calculateDistance(AddressOrigin origin, AddressDestination destination) {
        return distanceShippingService.calculateDistance(
                origin.getLatitude(),
                origin.getLongitude(),
                destination.getLatitude(),
                destination.getLongitude());
    }
}
