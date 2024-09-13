package com.shipping.shipping_erp.client.distance;

import com.shipping.shipping_erp.dtos.ApiDistanceClientDTO;

public interface ApiDistanceClient {
    ApiDistanceClientDTO getDistance(
        double lat1, 
        double lon1,
        double lat2,
        double lon2
        );
}
