package com.empresa.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import com.empresa.app.dtos.FornecedorRequestDto;
import com.empresa.app.dtos.FornecedorResponseDto;
import com.empresa.app.models.FornecedorModel;
import com.empresa.app.mappers.FornecedorMapper;
import com.empresa.app.repositories.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional(readOnly = true)
    public List<FornecedorResponseDto> findAll() {
        List<FornecedorModel> listaFornecedorModel = fornecedorRepository.findAll();
        return listaFornecedorModel.stream()
                .map(FornecedorMapper::toResponseDto) // Converte cada FornecedorModel para FornecedorResponseDto.
                                                      // FornecedorMapper::toResponseDto é uma "method reference".
                .toList();
    }

    @Transactional(readOnly = true)
    public FornecedorResponseDto findById(UUID id) {
        FornecedorModel fornecedorModel = fornecedorRepository.findById(id).orElse(null);

        if (fornecedorModel == null)
            return null;

        return FornecedorMapper.toResponseDto(fornecedorModel);
    }

    @Transactional
    public FornecedorResponseDto save(FornecedorRequestDto fornecedorRequestDto) {
        FornecedorModel fornecedorModel = fornecedorRepository.save(FornecedorMapper.toModel(fornecedorRequestDto));
        return FornecedorMapper.toResponseDto(fornecedorModel);
    }

    @Transactional
    public FornecedorResponseDto save(FornecedorResponseDto fornecedorResponseDto) {
        FornecedorModel fornecedorModel = fornecedorRepository.save(FornecedorMapper.toModel(fornecedorResponseDto));
        return FornecedorMapper.toResponseDto(fornecedorModel);
    }

    @Transactional
    public FornecedorResponseDto update(UUID id, FornecedorRequestDto fornecedorRequestDtoComAtualizacao) {
        FornecedorModel fornecedorModel = fornecedorRepository.findById(id).orElse(null);
        if (fornecedorModel != null) {
            fornecedorModel.setNome(fornecedorRequestDtoComAtualizacao.getNome());
            fornecedorModel.setTelefone(fornecedorRequestDtoComAtualizacao.getTelefone());
            fornecedorModel.setEndereco(fornecedorRequestDtoComAtualizacao.getEndereco());
            return FornecedorMapper.toResponseDto(fornecedorRepository.save(fornecedorModel));
        }
        return null;
    }

    @Transactional
    public void delete(UUID id) {
        fornecedorRepository.deleteById(id);
    }
}
