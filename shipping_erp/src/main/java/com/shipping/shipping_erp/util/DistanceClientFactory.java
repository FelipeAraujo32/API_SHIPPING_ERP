package com.shipping.shipping_erp.util;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.shipping.shipping_erp.client.distance.ApiDistanceClientImpl;

@Component
public class DistanceClientFactory {
    
    private final WebClient.Builder webClientBuilder;

    public DistanceClientFactory(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public ApiDistanceClientImpl createClient(){
        return new ApiDistanceClientImpl(webClientBuilder);
    }
}
