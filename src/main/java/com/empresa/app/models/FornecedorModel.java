package com.empresa.app.models;

import java.util.Objects;
import java.util.UUID;

import com.empresa.app.dtos.FornecedorDto;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "fornecedor")
public class FornecedorModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @NotNull
    @Column(unique = true)
    private String nome;

    @NotNull
    @Column(unique = true)
    private String telefone;

    @NotNull
    private String endereco;

    public FornecedorModel() {
    }

    public FornecedorModel(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public FornecedorModel(UUID id, String nome, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public FornecedorModel(FornecedorDto fornecedorDto) throws IllegalArgumentException {
        if (fornecedorDto == null) {
            throw new IllegalArgumentException("FornecedorDto não pode ser nulo.");
        }

        if(fornecedorDto.getId() != null) {
            this.id = fornecedorDto.getId();
        }

        this.nome = fornecedorDto.getNome();
        this.telefone = fornecedorDto.getTelefone();
        this.endereco = fornecedorDto.getEndereco();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public FornecedorDto toDto() {
        return new FornecedorDto(getId(), getNome(), getTelefone(), getEndereco());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FornecedorModel that = (FornecedorModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
