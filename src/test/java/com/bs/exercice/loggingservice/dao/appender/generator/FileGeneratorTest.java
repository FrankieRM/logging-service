package com.bs.exercice.loggingservice.dao.appender.generator;

import com.bs.exercice.loggingservice.conf.AppenderProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static com.bs.exercice.loggingservice.utils.UtilTest.TEMPORAL_PATH_FOR_GENERATOR;
import static java.nio.file.Files.delete;
import static java.nio.file.Paths.get;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class FileGeneratorTest {

    @InjectMocks
    private FileGenerator fileGenerator;

    @Mock
    private AppenderProperties appenderProperties;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void createLogFile() throws IOException {
        when(appenderProperties.getFilePath()).thenReturn(TEMPORAL_PATH_FOR_GENERATOR);

        File file = new File(TEMPORAL_PATH_FOR_GENERATOR);

        assertFalse(file.exists());

        fileGenerator.createLogFile();

        assertTrue(file.exists());

        fileGenerator.createLogFile();
    }

    @AfterAll
    static void tearDown() {
        new File(TEMPORAL_PATH_FOR_GENERATOR).deleteOnExit();
    }
}