package com.bs.exercice.loggingservice.dao.domain.enumeration;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static com.bs.exercice.loggingservice.utils.UtilTest.LOGGING_LEVEL_MESSAGE_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoggingLevelTest {

    private static final int LOGGING_LEVEL_MESSAGE_CODE = 1;

    @Test
    void getLevelByName() {
        Level result = LoggingLevel.getLevelByName(LOGGING_LEVEL_MESSAGE_NAME);

        assertNotNull(result);
        assertEquals(Level.INFO, result);
    }

    @Test
    void getCodeByName() {
        int result = LoggingLevel.getCodeByName(LOGGING_LEVEL_MESSAGE_NAME);

        assertEquals(LOGGING_LEVEL_MESSAGE_CODE, result);
    }
}