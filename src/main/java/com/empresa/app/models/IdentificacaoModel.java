package com.empresa.app.models;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "identificacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class IdentificacaoModel {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_produto")
    /*
     * @Column indica que o campo id_produto na tabela de Identificacao é a
     * chave primária (PK) e também a chave estrangeira (FK) que se refere à
     * coluna id da tabela de Produto.
     * 
     * @Column é usada para mapear um atributo de uma entidade para uma coluna
     * específica em uma tabela do banco de dados.
     * Nesse caso, o campo id_produto é a chave primária da tabela Identificacao,
     * e também é uma chave estrangeira que referencia a tabela Produto.
     */
    private UUID id;

    
    @MapsId
    /*
     * @MapsId indica que o id do produto é o mesmo que o id da identificação.
     * Isso significa que a identificação é uma extensão do produto e não tem
     * um id separado (relacionamento de composição).
     * 
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
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    /*
     * @JoinColumn indica que a coluna id_produto na tabela de Identificacao
     * é uma chave estrangeira que se refere à coluna id da tabela de Produto.
     * 
     * @JoinColumn é usada para especificar a coluna que será usada para
     * fazer a junção entre as duas tabelas.
     * A @JoinColumn é usada para mapear a relação entre as duas entidades.
     * Nesse caso, a coluna id_produto na tabela Identificacao é uma
     * chave estrangeira que se refere à coluna id tabela Produto.
     * A tabela identificacao terá uma coluna chamada id_produto.
     * 
     * Essa coluna será uma chave estrangeira referenciando o campo id da tabela
     * Produto. Com isso, conseguimos fazer o relacionamento @OneToOne (1:1),
     * indicando que cada identificação está associada exatamente a um produto.
     * Exemplo:
     * CREATE TABLE identificacao (
     *   id_produto UUID PRIMARY KEY,
     *   descricao TEXT NOT NULL,
     *   observacao TEXT NOT NULL,
     *   FOREIGN KEY (id_produto) REFERENCES produto(id)
     * );
     */
    @NotNull
    @Valid
    @EqualsAndHashCode.Include
    private ProdutoModel produtoModel;

    @NotNull
    @EqualsAndHashCode.Include
    private String descricao;

    @NotNull
    private String observacao;
}
