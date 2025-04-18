package com.empresa.app.models;

import com.empresa.app.dtos.ProdutoRequestDto;
import com.empresa.app.dtos.ProdutoResponseDto;
import com.empresa.app.mappers.FornecedorMapper;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.Valid;
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
    @Valid
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
}
