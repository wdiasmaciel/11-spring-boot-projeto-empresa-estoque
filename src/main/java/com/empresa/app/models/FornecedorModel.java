package com.empresa.app.models;

import com.empresa.app.dtos.FornecedorRequestDto;
import com.empresa.app.dtos.FornecedorResponseDto;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "fornecedor")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FornecedorModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @EqualsAndHashCode.Include
    @Getter private UUID id;

    @NotNull
    @Column(unique = true)
    @Getter @Setter private String nome;

    @NotNull
    @Column(unique = true)
    @Getter @Setter private String telefone;

    @NotNull
    @Getter @Setter private String endereco;

    public FornecedorModel(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public FornecedorModel(FornecedorRequestDto fornecedorRequestDto) throws IllegalArgumentException {
        if (fornecedorRequestDto == null)
            throw new IllegalArgumentException("FornecedorRequestDto não pode ser nulo.");

        this.nome = fornecedorRequestDto.getNome();
        this.telefone = fornecedorRequestDto.getTelefone();
        this.endereco = fornecedorRequestDto.getEndereco();
    }

    public FornecedorModel(FornecedorResponseDto fornecedorResponseDto) throws IllegalArgumentException {
        if (fornecedorResponseDto == null) 
            throw new IllegalArgumentException("FornecedorRequestDto não pode ser nulo.");

        if (fornecedorResponseDto.getId() == null) 
            throw new IllegalArgumentException("FornecedorResponseDto nõa pote ter ID nulo.");

            BeanUtils.copyProperties(fornecedorResponseDto, this);
    }
}
