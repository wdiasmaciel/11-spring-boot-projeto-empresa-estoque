package com.empresa.app.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDto {

    @NotNull
    @Valid // Para validar os campos do objeto fornecedor.
    private FornecedorResponseDto fornecedorResponseDto;

    @NotNull
    @NotBlank
    private String nome;

}
