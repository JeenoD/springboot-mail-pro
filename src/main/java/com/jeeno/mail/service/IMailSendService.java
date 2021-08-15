package com.jeeno.mail.service;

import com.jeeno.mail.pojo.dto.MailInfoDTO;
import com.jeeno.mail.pojo.entity.MailPropDO;

import javax.mail.MessagingException;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2021/8/6 11:09
 */
public interface IMailSendService {
    /**
     * send simple mail
     * @param mailPropDO sender
     * @param mailInfoDTO param for request
     * @throws MessagingException exception
     */
    void send(MailPropDO mailPropDO, MailInfoDTO mailInfoDTO) throws MessagingException;
}
