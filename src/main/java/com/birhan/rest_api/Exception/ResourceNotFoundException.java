package com.birhan.rest_api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
    //intialize new exception with parm of message
    public ResourceNotFoundException(String message){
        super(message);
    }
}
