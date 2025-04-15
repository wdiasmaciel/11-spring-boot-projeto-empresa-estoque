package com.empresa.app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilialDto {

    @NotNull
    @NotBlank
    private String cnpj;

    @NotNull
    @NotBlank
    private String nome;
    
    @NotNull
    @NotBlank
    private String telefone;
    
    @NotNull
    @NotBlank
    private String endereco;
}
