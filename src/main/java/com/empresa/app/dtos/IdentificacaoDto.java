package com.empresa.app.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdentificacaoDto {

    @NotNull
    @Valid // Para validar os campos do objeto produtoResponseDto.
    private ProdutoResponseDto produtoResponseDto;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    @NotBlank
    private String observacao;
}
