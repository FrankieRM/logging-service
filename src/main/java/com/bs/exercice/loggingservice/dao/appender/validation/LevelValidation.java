package com.bs.exercice.loggingservice.dao.appender.validation;

import com.bs.exercice.loggingservice.service.errors.LevelDisabledException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LevelValidation {

    public void isLevelEnabled(List<String> levels, String levelName) {
        boolean levelEnabled = levels.contains(levelName);

        if (!levelEnabled) {
            throw new LevelDisabledException();
        }
    }
}