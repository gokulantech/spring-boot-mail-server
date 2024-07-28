package com.mailserver.mailapplication.controller;

import com.mailserver.mailapplication.service.MailService;
import com.mailserver.mailapplication.vo.MailDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping("/send-mail")
    public ResponseEntity<Object> sendMail(@RequestBody MailDetailsVo mailDetails){
        return mailService.sendMail(mailDetails);
    }
}
