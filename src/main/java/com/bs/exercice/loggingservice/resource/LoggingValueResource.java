package com.bs.exercice.loggingservice.resource;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.service.LoggingValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "logging-value")
public class LoggingValueResource {

    @Autowired
    private LoggingValueService loggingValueService;

    @PostMapping("/value")
    public ResponseEntity<LoggingValue> createCustomer(@RequestBody LoggingValueDTO loggingValueDTO) {
        LoggingValue result = loggingValueService.save(loggingValueDTO);
        return status(CREATED).body(result);
    }
}