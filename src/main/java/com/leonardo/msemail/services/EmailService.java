package com.leonardo.msemail.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.leonardo.msemail.dtos.EmailRequestDto;
import com.leonardo.msemail.dtos.EmailResponseDto;
import com.leonardo.msemail.enums.StatusEmail;
import com.leonardo.msemail.models.EmailModel;
import com.leonardo.msemail.repositories.EmailRepository;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailResponseDto enviarEmail(EmailRequestDto emailRequestDto){
        EmailResponseDto emailResponseDto = new EmailResponseDto();
        EmailModel emailModel = new EmailModel();
        try{
            BeanUtils.copyProperties(emailRequestDto, emailModel);
            emailModel.setDataEnvio(LocalDateTime.now());

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailDe());
            message.setTo(emailModel.getEmailPara());
            message.setSubject(emailModel.getTitulo());
            message.setText(emailModel.getTexto());
            emailSender.send(message);
            
            emailModel.setStatusEmail(StatusEmail.ENVIADO);
            emailRepository.save(emailModel);
        } catch(MailException e){
            emailModel.setStatusEmail(StatusEmail.ERRO);
            throw e;
        }
        finally{
        BeanUtils.copyProperties(emailModel, emailResponseDto);
        }
        return emailResponseDto;
    }

}
