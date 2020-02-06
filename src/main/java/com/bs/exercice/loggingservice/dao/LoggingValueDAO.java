package com.bs.exercice.loggingservice.dao;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.appender.Appender;
import com.bs.exercice.loggingservice.dao.appender.generator.AppenderGenerator;
import com.bs.exercice.loggingservice.dao.appender.generator.LevelGenerator;
import com.bs.exercice.loggingservice.dao.appender.validation.LevelValidation;
import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class LoggingValueDAO {

    @Autowired
    private AppenderGenerator appenderGenerator;

    @Autowired
    private LevelGenerator levelGenerator;

    @Autowired
    private LevelValidation levelValidation;

    @Autowired
    private LoggingConfigurationDAO loggingConfigurationDAO;

    public LoggingValue save(LoggingValueDTO loggingValueDTO) {
        LoggingConfiguration loggingConfiguration = loggingConfigurationDAO.getLoggingConfiguration();

        List<String> levels = levelGenerator.generate(loggingConfiguration);

        levelValidation.isLevelEnabled(levels, loggingValueDTO.getLevelName());

        List<Appender> appenders = appenderGenerator.generate(loggingConfiguration);

        return appenders.stream()
                .map(appender -> appender.save(loggingValueDTO))
                .collect(Collectors.toList())
                .get(0);
    }
}