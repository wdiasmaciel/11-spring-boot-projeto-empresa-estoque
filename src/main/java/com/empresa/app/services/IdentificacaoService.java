package com.empresa.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import com.empresa.app.dtos.IdentificacaoDto;
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
    public List<IdentificacaoDto> findAll() {
        List<IdentificacaoModel> listaIdentificacaoModel = identificacaoRepository.findAll();
        return listaIdentificacaoModel.stream()
                .map(IdentificacaoMapper::toDto) // Converte cada IdentificacaoModel para IdentificacaoDto.
                                                 // IdentificacaoMapper::toDto é uma "method reference".
                .toList();
    }

    @Transactional(readOnly = true)
    public IdentificacaoDto findById(UUID id) {
        IdentificacaoModel identificacaoModel = identificacaoRepository.findById(id).orElse(null);

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
    public IdentificacaoDto update(UUID id, IdentificacaoDto identificacaoDtoComAtualizacao) {
        IdentificacaoModel IdentificacaoModel = identificacaoRepository.findById(id).orElse(null);
        if (IdentificacaoModel != null) {
            IdentificacaoModel.setDescricao(identificacaoDtoComAtualizacao.getDescricao());
            IdentificacaoModel.setObservacao(identificacaoDtoComAtualizacao.getObservacao());
            return IdentificacaoMapper.toDto(identificacaoRepository.save(IdentificacaoModel));
        }
        return null;
    }

    @Transactional
    public void delete(UUID id) {
        identificacaoRepository.deleteById(id);
    }
}
