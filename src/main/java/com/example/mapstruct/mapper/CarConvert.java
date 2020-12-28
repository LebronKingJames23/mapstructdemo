package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.CarDto;
import com.example.mapstruct.model.Car;
import com.example.mapstruct.util.ConvertMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses = ConvertMapper.class)
public interface CarConvert {
    @Mappings({@Mapping(source = "miles",target = "miles",numberFormat = "#.00")
            ,@Mapping(source = "speed",target = "speed")
            ,@Mapping(target = "type",qualifiedByName = {"Convert","nameMapper"})
    })
    CarDto carConvert(Car car);
   /* @Named(value = "formatDoubleDef")
    default Double formatDouble(String source) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
    //小数位格式化
       return Double.parseDouble(decimalFormat.format(source)); }*/
}
