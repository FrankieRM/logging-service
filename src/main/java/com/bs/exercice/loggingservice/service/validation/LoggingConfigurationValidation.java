package com.bs.exercice.loggingservice.service.validation;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.service.errors.InvalidConfigurationException;
import com.bs.exercice.loggingservice.service.errors.LevelNotSpecifiedException;
import org.springframework.stereotype.Component;

@Component
public class LoggingConfigurationValidation {

    public void validation(LoggingConfiguration loggingConfiguration) {
        if (!loggingConfiguration.isLogToConsole()
                && !loggingConfiguration.isLogToFile()
                && !loggingConfiguration.isLogToDatabase()) {
            throw new InvalidConfigurationException();
        }

        if (!loggingConfiguration.isLogMessage()
                && !loggingConfiguration.isLogWarning()
                && !loggingConfiguration.isLogError()) {
            throw new LevelNotSpecifiedException();
        }
    }
}