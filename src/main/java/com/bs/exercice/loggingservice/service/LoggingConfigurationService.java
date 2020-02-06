package com.bs.exercice.loggingservice.service;

import com.bs.exercice.loggingservice.dao.LoggingConfigurationDAO;
import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.service.validation.LoggingConfigurationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggingConfigurationService {

    @Autowired
    private LoggingConfigurationDAO loggingConfigurationDAO;

    @Autowired
    private LoggingConfigurationValidation loggingConfigurationValidation;

    public LoggingConfiguration save(LoggingConfiguration loggingConfiguration) {
        loggingConfigurationValidation.validation(loggingConfiguration);
        return loggingConfigurationDAO.save(loggingConfiguration);
    }
}