package com.empresa.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import com.empresa.app.dtos.FornecedorRequestDto;
import com.empresa.app.dtos.FornecedorResponseDto;
import com.empresa.app.models.FornecedorModel;
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
        return listaFornecedorModel.stream().map(FornecedorResponseDto::new).toList();
    }

    @Transactional(readOnly = true)
    public FornecedorResponseDto findById(UUID id) {
        FornecedorModel fornecedorModel = fornecedorRepository.findById(id).orElse(null);
        
        if(fornecedorModel == null)
            return null;
        
        return new FornecedorResponseDto(fornecedorModel);
    }

    @Transactional
    public FornecedorResponseDto save(FornecedorRequestDto fornecedorRequestDto) {
        return fornecedorRepository.save(fornecedorRequestDto.toModel()).toResponseDto();
    }

    @Transactional
    public FornecedorResponseDto save(FornecedorResponseDto fornecedorResponseDto) {
        return fornecedorRepository.save(fornecedorResponseDto.toModel()).toResponseDto();
    }
    
    @Transactional
    public FornecedorResponseDto update(UUID id, FornecedorRequestDto fornecedorRequestDtoComAtualizacao) {
        FornecedorResponseDto fornecedorResponseDtoExistente = findById(id);
        if (fornecedorResponseDtoExistente != null) {
            fornecedorResponseDtoExistente.setNome(fornecedorRequestDtoComAtualizacao.getNome());
            fornecedorResponseDtoExistente.setTelefone(fornecedorRequestDtoComAtualizacao.getTelefone());
            fornecedorResponseDtoExistente.setEndereco(fornecedorRequestDtoComAtualizacao.getEndereco());
            return save(fornecedorResponseDtoExistente);
        }
        return null;
    }
    
    @Transactional
    public void delete(UUID id) {
        fornecedorRepository.deleteById(id);
    }
}
