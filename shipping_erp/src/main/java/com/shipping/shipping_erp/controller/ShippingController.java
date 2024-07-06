package com.shipping.shipping_erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shipping.shipping_erp.dtos.ShippingDTO;
import com.shipping.shipping_erp.service.ShippingService;

@RestController
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/shipping")
    public ShippingDTO getShipping(@RequestParam String cepOrigin, @RequestParam String cepDestination) {
        return shippingService.tosave(cepOrigin, cepDestination);
    }
}
