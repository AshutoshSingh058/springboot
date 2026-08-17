package com.example.mvc.service;

import com.example.mvc.dto.AddStudentRequestDto;
import com.example.mvc.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {

    StudentDto getStudentById(long id);

    List<StudentDto> getAllStudents();

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
