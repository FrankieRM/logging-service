package com.bs.exercice.loggingservice.service.validation;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.service.errors.InvalidConfigurationException;
import com.bs.exercice.loggingservice.service.errors.LevelNotSpecifiedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static com.bs.exercice.loggingservice.service.errors.InvalidConfigurationException.INVALID_CONFIGURATION_EXCEPTION_MESSAGE;
import static com.bs.exercice.loggingservice.service.errors.LevelNotSpecifiedException.LEVEL_NOT_SPECIFIED_EXCEPTION_MESSAGE;
import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static java.lang.Boolean.FALSE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.MockitoAnnotations.initMocks;

class LoggingConfigurationValidationTest {

    @InjectMocks
    private LoggingConfigurationValidation loggingConfigurationValidation;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void validationOK() {
        LoggingConfiguration input = buildLoggingConfiguration();
        loggingConfigurationValidation.validation(input);
    }

    @Test
    void validationInvalidConfigurationException() {
        LoggingConfiguration input = buildLoggingConfiguration();
        input.setLogToConsole(FALSE);
        input.setLogToDatabase(FALSE);

        Exception exception = assertThrows(InvalidConfigurationException.class,
                () -> loggingConfigurationValidation.validation(input));

        assertEquals(INVALID_CONFIGURATION_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void validationLevelNotSpecifiedException() {
        LoggingConfiguration input = buildLoggingConfiguration();
        input.setLogWarning(FALSE);

        Exception exception = assertThrows(LevelNotSpecifiedException.class,
                () -> loggingConfigurationValidation.validation(input));

        assertEquals(LEVEL_NOT_SPECIFIED_EXCEPTION_MESSAGE, exception.getMessage());
    }
}