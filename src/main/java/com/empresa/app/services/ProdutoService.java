package com.empresa.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import com.empresa.app.dtos.ProdutoRequestDto;
import com.empresa.app.dtos.ProdutoResponseDto;
import com.empresa.app.models.ProdutoModel;
import com.empresa.app.mappers.ProdutoMapper;
import com.empresa.app.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional(readOnly = true)
    public List<ProdutoResponseDto> findAll() {
        List<ProdutoModel> listaProdutoModel = produtoRepository.findAll();
        return listaProdutoModel.stream()
                .map(ProdutoMapper::toResponseDto) // Converte cada ProdutoModel para ProdutoResponseDto.
                                                   // ProdutoMapper::toResponseDto é uma "method reference".
                .toList();
    }

    @Transactional(readOnly = true)
    public ProdutoResponseDto findById(UUID id) {
        ProdutoModel produtoModel = produtoRepository.findById(id).orElse(null);

        if (produtoModel == null)
            return null;

        return ProdutoMapper.toResponseDto(produtoModel);
    }

    @Transactional
    public ProdutoResponseDto save(ProdutoRequestDto fornecedorRequestDto) {
        ProdutoModel produtoModel = produtoRepository.save(ProdutoMapper.toModel(fornecedorRequestDto));
        return ProdutoMapper.toResponseDto(produtoModel);
    }

    @Transactional
    public ProdutoResponseDto save(ProdutoResponseDto produtoResponseDto) {
        ProdutoModel produtoModel = produtoRepository.save(ProdutoMapper.toModel(produtoResponseDto));
        return ProdutoMapper.toResponseDto(produtoModel);
    }

    @Transactional
    public ProdutoResponseDto update(UUID id, ProdutoRequestDto produtoRequestDtoComAtualizacao) {
        ProdutoModel produtoModel = produtoRepository.findById(id).orElse(null);
        if (produtoModel != null) {
            produtoModel.setNome(produtoRequestDtoComAtualizacao.getNome());
            return ProdutoMapper.toResponseDto(produtoRepository.save(produtoModel));
        }
        return null;
    }

    @Transactional
    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }
}
