package com.empresa.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;

import lombok.*;

import java.util.UUID;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "estoque")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EstoqueModel {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private EstoqueModelPk id = new EstoqueModelPk();

    @ManyToOne
    @MapsId("id_produto")
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private ProdutoModel produtoModel;

    @ManyToOne
    @MapsId("cnpj_filial")
    @JoinColumn(name = "cnpj_filial", referencedColumnName = "cnpj")
    private FilialModel filialModel;

    @NotNull
    @Column(name = "preco")
    private double preco;

    @NotNull
    @Column(name = "quantidade")
    private int quantidade;

    @NotNull
    @Column(name = "validade")
    private LocalDate validade;

    public EstoqueModel(EstoqueModelPk estoqueModelPk, double preco, int quantidade, LocalDate validade) {
        this.id = estoqueModelPk;
        this.preco = preco;
        this.quantidade = quantidade;
        this.validade = validade;
    }

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
