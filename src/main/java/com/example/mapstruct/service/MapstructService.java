package com.example.mapstruct.service;


import com.example.mapstruct.dto.StudenDTO;
import com.example.mapstruct.dto.TeacherDto;
import com.example.mapstruct.dto.UserDto;
import com.example.mapstruct.exception.MapstructException;
import com.example.mapstruct.mapper.StudentMapper;
import com.example.mapstruct.mapper.TeacherMapper;
import com.example.mapstruct.mapper.UserMapper;
import com.example.mapstruct.model.Car;
import com.example.mapstruct.model.Student;
import com.example.mapstruct.model.Teacher;
import com.example.mapstruct.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MapstructService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    TeacherMapper teacherMapper;

    public void testSpeed() {
        Student student = Student.builder().name("vigoo").num("1").grades(100).build();
        testBeauUtils(student);
        testMapStruct(student);
    }

    public void testBeauUtils(Student student) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100000; i++) {
            StudenDTO studenDTO = new StudenDTO();
            BeanUtils.copyProperties(student, studenDTO);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public void testMapStruct(Student student) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100000; i++) {
            StudenDTO studenDTO = studentMapper.convertDto(student);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public StudenDTO defaultConvert() {
        Student student = Student.builder().name("vigoo").num("1").grades(100).build();
        return studentMapper.convertDto(student);
    }

    public UserDto ConvertName() {
        User user = User.builder().code("123").deliveryAddress("chengdu").mobile("13412345678").password("abcd").build();
        return userMapper.baseConvert(user);
    }

    public UserDto coloumnConvert() {
        User user = User.builder().code("123").
                deliveryAddress("chengdu").mobile("13412345678").password("abcd").
                height(60).weight(false).
                build();

        return userMapper.coloumnConvert(user);
    }

    public UserDto convertByUseClass() {
        User user = User.builder().code("123").username("vigoo").
                deliveryAddress("chengdu").mobile("13412345678").password("abcd").
                height(60).weight(false).
                build();
        return userMapper.convertByUseClass(user);
    }

    public UserDto convertByQulifieredByName() {
        User user = User.builder().code("123").username("vigoo").
                deliveryAddress("chengdu").mobile("13412345678").password("12.34").
                height(60).weight(false).
                build();
        return userMapper.convertByQualifiedByName(user);
    }

    public Map<String, String> convertCollections() {
        Map<Long, Date> map = new HashMap<>();
        map.put(1L, new Date());
        map.put(2L, new Date());
        return userMapper.convertMap(map);
    }

    public UserDto testException() throws MapstructException {
        User user = User.builder().code("123").username("vigoo").
                deliveryAddress("chengdu").mobile("13412345678").password("12.34").name("vigoo").
                build();
        return userMapper.testException(user);
    }

    public User testRevert() {
        UserDto userDto = UserDto.builder().username("vigoo").address("chengdu")
                .phone("12345678945").password("1234").build();
        return userMapper.UserDtoToUser(userDto);
    }

    public Map<String, TeacherDto> mapperConfig() {
        Teacher teacher = Teacher.builder().name("vigoo").age(20).grades(9).salary(60).subject("chinese").build();
        Map<String, TeacherDto> map = new HashMap<>();
        map.put("convert1", teacherMapper.convert1(teacher));
        map.put("convert2", teacherMapper.convert2(teacher));
        return map;
    }

    public TeacherDto hooks() {
        Teacher teacher = Teacher.builder().name("vigoo").age(20).grades(9).salary(60).subject("chinese").build();
        return teacherMapper.convert1(teacher);
    }

    public TeacherDto mappingTarget() {
        Teacher teacher = Teacher.builder().name("vigoo").age(20).grades(9).salary(60).subject("chinese").build();
        TeacherDto teacherDto = new TeacherDto();
        teacherMapper.mapTarget(teacher, teacherDto);
        return teacherDto;
    }

    public UserDto convertTo() {
        User user = User.builder().name("vigoo").username("huang").password("1234").mobile("12345678910").build();
        Car car = Car.builder().num("123").price("100").type("jian").build();
        return userMapper.convertTo(user, car);
    }
}
