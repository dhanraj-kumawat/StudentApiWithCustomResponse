package com.dktech.springbootcrudapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApiResponse {
    private  String status;
    private Date apiTimeStamp;
    private String path;
    private Object data;
    private Object error;

    public ApiResponse(){
        this.apiTimeStamp = new Date();
    }
}
