package com.empresa.app.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.app.models.IdentificacaoModel;
import com.empresa.app.models.ProdutoModel;

public interface IdentificacaoRepository extends JpaRepository<IdentificacaoModel, ProdutoModel> {
    Optional<IdentificacaoModel> findByProdutoModelId(UUID id);
    Optional<IdentificacaoModel> updateByProdutoModelId(UUID id, IdentificacaoModel identificacaoModel);
    void deleteByProdutoModelId(UUID idProduto);

    /*
     * Carregar Produto junto com Identificacao (caso use LAZY).
     * Isso evita o problema do LazyInitializationException fora do contexto da
     * transação e já traz o Produto “junto” da Identificação.
     * O EntityGraph é usado para especificar quais atributos devem ser carregados
     * junto com a entidade principal. Isso é útil para evitar o problema de N+1
     * consultas, onde o Hibernate faz uma consulta separada para cada entidade
     * relacionada. O EntityGraph permite que você especifique quais atributos
     * devem ser carregados em uma única consulta, melhorando o desempenho.
     * O atributoPaths é uma lista de atributos que você deseja carregar junto
     * com a entidade principal. No caso, é carregado o atributo produtoModel
     * da entidade IdentificacaoModel. Isso significa que, quando uma
     * IdentificacaoModel for buscada, o Hibernate também buscará o ProdutoModel 
     * associado a ela.
     * O EntityGraph é uma maneira de otimizar o carregamento de entidades
     * relacionadas no Hibernate, evitando consultas desnecessárias e melhorando
     * o desempenho da aplicação.
     */
    @EntityGraph(attributePaths = "produtoModel")
    Optional<IdentificacaoModel> findByProdutoModelIdUsingEntityGraph(UUID idProduto);
}
