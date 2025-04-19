package com.empresa.app.mappers;

import com.empresa.app.dtos.IdentificacaoDto;
import com.empresa.app.models.IdentificacaoModel;

public final class IdentificacaoMapper {

    private IdentificacaoMapper() {
    } // Construtor privado para evitar instância da classe.

    public static IdentificacaoModel toModel(IdentificacaoDto identificacaoDto) throws IllegalArgumentException {
        if (identificacaoDto == null)
            throw new IllegalArgumentException("IdentificacaoDto não pode ser nulo.");

        IdentificacaoModel identificacaoModel = new IdentificacaoModel();

        identificacaoModel.setProdutoModel(ProdutoMapper.toModel(identificacaoDto.getProdutoResponseDto()));
        identificacaoModel.setDescricao(identificacaoDto.getDescricao());
        identificacaoModel.setObservacao(identificacaoDto.getObservacao());

        return identificacaoModel;
    }

    public static IdentificacaoDto toDto(IdentificacaoModel identificacaoModel) throws IllegalArgumentException {
        if (identificacaoModel == null)
            throw new IllegalArgumentException("identificacaoModel não pode ser nulo.");

        IdentificacaoDto identificacaoDto = new IdentificacaoDto();

        identificacaoDto.setProdutoResponseDto(ProdutoMapper.toResponseDto(identificacaoModel.getProdutoModel()));
        identificacaoDto.setDescricao(identificacaoModel.getDescricao());
        identificacaoDto.setObservacao(identificacaoModel.getObservacao());

        return identificacaoDto;
    }

    /*
     * Pode ser usado em operações de atualização, onde o ID da identificação 
     * do produto não deve ser alterado (método PUT do protocolo HTTP).
     */
    public static void updateModelFromDto(IdentificacaoDto identificacaoDto, IdentificacaoModel identificacaoModel)
            throws IllegalArgumentException {
        if (identificacaoDto == null || identificacaoModel == null)
            throw new IllegalArgumentException("IdentificacaoDto e IdentificacaoModel não podem ser nulos.");

        identificacaoModel.setDescricao(identificacaoDto.getDescricao());
        identificacaoModel.setObservacao(identificacaoDto.getObservacao());
        // O ID continua o mesmo e não é alterado
    }
}
