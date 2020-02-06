package com.bs.exercice.loggingservice.dao.domain;

import javax.persistence.*;

/**
 * Entidad LogValues.
 */
@Entity
@Table(name = "log_values")
public class LoggingValue {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "log_code")
    private int logCode;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public int getLogCode() {
        return logCode;
    }

    public void setLogCode(int logLevel) {
        this.logCode = logLevel;
    }
}