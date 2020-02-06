package com.bs.exercice.loggingservice.dao.appender.generator;

import com.bs.exercice.loggingservice.conf.AppenderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.createFile;
import static java.nio.file.Paths.get;

@Component
public class FileGenerator {

    @Autowired
    private AppenderProperties appenderProperties;

    public void createLogFile() throws IOException {
        File logFile = new File(appenderProperties.getFilePath());
        if (!logFile.exists()) {
            createFile(get(appenderProperties.getFilePath()));
        }
    }
}