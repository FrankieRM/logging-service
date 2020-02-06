package com.bs.exercice.loggingservice.service;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.LoggingConfigurationDAO;
import com.bs.exercice.loggingservice.dao.LoggingValueDAO;
import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.service.validation.LoggingConfigurationValidation;
import com.bs.exercice.loggingservice.service.validation.LoggingValueValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingValueDTO;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class LoggingValueServiceTest {

    @InjectMocks
    private LoggingValueService loggingValueService;

    @Mock
    private LoggingValueDAO loggingValueDAO;

    @Mock
    private LoggingConfigurationDAO loggingConfigurationDAO;

    @Mock
    private LoggingConfigurationValidation loggingConfigurationValidation;

    @Mock
    private LoggingValueValidation loggingValueValidation;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void save() {
        LoggingValueDTO input = buildLoggingValueDTO();
        LoggingConfiguration loggingConfiguration = buildLoggingConfiguration();

        when(loggingConfigurationDAO.getLoggingConfiguration()).thenReturn(loggingConfiguration);
        doNothing().when(loggingConfigurationValidation).validation(loggingConfiguration);
        doNothing().when(loggingValueValidation).validation(input);
        when(loggingValueDAO.save(input)).thenReturn(new LoggingValue());

        LoggingValue result = loggingValueService.save(input);

        assertNotNull(result);
    }
}