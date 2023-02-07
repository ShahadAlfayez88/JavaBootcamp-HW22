package com.example.springday13.Exception;

public class ApiException extends RuntimeException{

    public ApiException(String message){
        super(message);
    }
}
