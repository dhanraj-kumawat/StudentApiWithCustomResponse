package com.dktech.springbootcrudapp.service;

import com.dktech.springbootcrudapp.dto.StudentDTO;
import java.util.List;


public interface StudentService {
    StudentDTO getStudent(long id);
    List<StudentDTO> getStudents();

    List<StudentDTO> findStudentsWithName(String name);

    StudentDTO saveStudent(StudentDTO studentDTO);

    StudentDTO deleteStudent(long id);

    StudentDTO updateStudent(StudentDTO studentDTO);
}
