package com.yathi.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("statusCode")
    private int statusCode;



    @JsonProperty("statusMessage")
    private String statusMessage;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {

        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        System.out.println("status message: "+ statusMessage);
        this.statusMessage = statusMessage;
    }

}
