package com.example.mapstruct.mapper;

import com.example.mapstruct.config.TeacherMapperConfig;
import com.example.mapstruct.dto.TeacherDto;
import com.example.mapstruct.model.Teacher;
import org.mapstruct.*;

@Mapper(config = TeacherMapperConfig.class,componentModel = "spring",mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface TeacherMapper {

    TeacherDto convert1(Teacher teacher);
    @Mappings({@Mapping(target = "subject",qualifiedByName = "getSubject")
    ,@Mapping(target = "grades",constant = "8")})
    TeacherDto convert2(Teacher teacher);
    @Named(value = "getSubject")
    default String getSubject(String subject){
        return "English";
    }

    @BeforeMapping()
    default void logbefore(){
        System.out.println("before mapping");
    }
    @AfterMapping()
    default void logAfter(){
        System.out.println("after mapping");
    }

    void mapTarget(Teacher teacher, @MappingTarget TeacherDto teacherDto);
}
