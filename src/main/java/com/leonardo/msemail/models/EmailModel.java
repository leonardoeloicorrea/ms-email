package com.leonardo.msemail.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.leonardo.msemail.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_email")
public class EmailModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String refProprietario;
    
    @Column(nullable = false)
    private String emailDe;
    
    @Column(nullable = false)
    private String emailPara;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String texto;
    
    @Column(nullable = false)
    private LocalDateTime dataEnvio;
    
    @Column(nullable = false)
    private StatusEmail statusEmail;

}