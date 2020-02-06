package com.bs.exercice.loggingservice.dao.appender.generator;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static com.bs.exercice.loggingservice.dao.domain.enumeration.LoggingLevel.WARNING;
import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;

class LevelGeneratorTest {

    @InjectMocks
    private LevelGenerator levelGenerator;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void generate() {
        LoggingConfiguration input = buildLoggingConfiguration();

        List<String> result = levelGenerator.generate(input);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(WARNING.name(), result.get(0));
    }
}