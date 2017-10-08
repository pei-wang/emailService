package com.pei.api.emailService.entity;

public class EmailMessage {
    private static final String DEFAULT_CONTENT_TYPE = "text/html;charset=utf-8";
    private String from;
    private String to;
    private String subject;
    private String content;
    private String contentType;

    public EmailMessage() {
        this.contentType = DEFAULT_CONTENT_TYPE;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
