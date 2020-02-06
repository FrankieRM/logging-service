package com.bs.exercice.loggingservice.dao.appender.generator;

import com.bs.exercice.loggingservice.dao.appender.Appender;
import com.bs.exercice.loggingservice.dao.appender.ConsoleAppender;
import com.bs.exercice.loggingservice.dao.appender.DatabaseAppender;
import com.bs.exercice.loggingservice.dao.appender.FileAppender;
import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppenderGenerator {

    @Autowired
    private FileAppender fileAppender;

    @Autowired
    private ConsoleAppender consoleAppender;

    @Autowired
    private DatabaseAppender databaseAppender;

    public List<Appender> generate(LoggingConfiguration loggingConfiguration) {
        List<Appender> appenders = new ArrayList<>();
        mapAppender(appenders, loggingConfiguration.isLogToFile(), fileAppender);
        mapAppender(appenders, loggingConfiguration.isLogToConsole(), consoleAppender);
        mapAppender(appenders, loggingConfiguration.isLogToDatabase(), databaseAppender);
        return appenders;
    }

    private void mapAppender(List<Appender> appenders, boolean isLog, Appender appender) {
        if (isLog) {
            appenders.add(appender);
        }
    }
}