package com.bs.exercice.loggingservice.dao;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.dao.mapper.LoggingConfigurationMapper;
import com.bs.exercice.loggingservice.dao.repository.LoggingConfigurationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class LoggingConfigurationDAOTest {

    @InjectMocks
    private LoggingConfigurationDAO loggingConfigurationDAO;

    @Mock
    private LoggingConfigurationRepository loggingConfigurationRepository;

    @Mock
    private LoggingConfigurationMapper loggingConfigurationMapper;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    void getLoggingConfiguration() {
        LoggingConfiguration input = buildLoggingConfiguration();

        when(loggingConfigurationRepository.getInitialLoggingConfiguration()).thenReturn(input);

        LoggingConfiguration result = loggingConfigurationDAO.getLoggingConfiguration();

        assertNotNull(result);
        assertEquals(input, result);
    }

    @Test
    void getLoggingConfigurationWithoutInitialConfiguration() {
        LoggingConfiguration input = buildLoggingConfiguration();

        when(loggingConfigurationRepository.getInitialLoggingConfiguration()).thenReturn(null);
        when(loggingConfigurationMapper.getInitialLoggingConfiguration()).thenReturn(input);
        when(loggingConfigurationRepository.save(input)).thenReturn(input);

        LoggingConfiguration result = loggingConfigurationDAO.getLoggingConfiguration();

        assertNotNull(result);
        assertEquals(input, result);
    }

    @Test
    void save() {
        LoggingConfiguration input = buildLoggingConfiguration();

        when(loggingConfigurationRepository.getInitialLoggingConfiguration()).thenReturn(input);
        when(loggingConfigurationMapper.map(input)).thenReturn(input);
        when(loggingConfigurationRepository.save(input)).thenReturn(input);

        LoggingConfiguration result = loggingConfigurationDAO.save(input);

        assertNotNull(result);
        assertEquals(input, result);
    }

    @Test
    void saveWithoutInitialConfiguration() {
        LoggingConfiguration input = buildLoggingConfiguration();

        when(loggingConfigurationRepository.getInitialLoggingConfiguration()).thenReturn(null);
        when(loggingConfigurationMapper.getInitialLoggingConfiguration()).thenReturn(input);
        when(loggingConfigurationRepository.save(input)).thenReturn(input);

        LoggingConfiguration result = loggingConfigurationDAO.save(input);

        assertNotNull(result);
        assertEquals(input, result);
    }
}