package com.shipping.shipping_erp.client.distance;

import com.shipping.shipping_erp.dtos.ApiDistanceClientDTO;

import reactor.core.publisher.Mono;

public interface ApiDistanceClient {
    Mono<ApiDistanceClientDTO> getDistance(
        double lat1, 
        double lon1,
        double lat2,
        double lon2
        );
}
