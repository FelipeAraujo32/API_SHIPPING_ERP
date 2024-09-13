package com.shipping.shipping_erp.client.cep;

import com.shipping.shipping_erp.dtos.ApiCepClientDTO;


public interface ApiCepClient {
    ApiCepClientDTO getAddressByCep(String cep);
}
