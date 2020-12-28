package com.example.mapstruct.exception;

public class ArgsEmptyException extends RuntimeException{
    private String msg;

    public ArgsEmptyException(String msg){
        msg=this.msg;
    }
}
