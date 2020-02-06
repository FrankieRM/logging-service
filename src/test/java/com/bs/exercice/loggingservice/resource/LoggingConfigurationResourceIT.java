package com.bs.exercice.loggingservice.resource;

import com.bs.exercice.loggingservice.LoggingServiceApplication;
import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import com.bs.exercice.loggingservice.dao.repository.LoggingConfigurationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.bs.exercice.loggingservice.utils.UtilTest.buildLoggingConfiguration;
import static com.bs.exercice.loggingservice.utils.UtilTest.convertObjectToJsonBytes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest(classes = LoggingServiceApplication.class)
class LoggingConfigurationResourceIT {

    @Autowired
    private LoggingConfigurationResource loggingConfigurationResource;

    @Autowired
    private LoggingConfigurationRepository loggingConfigurationRepository;

    private MockMvc restLoggingConfigurationMockMvc;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    private LoggingConfiguration loggingConfiguration;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        this.restLoggingConfigurationMockMvc = standaloneSetup(loggingConfigurationResource)
                .setMessageConverters(jacksonMessageConverter)
                .build();
        loggingConfiguration = buildLoggingConfiguration();
    }

    @Test
    void createConfiguration() throws Exception {
        int databaseSizeBeforeCreate = loggingConfigurationRepository.findAll().size();

        restLoggingConfigurationMockMvc.perform(post("/logging-configuration/configuration")
                .contentType(APPLICATION_JSON_UTF8)
                .content(convertObjectToJsonBytes(loggingConfiguration)))
                .andExpect(status().isCreated());

        List<LoggingConfiguration> loggingConfigurations = loggingConfigurationRepository.findAll();
        assertThat(loggingConfigurations).hasSize(databaseSizeBeforeCreate + 1);
        LoggingConfiguration newLoggingConfiguration = loggingConfigurations.get(loggingConfigurations.size() - 1);

        assertThat(newLoggingConfiguration).isNotNull();
    }
}