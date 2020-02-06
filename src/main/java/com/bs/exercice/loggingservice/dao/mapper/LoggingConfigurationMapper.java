package com.bs.exercice.loggingservice.dao.mapper;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import org.springframework.stereotype.Component;

import static java.lang.Boolean.TRUE;

@Component
public class LoggingConfigurationMapper {

    public LoggingConfiguration getInitialLoggingConfiguration() {
        LoggingConfiguration loggingConfiguration = new LoggingConfiguration();
        loggingConfiguration.setLogToConsole(TRUE);
        loggingConfiguration.setLogToFile(TRUE);
        loggingConfiguration.setLogToDatabase(TRUE);
        loggingConfiguration.setLogMessage(TRUE);
        loggingConfiguration.setLogWarning(TRUE);
        loggingConfiguration.setLogError(TRUE);
        return loggingConfiguration;
    }

    public LoggingConfiguration map(LoggingConfiguration loggingConfiguration) {
        LoggingConfiguration newLoggingConfiguration = new LoggingConfiguration();
        newLoggingConfiguration.setLogToConsole(loggingConfiguration.isLogToConsole());
        newLoggingConfiguration.setLogToFile(loggingConfiguration.isLogToFile());
        newLoggingConfiguration.setLogToDatabase(loggingConfiguration.isLogToDatabase());
        newLoggingConfiguration.setLogMessage(loggingConfiguration.isLogMessage());
        newLoggingConfiguration.setLogWarning(loggingConfiguration.isLogWarning());
        newLoggingConfiguration.setLogError(loggingConfiguration.isLogError());
        return newLoggingConfiguration;
    }
}