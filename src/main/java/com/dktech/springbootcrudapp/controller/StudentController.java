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
    public ResponseEntity<String> home(){
        return ResponseEntity.ok().body("This is A Student Api CRUD Project in SpringBoot MVC\n" +
                "\n" +
                "\n" +
                "-> user can get student information with id(primary key)\n" +
                "\n" +
                "eg. GET: http://localhost:8081/students\n" +
                "\n" +
                "-> user can get all the students\n" +
                "\n" +
                "eg. GET: http://localhost:8081/students\n" +
                "\n" +
                "-> user can register \n" +
                "\n" +
                "eg. POST: http://localhost:8081/students\n" +
                "\n" +
                "-> user can update information (id)\n" +
                "\n" +
                "eg. PUT: http://localhost:8081/students/id\n" +
                "\n" +
                "-> user can delete his account(id)\n" +
                "\n" +
                "eg. DELETE: http://localhost:8081/students/6\n" +
                "\n" +
                "@Custom queries:\n" +
                "\n" +
                "-> user can search all the students with name \n" +
                "\n" +
                "eg. GET: http://localhost:8081/students/search?name=ra\n" +
                "\n" +
                "-> Custom Exception Handling\n" +
                "\n" +
                "eg. StudentIdNotFound\n" +
                "\n" +
                "-> Custom Api Response with EntityResponse\n" +
                "\n" +
                "eg. ResponseApi");
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
    public ResponseEntity<ApiResponse> getStudents(){
        List<StudentDTO>dbStudents = studentService.getStudents();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("Success");
        apiResponse.setData(dbStudents);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/students/search")  //http://localhost:8081/students/search?name=aj
    public ResponseEntity<ApiResponse> findStudentsByName(@RequestParam(name = "") String name){
        List<StudentDTO> dbstudents = studentService.findStudentsWithName(name);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(dbstudents);
        apiResponse.setStatus("Success");
        return ResponseEntity.ok(apiResponse);
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
