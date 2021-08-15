package com.jeeno.mail.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Index;
//import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2021/8/6 15:23
 */
@Data
@ToString
@NoArgsConstructor
//@Entity
//@Table(name = "mail_prop", indexes = {@Index(name = "UK_USERNAME", columnList = "username", unique = true)})
public class MailPropDO {
    /**
     * primary key
     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * host
     */
//    @Column(name = "host", columnDefinition = "VARCHAR(30) NOT NULL COMMENT 'smtp server host'")
    private String host;
    /**
     * port
     */
//    @Column(name = "port", columnDefinition = "INT NOT NULL COMMENT 'port'")
    private Integer port;
    /**
     * username
     */
//    @Column(name = "username", columnDefinition = "VARCHAR(30) NOT NULL COMMENT 'smtp username'")
    private String username;
    /**
     * password
     */
//    @Column(name = "password", columnDefinition = "VARCHAR(255) NOT NULL COMMENT 'smtp password'")
    private String password;
    /**
     * create_time
     */
//    @Column(name = "create_time", columnDefinition = "datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create_time'")
    private LocalDateTime createTime;
    /**
     * update_time
     */
//    @Column(name = "update_time", columnDefinition = "datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'update_time'")
    private LocalDateTime updateTime;
}
