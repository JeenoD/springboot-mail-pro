package com.jeeno.mail.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2021/8/6 15:39
 */
@Slf4j
@Configuration
public class MailConfig {

    /**
     * common properties for smtp config
     * @return Properties
     */
    @Bean(value = "mailCommonProps")
    public Properties mailCommonProps() {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.starttls.required", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        return properties;
    }
}
