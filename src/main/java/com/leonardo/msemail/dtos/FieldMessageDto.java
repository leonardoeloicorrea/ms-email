package com.leonardo.msemail.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FieldMessageDto {

    private String fieldName; 
    private String message; 

}