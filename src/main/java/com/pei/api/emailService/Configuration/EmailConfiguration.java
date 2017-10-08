package com.pei.api.emailService.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mail.smtp")
@PropertySource("classpath:config/emailConfiguration.properties")
public class EmailConfiguration {

    private String auth;
    private String host;
    private String port;
    private String timeout;
    private String sslEnable;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getSslEnable() {
        return sslEnable;
    }

    public void setSslEnable(String sslEnable) {
        this.sslEnable = sslEnable;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
