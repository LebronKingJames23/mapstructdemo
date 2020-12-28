package com.example.mapstruct.util;

import com.example.mapstruct.exception.ArgsEmptyException;
import com.example.mapstruct.exception.MapstructException;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Named("Convert")
@Component
public class ConvertMapper {

    private static String[] mapstruct={"map","struct","exception"};

    @Named("nameMapper")
    public String userName(String username){
        return "newhope";
    }

    @Named("passwordMapper")
    public String password(String password){
        return "123";
    }
    @Named("nameExceptionMapper")
    public String toName(String name)throws MapstructException, ArgsEmptyException {
        if(StringUtils.isEmpty(name))throw new ArgsEmptyException("args empty");
        if(Arrays.stream(mapstruct).filter(e->e.equals(name)).count()==0)throw new MapstructException("not found");
        return name+"abc";
    }
}
