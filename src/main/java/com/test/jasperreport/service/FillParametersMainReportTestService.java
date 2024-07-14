package com.test.jasperreport.service;

import com.test.jasperreport.domain.Report;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FillParametersMainReportTest {

    public Map<String,Object> fillReportParam(Report parametersFromRequest) {
        //TODO: add a looping to iterate in each element from request and add each element key object

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("author", parametersFromRequest.getAuthor());
        parameters.put("title", parametersFromRequest.getTitle());
        parameters.put("content", parametersFromRequest.getContent());
        return parameters;
    }
}
