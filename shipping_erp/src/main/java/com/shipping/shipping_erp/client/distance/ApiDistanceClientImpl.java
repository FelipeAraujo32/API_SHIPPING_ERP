package com.shipping.shipping_erp.client.distance;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.shipping.shipping_erp.dtos.ApiDistanceClientDTO;

@Component
public class ApiDistanceClientImpl implements ApiDistanceClient{

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8082/v1/distance";

    public ApiDistanceClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ApiDistanceClientDTO getDistance(double lat1, double lon1, double lat2, double lon2) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("lat1", lat1)
                .queryParam("lon1", lon1)
                .queryParam("lat2", lat2)
                .queryParam("lon2", lon2)
                .toUriString();

        return restTemplate.getForObject(url, ApiDistanceClientDTO.class);
    }
    
}
