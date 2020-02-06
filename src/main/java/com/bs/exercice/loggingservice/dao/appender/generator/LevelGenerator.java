package com.bs.exercice.loggingservice.dao.appender.generator;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.dao.domain.enumeration.LoggingLevel;
import com.bs.exercice.loggingservice.service.errors.LevelDisabledException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.bs.exercice.loggingservice.dao.domain.enumeration.LoggingLevel.*;

@Component
public class LevelGenerator {

    public List<String> generate(LoggingConfiguration loggingConfiguration) {
        List<String> levels = new ArrayList<>();
        mapLevel(levels, loggingConfiguration.isLogMessage(), MESSAGE);
        mapLevel(levels, loggingConfiguration.isLogWarning(), WARNING);
        mapLevel(levels, loggingConfiguration.isLogError(), ERROR);
        return levels;
    }

    private void mapLevel(List<String> levels, boolean isLog, LoggingLevel level) {
        if (isLog) {
            levels.add(level.name());
        }
    }
}