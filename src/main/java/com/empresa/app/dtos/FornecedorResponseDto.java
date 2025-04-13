package com.empresa.app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FornecedorResponseDto {

    /*
     * Quando um fornecedor é criado, o ID é gerado automaticamente.
     * Quando um fornecedor é lido, atualizado ou excluído, o ID é
     * enviado na requisição para identificar o fornecedor.
     */
    @NotNull
    @NotBlank
    private UUID id;

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
