package com.shipping.shipping_erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shipping.shipping_erp.dtos.AddressClienteDTO;
import com.shipping.shipping_erp.service.AddressClientService;

import reactor.core.publisher.Mono;

@RestController
public class Controller {
    
    @Autowired
    private AddressClientService service;

    @GetMapping("/address/{cep}")
    public Mono<AddressClienteDTO> getEndereco(@PathVariable String cep) {
        return service.convertAddressByCep(cep);
    }
}
