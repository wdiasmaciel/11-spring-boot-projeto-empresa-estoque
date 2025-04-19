package com.empresa.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import com.empresa.app.dtos.IdentificacaoRequestDto;
import com.empresa.app.dtos.IdentificacaoResponseDto;
import com.empresa.app.models.IdentificacaoModel;
import com.empresa.app.mappers.IdentificacaoMapper;
import com.empresa.app.repositories.IdentificacaoRepository;

@Service
public class IdentificacaoService {

    @Autowired
    private final IdentificacaoRepository identificacaoRepository;

    public IdentificacaoService(IdentificacaoRepository identificacaoRepository) {
        this.identificacaoRepository = identificacaoRepository;
    }

    @Transactional(readOnly = true)
    public List<IdentificacaoResponseDto> findAll() {
        List<IdentificacaoModel> listaIdentificacaoModel = identificacaoRepository.findAll();
        return listaIdentificacaoModel.stream()
                .map(IdentificacaoMapper::toResponseDto) // Converte cada IdentificacaoModel para IdentificacaoResponseDto.
                                                   // IdentificacaoMapper::toResponseDto é uma "method reference".
                .toList();
    }

    @Transactional(readOnly = true)
    public IdentificacaoResponseDto findById(UUID id) {
        IdentificacaoModel IdentificacaoModel = IdentificacaoRepository.findById(id).orElse(null);

        if (IdentificacaoModel == null)
            return null;

        return IdentificacaoMapper.toResponseDto(IdentificacaoModel);
    }

    @Transactional
    public IdentificacaoResponseDto save(IdentificacaoRequestDto fornecedorRequestDto) {
        IdentificacaoModel IdentificacaoModel = IdentificacaoRepository.save(IdentificacaoMapper.toModel(fornecedorRequestDto));
        return IdentificacaoMapper.toResponseDto(IdentificacaoModel);
    }

    @Transactional
    public IdentificacaoResponseDto save(IdentificacaoResponseDto IdentificacaoResponseDto) {
        IdentificacaoModel IdentificacaoModel = IdentificacaoRepository.save(IdentificacaoMapper.toModel(IdentificacaoResponseDto));
        return IdentificacaoMapper.toResponseDto(IdentificacaoModel);
    }

    @Transactional
    public IdentificacaoResponseDto update(UUID id, IdentificacaoRequestDto identificacaoRequestDtoComAtualizacao) {
        IdentificacaoModel IdentificacaoModel = IdentificacaoRepository.findById(id).orElse(null);
        if (IdentificacaoModel != null) {
            IdentificacaoModel.setNome(identificacaoRequestDtoComAtualizacao.getNome());
            return IdentificacaoMapper.toResponseDto(IdentificacaoRepository.save(IdentificacaoModel));
        }
        return null;
    }

    @Transactional
    public void delete(UUID id) {
        identificacaoRepository.deleteByProdutoModelId(id);
    }

    @Transactional
    public void delete(ProdutoResponseDto produtoResponseDto) {
        identificacaoRepository.delete(IdentificacaoMapper.toModel(produtoResponseDto);
    }
}
