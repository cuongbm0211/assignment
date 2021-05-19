package com.example.cuongstarterkit.rest.response;

import com.example.cuongstarterkit.exceptions.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    // not working
    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<BaseResponse<Void>> handleAppExceptions(AppException ex) {
        log.error("GlobalExceptionHandler:", ex);

        String message = ex.getDetailError() == null ? ex.getMessage()
            : ex.getDetailError().toString();

        BaseResponse<Void> data = BaseResponse.ofFailed(ErrorResponse.builder()
            .code(ex.getCode())
            .message(message)
            .httpStatus(ex.getStatus())
            .details(ex.getDetailError()).build());

        return new ResponseEntity<>(data, ex.getStatus());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalServerError(Exception ex) {
//        {
//            "error" : {
//                "status" : 502,
//                "message" : "Bad gateway."
//            }
//        }
//        ResponseEntity.
        return "Internal error";
    }
}
