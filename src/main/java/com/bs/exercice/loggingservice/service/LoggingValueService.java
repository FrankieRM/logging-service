package com.bs.exercice.loggingservice.service;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.LoggingConfigurationDAO;
import com.bs.exercice.loggingservice.dao.LoggingValueDAO;
import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.service.validation.LoggingConfigurationValidation;
import com.bs.exercice.loggingservice.service.validation.LoggingValueValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggingValueService {

    @Autowired
    private LoggingValueDAO loggingValueDAO;

    @Autowired
    private LoggingConfigurationDAO loggingConfigurationDAO;

    @Autowired
    private LoggingConfigurationValidation loggingConfigurationValidation;

    @Autowired
    private LoggingValueValidation loggingValueValidation;

    public LoggingValue save(LoggingValueDTO loggingValueDTO) {
        LoggingConfiguration loggingConfiguration = loggingConfigurationDAO.getLoggingConfiguration();
        loggingConfigurationValidation.validation(loggingConfiguration);

        loggingValueValidation.validation(loggingValueDTO);
        return loggingValueDAO.save(loggingValueDTO);
    }
}