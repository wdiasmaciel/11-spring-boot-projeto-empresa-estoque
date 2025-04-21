package com.empresa.app.mappers;

import com.empresa.app.dtos.EstoqueDto;
import com.empresa.app.models.EstoqueModelPk;
import com.empresa.app.models.EstoqueModel;

import com.empresa.app.repositories.ProdutoRepository;
import com.empresa.app.repositories.FilialRepository;

public final class EstoqueMapper {
    private EstoqueMapper() {
        // Construtor privado para evitar instância da classe.
    }

    public static EstoqueModel toModel(ProdutoRepository produtoRepository, FilialRepository filialRepository,
            EstoqueDto estoqueDto) {
        if (estoqueDto == null)
            throw new IllegalArgumentException("EstoqueDto não pode ser nulo.");

        var estoqueModelPk = new EstoqueModelPk(
                estoqueDto.getId_produto(),
                estoqueDto.getCnpj_filial());

        var produtoModel = produtoRepository.findById(estoqueDto.getId_produto())
                .orElseThrow(() -> new RuntimeException("ProdutoModel não encontrado."));

        var filialModel = filialRepository.findById(estoqueDto.getCnpj_filial())
                .orElseThrow(() -> new RuntimeException("FilialModel não encontrada."));

        var estoqueModel = new EstoqueModel();

        estoqueModel.setId(estoqueModelPk);
        estoqueModel.setProdutoModel(produtoModel);
        estoqueModel.setFilialModel(filialModel);
        estoqueModel.setPreco(estoqueDto.getPreco());
        estoqueModel.setQuantidade(estoqueDto.getQuantidade());
        estoqueModel.setValidade(estoqueDto.getValidade());

        return estoqueModel;
    }

    public static EstoqueDto toDto(EstoqueModel estoqueModel) {
        if (estoqueModel == null)
            throw new IllegalArgumentException("EstoqueModel não pode ser nulo.");

        return new EstoqueDto(
                estoqueModel.getId().getId_produto(),
                estoqueModel.getId().getCnpj_filial(),
                estoqueModel.getPreco(),
                estoqueModel.getQuantidade(),
                estoqueModel.getValidade());
    }
}
