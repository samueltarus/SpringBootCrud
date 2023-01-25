package com.demo2.demo.util;

import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseDto {
    private Object rows;
    private String message;
    private int httpStatus;

    private boolean success;


}
