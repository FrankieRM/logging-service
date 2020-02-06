package com.bs.exercice.loggingservice.dao;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.appender.FileAppender;
import com.bs.exercice.loggingservice.dao.appender.generator.AppenderGenerator;
import com.bs.exercice.loggingservice.dao.appender.generator.LevelGenerator;
import com.bs.exercice.loggingservice.dao.appender.validation.LevelValidation;
import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingValueDTO;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class LoggingValueDAOTest {

    @InjectMocks
    private LoggingValueDAO loggingValueDAO;

    @Mock
    private AppenderGenerator appenderGenerator;

    @Mock
    private LevelGenerator levelGenerator;

    @Mock
    private LevelValidation levelValidation;

    @Mock
    private LoggingConfigurationDAO loggingConfigurationDAO;

    @Mock
    private FileAppender fileAppender;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void save() {
        LoggingValueDTO input = buildLoggingValueDTO();
        LoggingConfiguration loggingConfiguration = buildLoggingConfiguration();
        LoggingValue loggingValue = new LoggingValue();
        List<String> levels = new ArrayList<>();

        when(loggingConfigurationDAO.getLoggingConfiguration()).thenReturn(loggingConfiguration);
        when(levelGenerator.generate(loggingConfiguration)).thenReturn(levels);
        doNothing().when(levelValidation).isLevelEnabled(levels, input.getLevelName());
        when(fileAppender.save(input)).thenReturn(loggingValue);
        when(appenderGenerator.generate(loggingConfiguration)).thenReturn(singletonList(fileAppender));

        LoggingValue result = loggingValueDAO.save(input);

        assertNotNull(result);
    }
}