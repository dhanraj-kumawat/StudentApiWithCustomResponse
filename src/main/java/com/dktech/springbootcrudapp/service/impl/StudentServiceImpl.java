package com.dktech.springbootcrudapp.service.impl;

import com.dktech.springbootcrudapp.dao.StudentDao;
import com.dktech.springbootcrudapp.dto.StudentDTO;
import com.dktech.springbootcrudapp.exception.StudentIdNotFoundException;
import com.dktech.springbootcrudapp.model.Student;
import com.dktech.springbootcrudapp.service.StudentService;
import com.dktech.springbootcrudapp.utility.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    public StudentDTO getStudent(long id) {
        Optional<Student> optionalStudent = studentDao.findById(id);
        if (optionalStudent.isEmpty()) {
            throw new StudentIdNotFoundException("Id is invalid!");
        }
        Student student = optionalStudent.get();

        return StudentMapper.toDTO(student);
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students = studentDao.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student dbStudent = students.get(i);
            StudentDTO studentDTO = StudentMapper.toDTO(dbStudent);

            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    @Override
    public List<StudentDTO> findStudentsWithName(String name) {
        List<Student> students = studentDao.findNameIncludes(name);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            StudentDTO studentDTO = StudentMapper.toDTO(student);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.toEntity(studentDTO);
        Student dbStudent = studentDao.save(student);

        return StudentMapper.toDTO(dbStudent);
    }

    @Override
    public StudentDTO deleteStudent(long id) {
        Optional<Student> optionalStudent = studentDao.findById(id);
        Student student = new Student();
        if(optionalStudent.isEmpty()){
            throw new StudentIdNotFoundException("Student with id "+ id + " is invalid!");
        }
        else{
            student = optionalStudent.get();
            studentDao.deleteById(id);
        }
        return StudentMapper.toDTO(student);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentDao.findById(studentDTO.getId());
        StudentDTO responseStudentDto = new StudentDTO();
        if(optionalStudent.isEmpty()){
            return responseStudentDto;
        }
        else{
            Student student = optionalStudent.get();
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());

            Student savedStudent = studentDao.save(student);
            responseStudentDto = StudentMapper.toDTO(savedStudent);
        }
        return responseStudentDto;
    }
}
