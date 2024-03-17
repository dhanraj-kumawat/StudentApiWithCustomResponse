package com.dktech.springbootcrudapp.controller;

import com.dktech.springbootcrudapp.dto.ApiResponse;
import com.dktech.springbootcrudapp.dto.StudentDTO;

import com.dktech.springbootcrudapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String hi(){
        return "hello";
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ApiResponse> getStudent(@PathVariable long id ){
        ApiResponse apiResponse = new ApiResponse();
        StudentDTO studentDTO = studentService.getStudent(id);
        if(studentDTO != null) {
            apiResponse.setData(studentDTO);
            apiResponse.setStatus("Success");
            apiResponse.setApiTimeStamp(new Date());
//        apiResponse.setPath(""+this.getClass().getAnnotation(RequestMapping.class).value()[0]);
        }
        return  ResponseEntity.ok().body(apiResponse);

    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/search")  //http://localhost:8081/students/search?name=aj
    public List<StudentDTO> findStudentsByName(@RequestParam(name = "") String name){
        return studentService.findStudentsWithName(name);
    }

    @PostMapping("/students")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
        return studentService.saveStudent(studentDTO);
    }

    @DeleteMapping("/students/{id}")
    public StudentDTO deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/students")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }

}
