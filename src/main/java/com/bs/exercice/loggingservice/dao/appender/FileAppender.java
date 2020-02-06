package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.conf.AppenderProperties;
import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.appender.generator.FileGenerator;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.service.errors.WrongFilePathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static com.bs.exercice.loggingservice.dao.domain.enumeration.LoggingLevel.getLevelByName;

@Component
public class FileAppender extends BaseAppender implements Appender {

    private static final Logger LOGGER = Logger.getLogger(FileAppender.class.getName());

    @Autowired
    private AppenderProperties appenderProperties;

    @Autowired
    private FileGenerator fileGenerator;

    @Override
    public LoggingValue save(LoggingValueDTO loggingValueDTO) {
        try {
            fileGenerator.createLogFile();
            FileHandler fileHandler = new FileHandler(appenderProperties.getFilePath());
            LOGGER.addHandler(fileHandler);
            LOGGER.log(getLevelByName(loggingValueDTO.getLevelName()), loggingValueDTO.getMessageText());

        } catch (IOException e) {
            throw new WrongFilePathException(e.getCause());
        }

        return map(loggingValueDTO);
    }
}