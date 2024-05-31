package com.test.jasperreport.infra.exception;

public class ContentNotAvailableException extends RuntimeException {

    public ContentNotAvailableException() {
        super("The content informed is not valid.");
    }
    }
