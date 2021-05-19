package com.example.cuongstarterkit.rest.response;

import com.example.cuongstarterkit.exceptions.ErrorResponseDto;
import org.springframework.http.HttpStatus;

public final class AppErrorCode {

    public static final ErrorResponseDto USER_NOT_FOUND = new ErrorResponseDto("000100",
        "User not found", HttpStatus.NOT_FOUND);

}
