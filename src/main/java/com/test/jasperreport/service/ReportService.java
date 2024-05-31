package com.test.jasperreport.service;

import com.test.jasperreport.infra.exception.AuthorNotAvailableException;
import com.test.jasperreport.infra.exception.ContentNotAvailableException;
import com.test.jasperreport.infra.exception.TitleNotAvailableException;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    public String validateAuthor(String author) {
        if (author.isBlank() || author.length() < 3 || author.length() > 30) {
            throw new AuthorNotAvailableException();
        } else {
            return author;
        }
    }
    public String validateTitle(String title) {
        if (title.isBlank() || title.length() < 3 || title.length() > 20) {
            throw new TitleNotAvailableException();
        } else {
            return title;
        }
    }
    public String validateContent(String content) {
        if (content.isBlank() || content.length() < 3 || content.length() > 150) {
            throw new ContentNotAvailableException();
        } else {
            return content;
        }
    }
}
