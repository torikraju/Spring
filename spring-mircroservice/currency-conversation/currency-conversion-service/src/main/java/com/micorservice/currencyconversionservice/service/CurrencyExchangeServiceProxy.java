package com.micorservice.currencyconversionservice.service;

import com.micorservice.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "forex-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {

    @RequestMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean retrieveExchangeValue
            (@PathVariable("from") String from, @PathVariable("to") String to);

}
