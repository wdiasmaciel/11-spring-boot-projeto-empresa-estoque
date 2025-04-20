package com.empresa.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;

import lombok.*;

import java.util.UUID;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "estoque")
public class EstoqueModel {

    @EmbeddedId
    private EstoqueModelPk id = new EstoqueModelPk();

    @NotNull
    @Column(name = "preco")
    private double preco;

    @NotNull
    @Column(name = "quantidade")
    private int quantidade;

    @NotNull
    @Column(name = "validade")
    private LocalDate validade;

    public void setIdProduto(UUID id_produto) {
        this.id.setId_produto(id_produto);
    }

    public void setCnpjFilial(String cnpj_filial) {
        this.id.setCnpj_filial(cnpj_filial);
    }

    public UUID getIdProduto() {
        return this.id.getId_produto();
    }

    public String getCnpjFilial() {
        return this.id.getCnpj_filial();
    }
}
