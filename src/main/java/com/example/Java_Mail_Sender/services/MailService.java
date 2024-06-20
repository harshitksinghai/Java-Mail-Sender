package com.example.Java_Mail_Sender.services;

import com.example.Java_Mail_Sender.DTO.RequestDTO.MailRequestDTO;
import org.springframework.http.ResponseEntity;

public interface MailService {
    public ResponseEntity<String> sendMail(String mail, MailRequestDTO mailRequestDTO);
}
