package com.empresa.app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoResponseDto {

    @NotNull
    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull
    @Valid // Para validar os campos do objeto fornecedorResponseDto.
    private FornecedorResponseDto fornecedorResponseDto;

    @NotNull
    @NotBlank
    private String nome;
}
