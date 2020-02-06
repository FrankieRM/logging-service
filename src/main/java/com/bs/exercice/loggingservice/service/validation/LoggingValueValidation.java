package com.bs.exercice.loggingservice.service.validation;

import com.bs.exercice.loggingservice.resource.dto.LoggingValueDTO;
import com.bs.exercice.loggingservice.service.errors.EmptyLevelNameException;
import com.bs.exercice.loggingservice.service.errors.EmptyMessageTextException;
import com.bs.exercice.loggingservice.service.errors.NullLevelNameException;
import com.bs.exercice.loggingservice.service.errors.NullMessageTextException;
import org.springframework.stereotype.Component;

@Component
public class LoggingValueValidation {

    public void validation(LoggingValueDTO loggingValueDTO) {
        validationMessageText(loggingValueDTO.getMessageText());
        validationLevelName(loggingValueDTO.getLevelName());
    }

    private void validationMessageText(String messageText) {
        if (messageText == null) {
            throw new NullMessageTextException();
        }

        if (messageText.trim().length() == 0) {
            throw new EmptyMessageTextException();
        }
    }

    private void validationLevelName(String levelName) {
        if (levelName == null) {
            throw new NullLevelNameException();
        }

        if (levelName.trim().length() == 0) {
            throw new EmptyLevelNameException();
        }
    }
}