package com.empresa.app.models;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "identificacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class IdentificacaoModel {

    @Id
    @MapsId
    /*
     * @MapsId indica que o id do produto é o mesmo que o id da identificação.
     * Isso significa que a identificação é uma extensão do produto e não tem 
     * um id separado.
     * @MapsId associa um atributo a uma coluna específica.
     * O @MapsId indica que a FK também é a PK.
     * O @MapsId está criando um relacionamento um-para-um (1:1), compartilhando 
     * a mesma chave primária, o que é válido em modelagens de composição. 
     * Nesse caso, a entidade IdentificacaoModel está estendendo ProdutoModel 
     * em termos de dados, e o @MapsId indica que a FK também é a PK 
     * (uma FK que também é PK).
     * Isso representa uma relação de composição, onde IdentificacaoModel não 
     * existe sem ProdutoModel.
     */
    @OneToOne
    @JoinColumn(name = "id_produto")
    @Valid
    @EqualsAndHashCode.Include
    private ProdutoModel produtoModel;
    
    @NotNull
    @EqualsAndHashCode.Include
    private String descricao;
    
    @NotNull
    private String observacao;
}

