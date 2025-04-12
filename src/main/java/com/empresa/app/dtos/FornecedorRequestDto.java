package com.empresa.app.dtos;

import com.empresa.app.models.FornecedorModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FornecedorRequestDto {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String telefone;

    @NotNull
    @NotBlank
    private String endereco;

    public FornecedorModel toModel() {
        return new FornecedorModel(nome, telefone, endereco);
    }
}
