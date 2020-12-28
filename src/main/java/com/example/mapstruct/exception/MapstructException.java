package com.example.mapstruct.exception;

import lombok.Data;

@Data
public class MapstructException extends RuntimeException{

    private String msg;

    public MapstructException(String msg){
      this.msg=msg;
    }
}
