package com.example.mircoservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.mircoservices.currencyconversionservice.entities.CurrencyConversion;
import com.example.mircoservices.currencyconversionservice.proxies.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
    private CurrencyExchangeProxy currencyExchangeProxy;
    private RestTemplate restTemplate;
    @Autowired
    public CurrencyConversionController(CurrencyExchangeProxy theCurrencyExchangeProxy, RestTemplate theRestTemplate){
        this.currencyExchangeProxy = theCurrencyExchangeProxy;
        this.restTemplate = theRestTemplate;
    }
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculatedCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId(),from,to,quantity, currencyConversion.getConversionValue(), quantity.multiply(currencyConversion.getConversionValue()),currencyConversion.getEnvironment()+"rest");
    }
    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculatedCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        
        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);
        return new CurrencyConversion(currencyConversion.getId(),from,to,quantity, currencyConversion.getConversionValue(), quantity.multiply(currencyConversion.getConversionValue()),currencyConversion.getEnvironment()+" feign");
    }
}
