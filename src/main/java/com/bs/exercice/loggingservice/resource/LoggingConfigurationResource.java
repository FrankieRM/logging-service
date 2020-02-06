package com.bs.exercice.loggingservice.resource;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.service.LoggingConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "logging-configuration")
public class LoggingConfigurationResource {

    @Autowired
    private LoggingConfigurationService loggingConfigurationService;

    @PostMapping("/configuration")
    public ResponseEntity<LoggingConfiguration> createConfiguration(@RequestBody LoggingConfiguration loggingConfiguration) {
        LoggingConfiguration result = loggingConfigurationService.save(loggingConfiguration);
        return status(CREATED).body(result);
    }
}