package com.shipping.shipping_erp.client.cep;

import com.shipping.shipping_erp.dtos.ApiCepClientDTO;

import reactor.core.publisher.Mono;

public interface ApiCepClient {
    Mono<ApiCepClientDTO> getAddressByCep(String cep);
}
