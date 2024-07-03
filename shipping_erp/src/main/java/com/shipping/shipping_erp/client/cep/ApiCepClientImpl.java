package com.shipping.shipping_erp.client.cep;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.shipping.shipping_erp.dtos.ApiCepClientDTO;

import reactor.core.publisher.Mono;

@Component
public class ApiCepClientImpl implements ApiCepClient{

    private final WebClient webClient;

    public ApiCepClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://cep.awesomeapi.com.br/json")
                .build();
    }

    public Mono<ApiCepClientDTO> getAddressByCep(String cep){
        return this.webClient.get()
            .uri("/{cep}", cep)
            .retrieve()
            .bodyToMono(ApiCepClientDTO.class);
    }
}
