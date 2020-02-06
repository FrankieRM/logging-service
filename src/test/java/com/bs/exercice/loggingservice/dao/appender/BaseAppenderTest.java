package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.dao.mapper.LoggingValueMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingValueDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class BaseAppenderTest {

    @InjectMocks
    private BaseAppender baseAppender;

    @Mock
    private LoggingValueMapper loggingValueMapper;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void map() {
        LoggingValueDTO input = buildLoggingValueDTO();

        when(loggingValueMapper.map(input)).thenReturn(new LoggingValue());

        LoggingValue result = baseAppender.map(input);

        assertNotNull(result);
    }
}