package com.example.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private String teacherName;
    private Integer teacherAge;
    private String salaries;
    private String subject;
    private Integer grades;
}
