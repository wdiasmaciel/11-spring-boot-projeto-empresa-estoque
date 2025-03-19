package com.empresa.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GeneratedValue;
import java.util.Objects;
import java.util.UUID;

@Entity
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
