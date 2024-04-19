package com.example.mircoservices.currencyconversionservice.entities;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionValue;
    private BigDecimal totalCalulatedAmt;
    private String environment;
    
    public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionValue,
            BigDecimal totalCalulatedAmt, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.conversionValue = conversionValue;
        this.totalCalulatedAmt = totalCalulatedAmt;
        this.environment = environment;
    }

    public CurrencyConversion() {
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
    public BigDecimal getQuantity() {
        return quantity;
    }
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getTotalCalulatedAmt() {
        return totalCalulatedAmt;
    }
    public void setTotalCalulatedAmt(BigDecimal totalCalulatedAmt) {
        this.totalCalulatedAmt = totalCalulatedAmt;
    }
    public String getEnvironment() {
        return environment;
    }
    public void setEnvironment(String environmnet) {
        this.environment = environmnet;
    }
    
}
