package com.bs.exercice.loggingservice.dao.mapper;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;

class LoggingConfigurationMapperTest {

    @InjectMocks
    private LoggingConfigurationMapper loggingConfigurationMapper;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void getInitialLoggingConfiguration() {
        LoggingConfiguration result = loggingConfigurationMapper.getInitialLoggingConfiguration();

        assertNotNull(result);
        assertTrue(result.isLogToConsole());
        assertTrue(result.isLogToFile());
        assertTrue(result.isLogToDatabase());
        assertTrue(result.isLogMessage());
        assertTrue(result.isLogWarning());
        assertTrue(result.isLogError());
    }

    @Test
    void map() {
        LoggingConfiguration input = buildLoggingConfiguration();
        LoggingConfiguration result = loggingConfigurationMapper.map(input);

        assertNotNull(result);
        assertTrue(result.isLogToConsole());
        assertFalse(result.isLogToFile());
        assertTrue(result.isLogToDatabase());
        assertFalse(result.isLogMessage());
        assertTrue(result.isLogWarning());
        assertFalse(result.isLogError());
    }
}