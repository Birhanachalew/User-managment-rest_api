package com.birhan.rest_api.Exception;

import java.util.Date;

public class ErrorResponse {
    private Date timestamp;
    private String status;
    private String message;
    private String details;
    //instantiate new error response
    public ErrorResponse(Date timestamp,String status,String message,String details){
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }
    //set status
    public void setStatus(String status){
        this.status = status;}


    //get status and return it
    public String getStatus(){
        return status;
    }

//set message

    public void setMessage(){
        this.message = message;
    }

    //get message and return it
    public  String getMessage(){
        return message;
    }

    //set details


    public void setDetails(String details) {
        this.details = details;
    }
    //get details and return it
    public String getDetails(){
        return details;
    }
}

