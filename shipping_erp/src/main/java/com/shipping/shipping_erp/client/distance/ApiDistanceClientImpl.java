package com.shipping.shipping_erp.client.distance;

import org.springframework.web.reactive.function.client.WebClient;

import com.shipping.shipping_erp.dtos.ApiDistanceClientDTO;

import reactor.core.publisher.Mono;

public class ApiDistanceClientImpl implements ApiDistanceClient{

    private final WebClient webClient;

    public ApiDistanceClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }

    @Override
    public Mono<ApiDistanceClientDTO> getDistance(double lat1, double lon1, double lat2, double lon2) {
        return this.webClient.get()
            .uri("/v1/distance?lat1={lat1}&lon1={lon1}&lat2={lat2}&lon2={lon2}", lat1, lon1, lat2, lon2)
            .retrieve()
            .bodyToMono(ApiDistanceClientDTO.class);
    }
    
}
