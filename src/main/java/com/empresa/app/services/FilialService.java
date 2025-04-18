package com.empresa.app.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.empresa.app.dtos.FilialDto;
import com.empresa.app.models.FilialModel;
import com.empresa.app.mappers.FilialMapper;
import com.empresa.app.repositories.FilialRepository;

@Service
public class FilialService {

    @Autowired
    private final FilialRepository filialRepository;

    public FilialService(FilialRepository filialRepository) {
        this.filialRepository = filialRepository;
    }

    @Transactional(readOnly = true)
    public List<FilialDto> findAll() {
        List<FilialModel> listaFilialModel = filialRepository.findAll();
        return listaFilialModel.stream()
                .map(FilialMapper::toDto) // Converte cada FilialModel para FilialResponseDto.
                                          // FilialMapper::toDto é uma "method reference".
                .toList();
    }

    @Transactional(readOnly = true)
    public FilialDto findById(String cnpj) {
        return filialRepository.findById(cnpj) // Retorna um Optional<FilialModel>.
                .map(FilialMapper::toDto) // Converte o FilialModel para FilialDto apenas se o valor estiver presente.
                                          // FilialMapper::toDto é uma "method reference".
                .orElse(null); // Retorna null se o Optional estiver vazio (ou seja, se não encontrou a
                               // filial).
    }

    @Transactional
    public FilialDto save(FilialDto filialDto) {
        FilialModel filialModel = filialRepository.save(FilialMapper.toModel(filialDto));
        return FilialMapper.toDto(filialModel);
    }

    @Transactional
    public FilialDto update(String cnpj, FilialDto filialDtoComAtualizacao) {
        FilialModel filialModel = filialRepository.findById(cnpj).orElse(null);
        if (filialModel != null) {
            // Copia as propriedades de filialDtoComAtualizacao para filialModel, exceto a
            // propriedade "cnpj". Isso é útil para evitar que o cnpj seja sobrescrito.
            BeanUtils.copyProperties(filialDtoComAtualizacao, filialModel, "cnpj");
            // Salva a filialModel atualizada, converte para FilialDto e retorna a FilialDto.
            return FilialMapper.toDto(filialRepository.save(filialModel));
        }
        return null;
    }

    @Transactional
    public void delete(String cnpj) {
        filialRepository.deleteById(cnpj);
    }
}
