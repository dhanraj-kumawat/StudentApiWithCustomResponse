package com.dktech.springbootcrudapp.exception;

import lombok.Getter;

@Getter
public class StudentIdNotFoundException extends RuntimeException{
    private String exceptionMsg;
    public StudentIdNotFoundException(){}
    public StudentIdNotFoundException(String exceptionMsg){
        this.exceptionMsg = exceptionMsg;
    }

}
