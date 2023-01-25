package com.demo2.demo.util;

import org.springframework.stereotype.Service;

@Service
public class ResponseService
{
    public ResponseDto formulateResponseDto(Object data, String message, int httpStatus, boolean success){
        return new ResponseDto(data,message,httpStatus,success);
    }
}
