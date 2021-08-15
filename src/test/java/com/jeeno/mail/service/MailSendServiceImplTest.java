package com.jeeno.mail.service;

import com.jeeno.mail.pojo.dto.MailInfoDTO;
import com.jeeno.mail.pojo.entity.MailPropDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.Collections;
import java.util.Set;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2021/8/6 11:45
 */
@Slf4j
@SpringBootTest
class MailSendServiceImplTest {

    @Resource
    private IMailSendService mailSendService;

    @Test
    void send() throws MessagingException {
        MailInfoDTO mailInfoDTO = new MailInfoDTO();
        // TODO here to set receivers
        Set<String> receivers = Collections.singleton("【TODO】");
        String title = "test-title";
        String content = "test-content";
        mailInfoDTO.setReceiver(receivers);
        mailInfoDTO.setTitle(title);
        mailInfoDTO.setContent(content);

        // send mail using the sender-1
        // TODO use your own smtp-server properties
        MailPropDO propDO = new MailPropDO();
        propDO.setHost("【TODO】");
        propDO.setPort(465);
        propDO.setUsername("【TODO】");
        propDO.setPassword("【TODO】");
        mailSendService.send(propDO, mailInfoDTO);

        // switch the sender
        // TODO use your own smtp-server properties
        MailPropDO propDO2 = new MailPropDO();
        propDO2.setHost("【TODO】");
        propDO2.setPort(465);
        propDO2.setUsername("【TODO】");
        propDO2.setPassword("【TODO】");
        mailSendService.send(propDO2, mailInfoDTO);
    }
}
