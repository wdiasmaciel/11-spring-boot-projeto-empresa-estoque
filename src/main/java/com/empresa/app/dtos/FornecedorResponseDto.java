package com.empresa.app.dtos;

import com.empresa.app.models.FornecedorModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;
import org.springframework.beans.BeanUtils;

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

    public FornecedorResponseDto(FornecedorModel fornecedorModel) {
        if (fornecedorModel == null)
            throw new IllegalArgumentException("FornecedorModel não pode ser nulo.");
        if (fornecedorModel.getId() == null)
            throw new IllegalArgumentException("ForenecedorModel nõa pote ter ID nulo.");

        BeanUtils.copyProperties(fornecedorModel, this);
    }

    public FornecedorModel toModel() {
        if (id == null) 
            return new FornecedorModel(getNome(), getTelefone(), getEndereco());
        
        return new FornecedorModel(this);
    }
}
