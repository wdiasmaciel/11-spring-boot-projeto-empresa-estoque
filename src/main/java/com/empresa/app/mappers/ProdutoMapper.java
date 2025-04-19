package com.empresa.app.mappers;

import com.empresa.app.dtos.ProdutoRequestDto;
import com.empresa.app.dtos.ProdutoResponseDto;
import com.empresa.app.models.ProdutoModel;

public final class ProdutoMapper {
    
    private ProdutoMapper() {
    } // Construtor privado para evitar instância da classe.

    public static ProdutoModel toModel(ProdutoRequestDto produtoRequestDto) throws IllegalArgumentException {
        if (produtoRequestDto == null)
            throw new IllegalArgumentException("ProdutoRequestDto não pode ser nulo.");

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome(produtoRequestDto.getNome());
        produtoModel.setFornecedorModel(FornecedorMapper.toModel(produtoRequestDto.getFornecedorResponseDto()));

        return produtoModel; // O ID será gerado pela JPA.
    }

    public static ProdutoModel toModel(ProdutoResponseDto produtoResponseDto) throws IllegalArgumentException {
        if (produtoResponseDto == null)
            throw new IllegalArgumentException("ProdutoResponseDto não pode ser nulo.");

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome(produtoResponseDto.getNome());
        produtoModel.setFornecedorModel(FornecedorMapper.toModel(produtoResponseDto.getFornecedorResponseDto()));
        
        return produtoModel; // Já tem ID.
    }

    public static ProdutoRequestDto toRequestDto(ProdutoModel produtoModel) throws IllegalArgumentException {
        if (produtoModel == null)
            throw new IllegalArgumentException("ProdutoModel não pode ser nulo.");

        ProdutoRequestDto produtoRequestDto = new ProdutoRequestDto();
        produtoRequestDto.setNome(produtoModel.getNome());
        produtoRequestDto.setFornecedorResponseDto(FornecedorMapper.toResponseDto(produtoModel.getFornecedorModel()));
        
        return produtoRequestDto;
    }

    public static ProdutoResponseDto toResponseDto(ProdutoModel produtoModel) throws IllegalArgumentException {
        if (produtoModel == null)
            throw new IllegalArgumentException("ProdutoModel não pode ser nulo.");

        ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();
        produtoResponseDto.setId(produtoModel.getId());
        produtoResponseDto.setNome(produtoModel.getNome());
        produtoResponseDto.setFornecedorResponseDto(FornecedorMapper.toResponseDto(produtoModel.getFornecedorModel()));
        
        return produtoResponseDto;
    }

    /*
     * Pode ser usado em operações de atualização, onde o ID do produto não deve ser
     * alterado (método PUT do protocolo HTTP).
     */
    public static void updateModelFromDto(ProdutoRequestDto produtoRequestDto, ProdutoModel produtoModel) throws IllegalArgumentException {
        if (produtoRequestDto == null || produtoModel == null)
            throw new IllegalArgumentException("ProdutoRequestDto e ProdutoModel não podem ser nulos.");
        produtoModel.setNome(produtoRequestDto.getNome());
        produtoModel.setFornecedorModel(FornecedorMapper.toModel(produtoRequestDto.getFornecedorResponseDto()));
        // O ID continua o mesmo e não é alterado
    }
}
