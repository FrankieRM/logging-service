package com.bs.exercice.loggingservice.resource.dto;

/**
 * Entidad LogValuesDTO.
 */
public class LoggingValueDTO {

    private String messageText;

    private String levelName;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}