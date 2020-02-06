package com.bs.exercice.loggingservice.dao.mapper;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.bs.exercice.loggingservice.dao.domain.enumeration.LoggingLevel.getCodeByName;
import static java.lang.String.format;
import static java.text.DateFormat.LONG;
import static java.text.DateFormat.getDateInstance;

@Component
public class LoggingValueMapper {

    public LoggingValue map(LoggingValueDTO dto) {
        LoggingValue loggingValue = new LoggingValue();
        loggingValue.setMessageText(buildMessageText(dto));
        loggingValue.setLogCode(getCodeByName(dto.getLevelName()));
        return loggingValue;
    }

    private String buildMessageText(LoggingValueDTO dto) {
        String dateFormatted = getDateInstance(LONG).format(new Date());
        return format("%s %s %s", dto.getLevelName(), dateFormatted, dto.getMessageText());
    }
}