package com.test.jasperreport.controller;

import com.test.jasperreport.domain.Report;
import com.test.jasperreport.infra.exception.AuthorNotAvailableException;
import com.test.jasperreport.infra.exception.ContentNotAvailableException;
import com.test.jasperreport.infra.exception.TitleNotAvailableException;
import com.test.jasperreport.service.ReportService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.coyote.BadRequestException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/report")
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/create")
    public ResponseEntity<byte[]> createReport(@RequestBody @Valid Report reportJsonRequest) throws IOException, JRException {

        var validatedAuthor = reportService.validateAuthor(reportJsonRequest.getAuthor());
        var validatedTitle = reportService.validateTitle(reportJsonRequest.getTitle());
        var validatedContent = reportService.validateContent(reportJsonRequest.getContent());

        InputStream reportStream = new ClassPathResource("reportTemplateTest.jasper").getInputStream();

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("author", validatedAuthor);
        parameters.put("title", validatedTitle);
        parameters.put("content", validatedContent);

        JasperPrint jasperPrint = JasperFillManager
                .fillReport(jasperReport, parameters, new JREmptyDataSource());

        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "report-ntsec.pdf");

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(reportBytes);
    }


}
