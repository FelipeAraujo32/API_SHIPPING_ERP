package com.shipping.shipping_erp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shipping.shipping_erp.dtos.ApiDistanceClientDTO;
import com.shipping.shipping_erp.service.DistanceShippingService;

import reactor.core.publisher.Mono;

@RestController
public class DistanceController {

    private final DistanceShippingService service;

    public DistanceController(DistanceShippingService service) {
        this.service = service;
    }

    @GetMapping("/api/distance")
    public Mono<ApiDistanceClientDTO> calculateDistance(
            @RequestParam double lat1,
            @RequestParam double lon1,
            @RequestParam double lat2,
            @RequestParam double lon2) {

        return service.calculateDistance(lat1, lon1, lat2, lon2);

    }
}
