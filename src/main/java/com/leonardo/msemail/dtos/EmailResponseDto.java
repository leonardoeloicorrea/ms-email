package com.leonardo.msemail.dtos;

import java.io.Serializable;

import com.leonardo.msemail.enums.StatusEmail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String refProprietario;

    private String emailDe;

    private String emailPara;

    private String titulo;

    private String texto;

    private StatusEmail statusEmail;

}
