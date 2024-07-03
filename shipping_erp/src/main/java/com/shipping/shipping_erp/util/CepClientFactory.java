package com.shipping.shipping_erp.util;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.shipping.shipping_erp.client.cep.ApiCepClientImpl;

@Component
public class CepClientFactory{
    
    private final WebClient.Builder webClientBuilder;

    public CepClientFactory(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public ApiCepClientImpl createClient(){
        return new ApiCepClientImpl(webClientBuilder);
    }

    
}
