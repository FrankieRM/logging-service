package com.bs.exercice.loggingservice.dao.domain.enumeration;

import java.util.logging.Level;

import static java.util.Arrays.stream;

public enum LoggingLevel {

    MESSAGE(Level.INFO, 1),
    WARNING(Level.WARNING, 2),
    ERROR(Level.SEVERE, 3);

    private final Level level;
    private final int code;

    LoggingLevel(Level level, int code) {
        this.level = level;
        this.code = code;
    }

    public static Level getLevelByName(String name) {
        return stream(values())
                .filter(level -> level.name().equals(name))
                .map(LoggingLevel::getLevel)
                .findFirst()
                .orElse(null);
    }

    public static int getCodeByName(String name) {
        return stream(values())
                .filter(level -> level.name().equals(name))
                .map(LoggingLevel::getCode)
                .findFirst()
                .orElse(0);
    }

    private Level getLevel() {
        return level;
    }

    private int getCode() {
        return code;
    }
}