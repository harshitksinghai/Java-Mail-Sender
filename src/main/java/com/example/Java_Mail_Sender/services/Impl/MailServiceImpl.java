package com.example.Java_Mail_Sender.services.Impl;

import com.example.Java_Mail_Sender.DTO.RequestDTO.MailRequestDTO;
import com.example.Java_Mail_Sender.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("$(spring.mail.username)")
    private String fromMail;

    @Override
    public ResponseEntity<String> sendMail(String mail, MailRequestDTO mailRequestDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(mailRequestDTO.getSubject());
        simpleMailMessage.setText(mailRequestDTO.getMessage());
        simpleMailMessage.setTo(mail);

        mailSender.send(simpleMailMessage);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
