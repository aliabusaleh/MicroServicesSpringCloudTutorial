package com.exalt.microservice.currencyconversionservice;

import java.math.BigDecimal;

public class CurrancyConvesionBean {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultipe;
    private BigDecimal quantity;
    private BigDecimal totalAmount;
    private int port;

    public CurrancyConvesionBean(){
    }
    public CurrancyConvesionBean(Long id, String from, String to, BigDecimal conversionMultipe, BigDecimal quantity, BigDecimal totalAmount, int port) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultipe = conversionMultipe;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
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

    public BigDecimal getConversionMultipe() {
        return conversionMultipe;
    }

    public void setConversionMultipe(BigDecimal conversionMultipe) {
        this.conversionMultipe = conversionMultipe;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
