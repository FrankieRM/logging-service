package com.bs.exercice.loggingservice.service.validation;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.service.errors.EmptyLevelNameException;
import com.bs.exercice.loggingservice.service.errors.EmptyMessageTextException;
import com.bs.exercice.loggingservice.service.errors.NullLevelNameException;
import com.bs.exercice.loggingservice.service.errors.NullMessageTextException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static com.bs.exercice.loggingservice.service.errors.EmptyLevelNameException.EMPTY_LEVEL_NAME_EXCEPTION_MESSAGE;
import static com.bs.exercice.loggingservice.service.errors.EmptyMessageTextException.EMPTY_MESSAGE_TEXT_EXCEPTION_MESSAGE;
import static com.bs.exercice.loggingservice.service.errors.NullLevelNameException.NULL_LEVEL_NAME_EXCEPTION_MESSAGE;
import static com.bs.exercice.loggingservice.service.errors.NullMessageTextException.NULL_MESSAGE_TEXT_EXCEPTION_MESSAGE;
import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingValueDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.MockitoAnnotations.initMocks;

class LoggingValueValidationTest {

    @InjectMocks
    private LoggingValueValidation loggingValueValidation;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void validationOK() {
        LoggingValueDTO input = buildLoggingValueDTO();
        loggingValueValidation.validation(input);
    }

    @Test
    void validationNullMessageTextException() {
        LoggingValueDTO input = buildLoggingValueDTO();
        input.setMessageText(null);

        Exception exception = assertThrows(NullMessageTextException.class,
                () -> loggingValueValidation.validation(input));

        assertEquals(NULL_MESSAGE_TEXT_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void validationEmptyMessageTextException() {
        LoggingValueDTO input = buildLoggingValueDTO();
        input.setMessageText("");

        Exception exception = assertThrows(EmptyMessageTextException.class,
                () -> loggingValueValidation.validation(input));

        assertEquals(EMPTY_MESSAGE_TEXT_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void validationNullLevelNameException() {
        LoggingValueDTO input = buildLoggingValueDTO();
        input.setLevelName(null);

        Exception exception = assertThrows(NullLevelNameException.class,
                () -> loggingValueValidation.validation(input));

        assertEquals(NULL_LEVEL_NAME_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void validationEmptyLevelNameException() {
        LoggingValueDTO input = buildLoggingValueDTO();
        input.setLevelName("");

        Exception exception = assertThrows(EmptyLevelNameException.class,
                () -> loggingValueValidation.validation(input));

        assertEquals(EMPTY_LEVEL_NAME_EXCEPTION_MESSAGE, exception.getMessage());
    }
}