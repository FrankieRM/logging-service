package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.dao.mapper.LoggingValueMapper;
import com.bs.exercice.loggingservice.dao.repository.LoggingValueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingValueDTO;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class DatabaseAppenderTest {

    @InjectMocks
    private DatabaseAppender databaseAppender;

    @Mock
    private LoggingValueRepository loggingValueRepository;

    @Mock
    private LoggingValueMapper loggingValueMapper;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void save() {
        LoggingValueDTO input = buildLoggingValueDTO();
        LoggingValue output = new LoggingValue();

        when(loggingValueMapper.map(input)).thenReturn(output);
        when(loggingValueRepository.save(output)).thenReturn(output);

        LoggingValue result = databaseAppender.save(input);

        assertNotNull(result);
    }
}