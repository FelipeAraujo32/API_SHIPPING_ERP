package com.shipping.shipping_erp.service;

import org.springframework.stereotype.Service;

import com.shipping.shipping_erp.client.cep.ApiCepClient;
import com.shipping.shipping_erp.dtos.AddressClienteDTO;
import com.shipping.shipping_erp.dtos.ApiCepClientDTO;
import com.shipping.shipping_erp.util.CepClientFactory;

import reactor.core.publisher.Mono;

@Service
public class AddressService {

    private final CepClientFactory cepClientFactory;

    public AddressService(CepClientFactory cepClientFactory) {
        this.cepClientFactory = cepClientFactory;
    }

    public Mono<AddressClienteDTO> convertAddressByCep(String cep) {
        ApiCepClient apiCepClient = cepClientFactory.createClient();
        return apiCepClient.getAddressByCep(cep)
                .map(this::toAddressDTO);
    }

    private AddressClienteDTO toAddressDTO(ApiCepClientDTO response) {
        AddressClienteDTO aClienteDTO = new AddressClienteDTO();
        aClienteDTO.setStreet(response.getAddress());
        aClienteDTO.setNeighborhood(response.getDistrict());
        aClienteDTO.setCity(response.getCity());
        aClienteDTO.setState(response.getState());
        aClienteDTO.setLatitude(response.getLat());
        aClienteDTO.setLongitude(response.getLng());
        return aClienteDTO;
    }

}
