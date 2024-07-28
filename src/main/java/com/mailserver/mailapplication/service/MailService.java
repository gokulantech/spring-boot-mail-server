package com.mailserver.mailapplication.service;

import com.mailserver.mailapplication.vo.MailDetailsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public ResponseEntity<Object> sendMail(MailDetailsVo mailDetails){

//        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(mailDetails.getRecipient());
            mailMessage.setText(mailDetails.getMsgBody());
            mailMessage.setSubject(mailDetails.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
//        }

        // Catch block to handle the exceptions
//        catch (Exception e) {
//            log.error("Exception occurred {}",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to send mail");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body("Mail Sent Successfully...");
    }
}
