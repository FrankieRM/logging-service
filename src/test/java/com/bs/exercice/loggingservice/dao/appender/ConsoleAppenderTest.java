package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.dao.mapper.LoggingValueMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingValueDTO;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class ConsoleAppenderTest {

    @InjectMocks
    private ConsoleAppender consoleAppender;

    @Mock
    private LoggingValueMapper loggingValueMapper;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void save() {
        LoggingValueDTO input = buildLoggingValueDTO();

        when(loggingValueMapper.map(input)).thenReturn(new LoggingValue());

        LoggingValue result = consoleAppender.save(input);

        assertNotNull(result);
    }
}