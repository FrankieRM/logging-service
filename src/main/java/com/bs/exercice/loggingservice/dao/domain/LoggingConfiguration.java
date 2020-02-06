package com.bs.exercice.loggingservice.dao.domain;

import javax.persistence.*;

/**
 * Entidad LoggingConfiguration.
 */
@Entity
@Table(name = "logging_configuration")
public class LoggingConfiguration {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "log_to_file")
    private boolean logToFile;

    @Column(name = "log_to_console")
    private boolean logToConsole;

    @Column(name = "log_to_database")
    private boolean logToDatabase;

    @Column(name = "log_message")
    private boolean logMessage;

    @Column(name = "log_warning")
    private boolean logWarning;

    @Column(name = "log_error")
    private boolean logError;

    public boolean isLogToFile() {
        return logToFile;
    }

    public void setLogToFile(boolean logToFile) {
        this.logToFile = logToFile;
    }

    public boolean isLogToConsole() {
        return logToConsole;
    }

    public void setLogToConsole(boolean logToConsole) {
        this.logToConsole = logToConsole;
    }

    public boolean isLogToDatabase() {
        return logToDatabase;
    }

    public void setLogToDatabase(boolean logToDatabase) {
        this.logToDatabase = logToDatabase;
    }

    public boolean isLogMessage() {
        return logMessage;
    }

    public void setLogMessage(boolean logMessage) {
        this.logMessage = logMessage;
    }

    public boolean isLogWarning() {
        return logWarning;
    }

    public void setLogWarning(boolean logWarning) {
        this.logWarning = logWarning;
    }

    public boolean isLogError() {
        return logError;
    }

    public void setLogError(boolean logError) {
        this.logError = logError;
    }
}