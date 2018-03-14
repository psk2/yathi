package com.yathi.Entity;

public class Dipatch {
    private int idDispatch;

    public int getIdDispatch() {
        return idDispatch;
    }

    public void setIdDispatch(int idDispatch) {
        this.idDispatch = idDispatch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getOrderId() {
        return OrderId;
    }

    public void setOrderId(double orderId) {
        OrderId = orderId;
    }

    private String status;
    private double OrderId;
}
