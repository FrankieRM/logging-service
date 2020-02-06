package com.bs.exercice.loggingservice.service;

import com.bs.exercice.loggingservice.dao.LoggingConfigurationDAO;
import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.service.validation.LoggingConfigurationValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class LoggingConfigurationServiceTest {

    @InjectMocks
    private LoggingConfigurationService loggingConfigurationService;

    @Mock
    private LoggingConfigurationDAO loggingConfigurationDAO;

    @Mock
    private LoggingConfigurationValidation loggingConfigurationValidation;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void save() {
        LoggingConfiguration input = buildLoggingConfiguration();

        doNothing().when(loggingConfigurationValidation).validation(input);
        when(loggingConfigurationDAO.save(input)).thenReturn(input);

        LoggingConfiguration result = loggingConfigurationService.save(input);

        assertNotNull(result);
        assertEquals(input, result);
    }
}