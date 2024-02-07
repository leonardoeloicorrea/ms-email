package com.leonardo.msemail.dtos;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Campo obrigatório")
    private String refProprietario;

    @NotBlank(message = "Campo obrigatório")
    @Email(message = "Email inválido")
    private String emailDe;

    @NotBlank(message = "Campo obrigatório")
    @Email(message = "Email inválido")
    private String emailPara;

    @NotBlank(message = "Campo obrigatório")
    private String titulo;

    @NotBlank(message = "Campo obrigatório")
    private String texto;
}