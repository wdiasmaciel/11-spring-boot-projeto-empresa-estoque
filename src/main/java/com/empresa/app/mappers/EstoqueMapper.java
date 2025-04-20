package com.empresa.app.mappers;

import com.empresa.app.dtos.EstoqueDto;
import com.empresa.app.models.EstoqueModelPk;
import com.empresa.app.models.EstoqueModel;

public final class EstoqueMapper {
    private EstoqueMapper() {
        // Construtor privado para evitar instância da classe.
    }

    public static EstoqueModel toModel(EstoqueDto estoqueDto) {
        if (estoqueDto == null)
            throw new IllegalArgumentException("EstoqueDto não pode ser nulo.");

        EstoqueModelPk estoqueModelPk = new EstoqueModelPk(
                estoqueDto.getId_produto(),
                estoqueDto.getCnpj_filial());
        EstoqueModel estoqueModel = new EstoqueModel(
                estoqueModelPk,
                estoqueDto.getPreco(),
                estoqueDto.getQuantidade(),
                estoqueDto.getValidade());

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
