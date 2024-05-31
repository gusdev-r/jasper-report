package com.test.jasperreport.infra;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionResponse {
    private HttpStatus status;
    private Boolean success;
    private String message;


    public ExceptionResponse(HttpStatus status, Boolean success, String message) {
        this.status = status;
        this.success = success;
        this.message = message;
    }
}
