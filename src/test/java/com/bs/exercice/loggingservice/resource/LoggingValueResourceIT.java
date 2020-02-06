package com.bs.exercice.loggingservice.resource;

import com.bs.exercice.loggingservice.LoggingServiceApplication;
import com.bs.exercice.loggingservice.dao.appender.ConsoleAppender;
import com.bs.exercice.loggingservice.dao.appender.DatabaseAppender;
import com.bs.exercice.loggingservice.dao.appender.FileAppender;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import com.bs.exercice.loggingservice.dao.mapper.LoggingValueMapper;
import com.bs.exercice.loggingservice.dao.repository.LoggingValueRepository;
import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.bs.exercice.loggingservice.utils.UtilTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest(classes = LoggingServiceApplication.class)
class LoggingValueResourceIT {

    @Autowired
    private LoggingValueResource loggingValueResource;

    @Autowired
    private LoggingValueRepository loggingValueRepository;

    private MockMvc restLoggingValueMockMvc;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    private LoggingValueDTO loggingValueDTO;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        this.restLoggingValueMockMvc = standaloneSetup(loggingValueResource)
                .setMessageConverters(jacksonMessageConverter)
                .build();
        loggingValueDTO = buildLoggingValueDTO();
    }

    @Test
    void createValue() throws Exception {
        int databaseSizeBeforeCreate = loggingValueRepository.findAll().size();

        restLoggingValueMockMvc.perform(post("/logging-value/value")
                .contentType(APPLICATION_JSON_UTF8)
                .content(convertObjectToJsonBytes(loggingValueDTO)))
                .andExpect(status().isCreated());

        List<LoggingValue> loggingValues = loggingValueRepository.findAll();
        assertThat(loggingValues).hasSize(databaseSizeBeforeCreate + 1);
        LoggingValue newLoggingValue = loggingValues.get(loggingValues.size() - 1);

        assertThat(newLoggingValue).isNotNull();
    }
}