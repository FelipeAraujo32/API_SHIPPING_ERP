package com.shipping.shipping_erp.service;

import org.springframework.stereotype.Service;

import com.shipping.shipping_erp.client.distance.ApiDistanceClient;
import com.shipping.shipping_erp.dtos.ApiDistanceClientDTO;
import com.shipping.shipping_erp.util.DistanceClientFactory;

import reactor.core.publisher.Mono;



@Service
public class ValueShippingService {

    private final DistanceClientFactory distanceClientFactory;

    public ValueShippingService(DistanceClientFactory distanceClientFactory) {
        this.distanceClientFactory = distanceClientFactory;
    }

    public Mono<ApiDistanceClientDTO> calculateDistance(double lat1, double lon1, double lat2, double lon2){
        ApiDistanceClient apiDistanceClient = distanceClientFactory.createClient();
        return apiDistanceClient.getDistance(lat1, lon1, lat2, lon2);
    }
}
