package com.shipping.shipping_erp.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.shipping.shipping_erp.dtos.ApiCepClientDTO;

import reactor.core.publisher.Mono;

@Component
public class ApiCepClientImpl implements ApiCepClient{

    private final WebClient webClient;

    public ApiCepClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://viacep.com.br/ws")
                .build();
    }

    public Mono<ApiCepClientDTO> getAddressByCep(String cep){
        return this.webClient.get()
            .uri("/{cep}/json", cep)
            .retrieve()
            .bodyToMono(ApiCepClientDTO.class);
    }
}
