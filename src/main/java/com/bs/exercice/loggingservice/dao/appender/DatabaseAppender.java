package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.repository.LoggingValueRepository;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseAppender extends BaseAppender implements Appender {

    @Autowired
    private LoggingValueRepository loggingValueRepository;

    @Override
    public LoggingValue save(LoggingValueDTO loggingValueDTO) {
        LoggingValue loggingValue = map(loggingValueDTO);
        return loggingValueRepository.save(loggingValue);
    }
}