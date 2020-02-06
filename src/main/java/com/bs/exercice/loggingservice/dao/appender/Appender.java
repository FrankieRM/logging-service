package com.bs.exercice.loggingservice.dao.appender;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;

public interface Appender {

    LoggingValue save(LoggingValueDTO loggingValueDTO);
}