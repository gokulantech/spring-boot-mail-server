package com.mailserver.mailapplication.vo;

import lombok.Data;

@Data
public class MailDetailsVo {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
