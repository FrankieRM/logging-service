package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.dao.appender.generator.AppenderGenerator;
import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;

class AppenderGeneratorTest {

    @InjectMocks
    private AppenderGenerator appenderGenerator;

    @Mock
    private FileAppender fileAppender;

    @Mock
    private ConsoleAppender consoleAppender;

    @Mock
    private DatabaseAppender databaseAppender;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void generate() {
        LoggingConfiguration input = buildLoggingConfiguration();
        List<Appender> result = appenderGenerator.generate(input);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertTrue(result.get(0) instanceof ConsoleAppender);
        assertTrue(result.get(1) instanceof DatabaseAppender);
    }
}