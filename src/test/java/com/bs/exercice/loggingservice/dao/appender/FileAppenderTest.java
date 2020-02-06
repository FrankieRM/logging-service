package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.conf.AppenderProperties;
import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.appender.generator.FileGenerator;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.dao.mapper.LoggingValueMapper;
import com.bs.exercice.loggingservice.service.errors.WrongFilePathException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.File;
import java.io.IOException;

import static com.bs.exercice.loggingservice.service.errors.WrongFilePathException.WRONG_FILE_PATH_EXCEPTION_MESSAGE;
import static com.bs.exercice.loggingservice.utils.UtilTest.TEMPORAL_PATH;
import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingValueDTO;
import static java.nio.file.Files.deleteIfExists;
import static java.nio.file.Paths.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class FileAppenderTest {

    private static final String WRONG_PATH = "d:";
    private static final String FILE_CREATED_BY_WRONG_PATH = ".lck";

    @InjectMocks
    private FileAppender fileAppender;

    @Mock
    private AppenderProperties appenderProperties;

    @Mock
    private FileGenerator fileGenerator;

    @Mock
    private LoggingValueMapper loggingValueMapper;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void save() throws IOException {
        LoggingValueDTO input = buildLoggingValueDTO();

        when(appenderProperties.getFilePath()).thenReturn(TEMPORAL_PATH);
        doNothing().when(fileGenerator).createLogFile();
        when(loggingValueMapper.map(input)).thenReturn(new LoggingValue());

        LoggingValue result = fileAppender.save(input);

        assertNotNull(result);
    }

    @Test
    void saveWithWrongFilePathException() throws IOException {
        LoggingValueDTO input = buildLoggingValueDTO();

        doNothing().when(fileGenerator).createLogFile();
        when(appenderProperties.getFilePath()).thenReturn(WRONG_PATH);

        Exception exception = assertThrows(WrongFilePathException.class,
                () -> fileAppender.save(input));

        assertEquals(WRONG_FILE_PATH_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @AfterAll
    static void tearDown() throws IOException {
        new File(TEMPORAL_PATH).deleteOnExit();
        deleteIfExists(get(FILE_CREATED_BY_WRONG_PATH));
    }
}