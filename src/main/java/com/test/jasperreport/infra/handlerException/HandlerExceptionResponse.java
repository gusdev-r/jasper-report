package com.test.jasperreport.infra.handlerException;

import com.test.jasperreport.infra.ExceptionResponse;
import com.test.jasperreport.infra.exception.AuthorNotAvailableException;
import com.test.jasperreport.infra.exception.ContentNotAvailableException;
import com.test.jasperreport.infra.exception.TitleNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HandlerExceptionResponse {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(AuthorNotAvailableException.class)
    private ResponseEntity<ExceptionResponse> authorNotAvailable(AuthorNotAvailableException author) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                HttpStatus.BAD_REQUEST,
                false,
                "The author of the report is not acceptable, revise your data."
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(TitleNotAvailableException.class)
    private ExceptionResponse titleNotAvailable(TitleNotAvailableException title) {
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST,
                false,
                "The title of the report is not acceptable, revise your data."
        );
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(ContentNotAvailableException.class)
    private ExceptionResponse authorNotFound(ContentNotAvailableException content) {
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST,
                false,
                "The content of the report is not acceptable, revise your data."
        );
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    private ExceptionResponse nullReportFields(NullPointerException fields) {
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST,
                false,
                "All fields are required to fill the report."
        );
    }
}
