package com.jeeno.mail.service.impl;

import com.jeeno.mail.pojo.dto.AttachFile;
import com.jeeno.mail.pojo.dto.MailInfoDTO;
import com.jeeno.mail.pojo.entity.MailPropDO;
import com.jeeno.mail.service.IMailSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2021/8/6 11:08
 */
@Slf4j
@Service
public class MailSendServiceImpl implements IMailSendService {

    @Resource(name = "mailCommonProps")
    private Properties mailCommonProps;

    @Override
    public void send(MailPropDO mailPropDO, MailInfoDTO mailInfoDTO) throws MessagingException {
        JavaMailSenderImpl mailSender = getSender(mailPropDO.getHost(), mailPropDO.getPort(), mailPropDO.getUsername(), mailPropDO.getPassword());
        mailSender.send(organizeData(mailSender, mailPropDO.getUsername(), mailInfoDTO));
        log.info("Send simple mail success.");
    }

    /**
     * organize data
     * @param mailSender sender
     * @param username username
     * @param mailInfoDTO  mailInfoDTO
     * @return MimeMessage
     * @throws MessagingException exception
     */
    private MimeMessage organizeData(JavaMailSenderImpl mailSender, String username, MailInfoDTO mailInfoDTO) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(username);
        Set<String> receivers = mailInfoDTO.getReceiver();
        Set<String> duplicateTo = mailInfoDTO.getDuplicateTo();
        Set<String> secretTo = mailInfoDTO.getSecretTo();
        Assert.isTrue(!CollectionUtils.isEmpty(receivers) || !CollectionUtils.isEmpty(duplicateTo) || !CollectionUtils.isEmpty(secretTo),
                "mail have to send to somewhere");
        // normal receivers
        if (receivers!=null && receivers.size()>0) {
            helper.setTo(receivers.toArray(new String[]{}));
        }
        // duplicate receivers
        if (duplicateTo!=null && duplicateTo.size()>0) {
            helper.setCc(duplicateTo.toArray(new String[]{}));
        }
        // secret receivers
        if (secretTo!=null && secretTo.size()>0) {
            helper.setBcc(secretTo.toArray(new String[]{}));
        }
        helper.setSubject(mailInfoDTO.getTitle().trim());
        helper.setText(mailInfoDTO.getContent());
        Set<AttachFile> attachment = mailInfoDTO.getAttachment();
        if (attachment != null) {
            // attachment file
            for (AttachFile attach : attachment) {
                helper.addAttachment(attach.getFilename(), new ByteArrayResource(attach.getData(), attach.getType()));
            }
        }
        log.info("#mail org# title({}), content({})", mailInfoDTO.getTitle(), mailInfoDTO.getContent());
        return mimeMessage;
    }

    /**
     * organize the sender info
     * @param host host
     * @param port port
     * @param username username
     * @param password password
     * @return JavaMailSenderImpl
     */
    private JavaMailSenderImpl getSender(String host, Integer port, String username, String password) {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(username);
        sender.setPassword(password);
        sender.setDefaultEncoding(StandardCharsets.UTF_8.name());
        sender.setJavaMailProperties(mailCommonProps);
        return sender;
    }
}
