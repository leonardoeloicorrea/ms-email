package com.leonardo.msemail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.msemail.dtos.EmailRequestDto;
import com.leonardo.msemail.dtos.EmailResponseDto;
import com.leonardo.msemail.services.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-email")
    public ResponseEntity<EmailResponseDto> enviarEmail(@RequestBody @Valid EmailRequestDto emailRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(emailService.enviarEmail(emailRequestDto));
    }

}
