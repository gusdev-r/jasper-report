package com.test.jasperreport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class Report {

    @NotBlank
    private String author;
    @NotNull      
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String content;
}
