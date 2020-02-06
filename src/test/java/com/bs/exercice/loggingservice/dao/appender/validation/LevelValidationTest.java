package com.bs.exercice.loggingservice.dao.appender.validation;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.service.errors.LevelDisabledException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static com.bs.exercice.loggingservice.service.errors.LevelDisabledException.LEVEL_DISABLED_EXCEPTION_MESSAGE;
import static com.bs.exercice.loggingservice.utils.UtilTest.LOGGING_LEVEL_MESSAGE_NAME;
import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

class LevelValidationTest {

    private static final String LEVEL_NAME_DUMMY = "levelNameDummy";

    @InjectMocks
    private LevelValidation levelValidation;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void isLevelEnabled() {
        List<String> levels = singletonList(LEVEL_NAME_DUMMY);
        levelValidation.isLevelEnabled(levels, LEVEL_NAME_DUMMY);
    }

    @Test
    void isLevelDisabled() {
        List<String> levels = singletonList("levelNameDummy2");

        Exception exception = assertThrows(LevelDisabledException.class,
                () -> levelValidation.isLevelEnabled(levels, LEVEL_NAME_DUMMY));

        assertEquals(LEVEL_DISABLED_EXCEPTION_MESSAGE, exception.getMessage());
    }
}