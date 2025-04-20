package com.empresa.app.dtos;

import lombok.*;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueDto {

    @NotNull
    private UUID id_produto;

    @NotNull
    @NotBlank
    private String cnpj_filial;

    @NotNull
    private double preco;

    @NotNull
    private int quantidade;
    
    @NotNull
    private LocalDate validade;
}
