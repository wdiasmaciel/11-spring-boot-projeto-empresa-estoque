package com.empresa.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import com.empresa.app.dtos.IdentificacaoDto;
import com.empresa.app.dtos.ProdutoResponseDto;
import com.empresa.app.models.IdentificacaoModel;
import com.empresa.app.models.ProdutoModel;
import com.empresa.app.mappers.IdentificacaoMapper;
import com.empresa.app.mappers.ProdutoMapper;
import com.empresa.app.repositories.IdentificacaoRepository;

@Service
public class IdentificacaoService {

    @Autowired
    private final IdentificacaoRepository identificacaoRepository;

    public IdentificacaoService(IdentificacaoRepository identificacaoRepository) {
        this.identificacaoRepository = identificacaoRepository;
    }

    @Transactional(readOnly = true)
    public List<IdentificacaoDto> findAll() {
        List<IdentificacaoModel> listaIdentificacaoModel = identificacaoRepository.findAll();
        return listaIdentificacaoModel.stream()
                .map(IdentificacaoMapper::toDto) // Converte cada IdentificacaoModel para IdentificacaoDto.
                                                 // IdentificacaoMapper::toDto é uma "method reference".
                .toList();
    }

    @Transactional(readOnly = true)
    public IdentificacaoDto findById(ProdutoResponseDto produtoResponseDto) {
        ProdutoModel produtoModel = ProdutoMapper.toModel(produtoResponseDto);
        IdentificacaoModel identificacaoModel = identificacaoRepository.findById(produtoModel).orElse(null);

        if (identificacaoModel == null)
            return null;

        return IdentificacaoMapper.toDto(identificacaoModel);
    }

    @Transactional(readOnly = true)
    public IdentificacaoDto findById(UUID id) {
        IdentificacaoModel identificacaoModel = identificacaoRepository.findByProdutoModelId(id).orElse(null);

        if (identificacaoModel == null)
            return null;

        return IdentificacaoMapper.toDto(identificacaoModel);
    }

    @Transactional
    public IdentificacaoDto save(IdentificacaoDto identificacaoDto) {
        IdentificacaoModel identificacaoModel = identificacaoRepository.save(IdentificacaoMapper.toModel(identificacaoDto));
        return IdentificacaoMapper.toDto(identificacaoModel);
    }
    
    @Transactional
    public IdentificacaoDto update(ProdutoResponseDto produtoResponseDto, IdentificacaoDto identificacaoDtoComAtualizacao) {
        ProdutoModel produtoModel = ProdutoMapper.toModel(produtoResponseDto);
        IdentificacaoModel IdentificacaoModel = identificacaoRepository.findById(produtoModel).orElse(null);
        if (IdentificacaoModel != null) {
            IdentificacaoModel.setDescricao(identificacaoDtoComAtualizacao.getDescricao());
            IdentificacaoModel.setObservacao(identificacaoDtoComAtualizacao.getObservacao());
            return IdentificacaoMapper.toDto(identificacaoRepository.save(IdentificacaoModel));
        }
        return null;
    }
    
    @Transactional
    public IdentificacaoDto update(UUID id, IdentificacaoDto identificacaoDtoComAtualizacao) {
        IdentificacaoModel IdentificacaoModel = identificacaoRepository.findByProdutoModelId(id).orElse(null);
        if (IdentificacaoModel != null) {
            IdentificacaoModel.setDescricao(identificacaoDtoComAtualizacao.getDescricao());
            IdentificacaoModel.setObservacao(identificacaoDtoComAtualizacao.getObservacao());
            return IdentificacaoMapper.toDto(identificacaoRepository.save(IdentificacaoModel));
        }
        return null;
    }


    @Transactional
    public void delete(IdentificacaoDto identificacaoDto) {
        identificacaoRepository.delete(IdentificacaoMapper.toModel(identificacaoDto));
    }

    @Transactional
    public void delete(UUID id) {
        identificacaoRepository.deleteByProdutoModelId(id);
    }
}
