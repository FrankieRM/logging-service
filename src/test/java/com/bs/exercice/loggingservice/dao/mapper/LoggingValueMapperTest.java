package com.bs.exercice.loggingservice.dao.mapper;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.dao.domain.enumeration.LoggingLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingValueDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;

class LoggingValueMapperTest {

    @InjectMocks
    private LoggingValueMapper loggingValueMapper;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void map() {
        LoggingValueDTO input = buildLoggingValueDTO();
        LoggingValue result = loggingValueMapper.map(input);

        assertNotNull(result);
        assertTrue(result.getMessageText().contains(input.getLevelName()));
        assertTrue(result.getMessageText().contains(input.getMessageText()));
        assertEquals(LoggingLevel.getCodeByName(input.getLevelName()), result.getLogCode());
    }
}