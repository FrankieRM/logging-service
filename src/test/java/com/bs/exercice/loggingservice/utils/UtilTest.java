package com.bs.exercice.loggingservice.utils;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.dao.domain.enumeration.LoggingLevel;
import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public final class UtilTest {

    public static final String LOGGING_LEVEL_MESSAGE_NAME = "MESSAGE";
    public static final String TEMPORAL_PATH = "target/logFile.txt";
    public static final String TEMPORAL_PATH_FOR_GENERATOR = "target/logFileDummy.txt";

    private static final ObjectMapper mapper = createObjectMapper();

    private UtilTest() {
    }

    private static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_EMPTY);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        return mapper.writeValueAsBytes(object);
    }

    public static LoggingConfiguration buildLoggingConfiguration() {
        LoggingConfiguration loggingConfiguration = new LoggingConfiguration();
        loggingConfiguration.setLogToConsole(TRUE);
        loggingConfiguration.setLogToFile(FALSE);
        loggingConfiguration.setLogToDatabase(TRUE);
        loggingConfiguration.setLogMessage(FALSE);
        loggingConfiguration.setLogWarning(TRUE);
        loggingConfiguration.setLogError(FALSE);
        return loggingConfiguration;
    }

    public static LoggingValueDTO buildLoggingValueDTO() {
        LoggingValueDTO loggingValueDTO = new LoggingValueDTO();
        loggingValueDTO.setMessageText("log para prueba");
        loggingValueDTO.setLevelName(LoggingLevel.MESSAGE.name());
        return loggingValueDTO;
    }
}