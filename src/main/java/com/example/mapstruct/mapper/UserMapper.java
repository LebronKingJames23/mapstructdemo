package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.UserDto;
import com.example.mapstruct.exception.MapstructException;
import com.example.mapstruct.model.Car;
import com.example.mapstruct.model.User;
import com.example.mapstruct.util.ConvertMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

@Mapper(componentModel = "spring", uses = ConvertMapper.class)
public interface UserMapper {
    @Mappings({
            @Mapping(target = "deliveryCode", source = "code"),
            @Mapping(target = "address", constant = "beijing"),
            @Mapping(target = "phone", source = "mobile",defaultValue = "13412345678"),
            @Mapping(target = "password", ignore = true)})
    UserDto baseConvert(User User);

    @Mappings({
            @Mapping(target = "deliveryCode", source = "code"),
            @Mapping(target = "address", constant = "beijing"),
            @Mapping(target = "height", source = "height"),
            @Mapping(target = "weight", expression = "java(com.example.mapstruct.util.ConvertUtil.convertBooleanToString(user.isWeight()))")})
    UserDto coloumnConvert(User user);

    @Mappings({
            @Mapping(target = "deliveryCode", source = "code"),
            @Mapping(target = "address", constant = "beijing"),
            @Mapping(target = "phone", source = "mobile"),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "username", source = "username", qualifiedByName = {"Convert", "nameMapper"})})
    UserDto convertByUseClass(User user);

    @Mappings({
            @Mapping(target = "deliveryCode", source = "code"),
            @Mapping(target = "address", constant = "beijing"),
            @Mapping(target = "phone", source = "mobile"),
            @Mapping(target = "password", qualifiedByName = "password"),
            @Mapping(target = "username", source = "username", qualifiedByName = {"Convert", "nameMapper"})})
    UserDto convertByQualifiedByName(User user);

    @Named(value = "password")
    default String formatDouble(String password) {
        return password + "QulifiedByName";
    }


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "deliveryCode", source = "code"),
            @Mapping(target = "address", source = "deliveryAddress"),
            @Mapping(target = "phone", source = "mobile"),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "username", expression = "java(com.example.mapstruct.util.ConvertUtil.converUser(User.getUsername()))")})
    UserDto convert(User User);

    @Mappings({
            @Mapping(target = "deliveryCode", source = "User.code"),
            @Mapping(target = "address", source = "User.deliveryAddress"),
            @Mapping(target = "phone", source = "User.mobile"),
            @Mapping(target = "carNo", source = "car.num"),
            @Mapping(target = "type", source = "car.type"),
            @Mapping(target = "carPrice", source = "car.price")
    })
    UserDto convertTo(User User, Car car);

    @Mappings({
            @Mapping(target = "deliveryCode", source = "User.code"),
            @Mapping(target = "address", source = "User.deliveryAddress"),
            @Mapping(target = "phone", source = "User.mobile"),
            @Mapping(target = "id", source = "i")
    })
    UserDto convertToString(User User, Integer i);

    UserDto updateUserDtoFromUser(User User, @MappingTarget UserDto userDto);

    @MapMapping(valueDateFormat = "yyyy-mm-dd")
    Map<String, String> convertMap(Map<Long, Date> map);

    @Mapping(target = "name",qualifiedByName = {"Convert","nameExceptionMapper"})
    UserDto testException(User user)throws MapstructException;

    @InheritInverseConfiguration(name = "baseConvert")
    User UserDtoToUser(UserDto userDto);

/*    default  String userConvertMethod(String username){
        return "newhope";
    }*/
}
