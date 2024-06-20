package com.example.Java_Mail_Sender.controllers;

import com.example.Java_Mail_Sender.DTO.RequestDTO.MailRequestDTO;
import com.example.Java_Mail_Sender.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService mailService;
    @PostMapping("/send/{mail}")
    public ResponseEntity<String> sendMail(@PathVariable String mail, @RequestBody MailRequestDTO mailRequestDTO){
        return mailService.sendMail(mail, mailRequestDTO);
    }
}
