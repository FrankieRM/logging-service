package com.bs.exercice.loggingservice.dao;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.dao.mapper.LoggingConfigurationMapper;
import com.bs.exercice.loggingservice.dao.repository.LoggingConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggingConfigurationDAO {

    @Autowired
    private LoggingConfigurationRepository loggingConfigurationRepository;

    @Autowired
    private LoggingConfigurationMapper loggingConfigurationMapper;

    public LoggingConfiguration getLoggingConfiguration() {
        LoggingConfiguration loggingConfiguration = loggingConfigurationRepository.getInitialLoggingConfiguration();

        if (loggingConfiguration == null) {
            return loggingConfigurationRepository.save(loggingConfigurationMapper.getInitialLoggingConfiguration());
        }

        return loggingConfiguration;
    }

    public LoggingConfiguration save(LoggingConfiguration loggingConfiguration) {
        LoggingConfiguration initialLoggingConfiguration = loggingConfigurationRepository.getInitialLoggingConfiguration();

        if (initialLoggingConfiguration == null) {
            return loggingConfigurationRepository.save(loggingConfigurationMapper.getInitialLoggingConfiguration());
        }

        return loggingConfigurationRepository.save(loggingConfigurationMapper.map(loggingConfiguration));
    }
}