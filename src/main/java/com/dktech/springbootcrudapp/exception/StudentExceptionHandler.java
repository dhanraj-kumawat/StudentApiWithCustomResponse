package com.dktech.springbootcrudapp.exception;

import com.dktech.springbootcrudapp.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentIdNotFoundException.class)
    public ResponseEntity<ApiResponse> StudentIdNotFoundExceptionHandler(StudentIdNotFoundException studentIdNotFoundException){
        System.out.println("Student id Not found Exception occ");
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("Error");
        apiResponse.setApiTimeStamp(new Date());
        apiResponse.setData(null);
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMsg", studentIdNotFoundException.getExceptionMsg());
        apiResponse.setError(errorMap);
        HttpStatus status = HttpStatus.NOT_FOUND;

//        return ResponseEntity.notFound().build();   // if you don't want to show the information
        return ResponseEntity.status(status).body(apiResponse); // custom api response for not found
    }

}
