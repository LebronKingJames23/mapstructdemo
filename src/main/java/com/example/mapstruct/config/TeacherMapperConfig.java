package com.example.mapstruct.config;

import com.example.mapstruct.dto.CarDto;
import com.example.mapstruct.dto.TeacherDto;
import com.example.mapstruct.model.Car;
import com.example.mapstruct.model.Teacher;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@MapperConfig
public interface TeacherMapperConfig {
    @Mappings({
            @Mapping(source = "name",target = "teacherName"),
            @Mapping(source = "age",target = "teacherAge"),
            @Mapping(source = "salary",target = "salaries")
    })
    TeacherDto baseConvert(Teacher teacher);
}
