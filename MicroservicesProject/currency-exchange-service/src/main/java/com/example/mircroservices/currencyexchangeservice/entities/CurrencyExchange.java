package com.example.mircroservices.currencyexchangeservice.entities;

import java.math.BigDecimal;

public class CurrencyExchange {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionValue;
    private String environment;
    public CurrencyExchange() {
    }
    public CurrencyExchange(Long id, String from, String to, BigDecimal conversionValue) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionValue = conversionValue;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public BigDecimal getConversionValue() {
        return conversionValue;
    }
    public void setConversionValue(BigDecimal conversionValue) {
        this.conversionValue = conversionValue;
    }
    public String getEnvironment() {
        return environment;
    }
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    


}
