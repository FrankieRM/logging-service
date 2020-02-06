package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import org.springframework.stereotype.Component;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import static com.bs.exercice.loggingservice.dao.domain.enumeration.LoggingLevel.getLevelByName;

@Component
public class ConsoleAppender extends BaseAppender implements Appender {

    private static final Logger LOGGER = Logger.getLogger(ConsoleAppender.class.getName());

    @Override
    public LoggingValue save(LoggingValueDTO loggingValueDTO) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        LOGGER.addHandler(consoleHandler);
        LOGGER.log(getLevelByName(loggingValueDTO.getLevelName()), loggingValueDTO.getMessageText());
        return map(loggingValueDTO);
    }
}