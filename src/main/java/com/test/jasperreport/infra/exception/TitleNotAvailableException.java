package com.test.jasperreport.infra.exception;

public class TitleNotAvailableException extends RuntimeException {

    public TitleNotAvailableException() {
        super("The title informed is not valid.");
    }
}