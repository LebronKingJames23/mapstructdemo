package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.StudenDTO;
import com.example.mapstruct.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudenDTO convertDto(Student student);
}
