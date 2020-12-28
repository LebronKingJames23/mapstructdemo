package com.example.mapstruct.api;

import com.example.mapstruct.dto.StudenDTO;
import com.example.mapstruct.dto.TeacherDto;
import com.example.mapstruct.dto.UserDto;
import com.example.mapstruct.exception.MapstructException;
import com.example.mapstruct.model.Teacher;
import com.example.mapstruct.model.User;
import com.example.mapstruct.service.MapstructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/mapstruct")
public class MapstructController {
    @Autowired
    MapstructService mapstructService;

    @GetMapping("/testSpeed")
    public void testSpeed() {
        mapstructService.testSpeed();
    }

    @GetMapping("/defaultConvert")
    public StudenDTO defaultConvert() {
        return mapstructService.defaultConvert();
    }

    @GetMapping("/subjectsConvert")
    public UserDto convertTo() {
        return mapstructService.convertTo();
    }

    @GetMapping("/ConvertName")
    public UserDto ConvertName() {
        return mapstructService.ConvertName();
    }

    @GetMapping("/coloumnConvert")
    public UserDto coloumnConvert() {
        return mapstructService.coloumnConvert();
    }

    @GetMapping("/convertByUseClass")
    public UserDto convertByUseClass() {
        return mapstructService.convertByUseClass();
    }


    @GetMapping("/convertByQulifieredByName")
    public UserDto convertByQulifieredByName() {
        return mapstructService.convertByQulifieredByName();
    }

    @GetMapping("/convertCollections")
    public Map<String, String> convertCollections() {
        return mapstructService.convertCollections();
    }

    @GetMapping("/testException")
    public UserDto testException() throws MapstructException {
        return mapstructService.testException();
    }

    @GetMapping("/testRevert")
    public User testRevert() {
        return mapstructService.testRevert();
    }

    @GetMapping("/mapperConfig")
    public Map<String, TeacherDto> mapperConfig() {
        return mapstructService.mapperConfig();
    }

    @GetMapping("/hooks")
    public TeacherDto hooks() {
        return mapstructService.hooks();
    }

    @GetMapping("/mappingTarget")
    public TeacherDto mappingTarget() {
        return mapstructService.mappingTarget();
    }

}
