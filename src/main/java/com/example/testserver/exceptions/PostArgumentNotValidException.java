package com.example.testserver.exceptions;

public class PostArgumentNotValidException extends RuntimeException{

    public PostArgumentNotValidException(String msg){

        super(msg);
    }
}
