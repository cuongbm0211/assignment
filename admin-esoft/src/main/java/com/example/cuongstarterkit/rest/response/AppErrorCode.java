package com.example.cuongstarterkit.rest.response;

import com.example.cuongstarterkit.exceptions.ErrorResponseDto;
import org.springframework.http.HttpStatus;

public final class AppErrorCode {

    public static final ErrorResponseDto PERSON_NOT_FOUND = new ErrorResponseDto("000100",
        "Person not found", HttpStatus.BAD_REQUEST);

}
