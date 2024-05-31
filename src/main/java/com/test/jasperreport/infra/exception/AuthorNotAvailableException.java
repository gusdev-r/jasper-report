package com.test.jasperreport.infra.exception;

public class AuthorNotAvailableException extends RuntimeException {

    public AuthorNotAvailableException() {
        super("The author informed is not valid.");
    }
}
