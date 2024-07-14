package com.test.jasperreport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class Report {

    @NotBlank
    @Size(min = 3)
    private String author;
    @NotNull      
    @NotBlank
    @Size(min = 3)
    private String title;
    @NotNull
    @NotBlank
    @Size(min = 20)
    private String content;
    @NotNull
    @NotBlank
    @Size(min = 20)
    private String description;
}
