package com.dktech.springbootcrudapp.utility.mapper;

import com.dktech.springbootcrudapp.dto.StudentDTO;
import com.dktech.springbootcrudapp.model.Student;

public class StudentMapper {
    public static StudentDTO toDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }

    public static Student toEntity(StudentDTO studentDTO){
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());

        return student;
    }

}
