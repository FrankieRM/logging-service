package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.mapper.LoggingValueMapper;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseAppender {

    @Autowired
    private LoggingValueMapper loggingValueMapper;

    public LoggingValue map(LoggingValueDTO loggingValueDTO) {
        return loggingValueMapper.map(loggingValueDTO);
    }
}