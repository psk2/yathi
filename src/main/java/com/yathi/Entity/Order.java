package com.yathi.Entity;

public class Order {
    private double id;
    private int bricks;
    private boolean dispatch;

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    private String statusMessage;


    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public int getBricks() {
        return bricks;
    }

    public void setBricks(int bricks) {
        this.bricks = bricks;
    }

    public boolean isDispatch() {
        System.out.println("dispatch value in isDispatch: "+dispatch);
        return dispatch;
    }

    public void setDispatch(boolean dispatch) {
        System.out.println("dispatch value in setDispatch: "+dispatch);
        this.dispatch = dispatch;
    }



}
