package com.shipping.shipping_erp.service;

import org.springframework.stereotype.Service;

import com.shipping.shipping_erp.client.ApiCepClient;
import com.shipping.shipping_erp.dtos.AddressClienteDTO;
import com.shipping.shipping_erp.dtos.ApiCepClientDTO;
import com.shipping.shipping_erp.models.AddressClient;
import com.shipping.shipping_erp.repository.AddressClientRepository;
import com.shipping.shipping_erp.util.CepClientFactory;

import reactor.core.publisher.Mono;

@Service
public class AddressClientService {

    private final CepClientFactory cepClientFactory;

    private final AddressClientRepository repository;

    public AddressClientService(CepClientFactory cepClientFactory, AddressClientRepository repository) {
        this.cepClientFactory = cepClientFactory;
        this.repository = repository;
    }

    public Mono<AddressClienteDTO> convertAddressByCep(String cep) {
        ApiCepClient apiCepClient = cepClientFactory.createClient();
        return apiCepClient.getAddressByCep(cep)
                .map(this::toAddressDTO)
                .map(this::saveAddress);
    }

    private AddressClienteDTO toAddressDTO(ApiCepClientDTO response) {
        AddressClienteDTO aClienteDTO = new AddressClienteDTO();
        aClienteDTO.setStreet(response.getLogradouro());
        aClienteDTO.setNeighborhood(response.getBairro());
        aClienteDTO.setCity(response.getLocalidade());
        aClienteDTO.setState(response.getUf());
        return aClienteDTO;
    }

    private AddressClienteDTO saveAddress(AddressClienteDTO aClienteDTO) {
        AddressClient addressClient = new AddressClient();
        addressClient.setStreet(aClienteDTO.getStreet());
        addressClient.setNeighborhood(aClienteDTO.getNeighborhood());
        addressClient.setCity(aClienteDTO.getCity());
        addressClient.setState(aClienteDTO.getState());
        repository.save(addressClient);
        return aClienteDTO;
    }
}
