package com.shipping.shipping_erp.service;
import org.springframework.stereotype.Service;

import com.shipping.shipping_erp.client.cep.ApiCepClient;
import com.shipping.shipping_erp.dtos.AddressClienteDTO;
import com.shipping.shipping_erp.dtos.ApiCepClientDTO;

@Service
public class AddressService {

    private final ApiCepClient cepClient;

    public AddressService(ApiCepClient cepClient) {
        this.cepClient = cepClient;
    }

    private ApiCepClientDTO getAddressByCepAPI(String cep){
        return cepClient.getAddressByCep(cep);
    }

    public AddressClienteDTO getAddressBy(String cep) {
        ApiCepClientDTO apiCepClientDTO = getAddressByCepAPI(cep);
        
        AddressClienteDTO addressClienteDTO = new AddressClienteDTO();
        addressClienteDTO.setStreet(apiCepClientDTO.getAddress());
        addressClienteDTO.setNeighborhood(apiCepClientDTO.getDistrict());
        addressClienteDTO.setCity(apiCepClientDTO.getCity());
        addressClienteDTO.setState(apiCepClientDTO.getState());
        addressClienteDTO.setLatitude(apiCepClientDTO.getLat());
        addressClienteDTO.setLongitude(apiCepClientDTO.getLng());
        return addressClienteDTO;
    }
}