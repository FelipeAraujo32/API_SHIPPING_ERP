package com.shipping.shipping_erp.service;

import org.springframework.stereotype.Service;

import com.shipping.shipping_erp.client.distance.ApiDistanceClient;
import com.shipping.shipping_erp.dtos.ApiDistanceClientDTO;


@Service
public class DistanceShippingService {

    private final ApiDistanceClient apiDistanceClient;

    public DistanceShippingService(ApiDistanceClient apiDistanceClient) {
        this.apiDistanceClient = apiDistanceClient;
    }

    public ApiDistanceClientDTO calculateDistance(double lat1, double lon1, double lat2, double lon2){
        return apiDistanceClient.getDistance(lat1, lon1, lat2, lon2);
    }
}
