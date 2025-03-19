package com.empresa.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import com.empresa.app.dtos.FornecedorDto;
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
    public List<FornecedorDto> findAll() {
        List<FornecedorModel> listaFornecedorModel = fornecedorRepository.findAll();
        return listaFornecedorModel.stream().map(FornecedorDto::new).toList();
    }

    @Transactional(readOnly = true)
    public FornecedorModel findById(UUID id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    @Transactional
    public FornecedorModel save(FornecedorModel fornecedorModel) {
        return fornecedorRepository.save(fornecedorModel);
    }

    @Transactional
    public void delete(UUID id) {
        fornecedorRepository.deleteById(id);
    }
}
