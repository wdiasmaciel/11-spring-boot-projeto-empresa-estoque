package com.empresa.app.models;

import com.empresa.app.dtos.ProdutoRequestDto;
import com.empresa.app.dtos.ProdutoResponseDto;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @EqualsAndHashCode.Include
    @Getter
    private UUID id;

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private FornecedorModel fornecedorModel;

    @Getter
    @Setter
    @NotNull
    private String nome;

    public ProdutoModel(FornecedorModel fornecedorModel, String nome) {
        this.fornecedorModel = fornecedorModel;
        this.nome = nome;
    }

    public ProdutoModel(ProdutoRequestDto produtoRequestDto) throws IllegalArgumentException {
        if (produtoRequestDto == null)
            throw new IllegalArgumentException("ProdutoRequestDto não pode ser nulo.");

        this.fornecedorModel = produtoRequestDto.getFornecedor();
        this.nome = produtoRequestDto.getNome();
    }

    public ProdutoModel(ProdutoResponseDto produtoResponseDto) throws IllegalArgumentException {
        if (produtoResponseDto == null)
            throw new IllegalArgumentException("ProdutoResponseDto não pode ser nulo.");

        if (produtoResponseDto.getId() == null)
            throw new IllegalArgumentException("ProdutoResponseDto não pote ter ID nulo.");

        BeanUtils.copyProperties(produtoResponseDto, this);
    }
}
