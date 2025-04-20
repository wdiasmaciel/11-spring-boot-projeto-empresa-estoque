package com.empresa.app.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import com.empresa.app.dtos.EstoqueDto;
import com.empresa.app.models.EstoqueModel;
import com.empresa.app.models.EstoqueModelPk;
import com.empresa.app.mappers.EstoqueMapper;
import com.empresa.app.repositories.EstoqueRepository;

@Service
public class EstoqueService {

    @Autowired
    private final EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Transactional(readOnly = true)
    public List<EstoqueDto> findAll() {
        List<EstoqueModel> listaEstoqueModel = estoqueRepository.findAll();
        return listaEstoqueModel.stream()
                .map(EstoqueMapper::toDto) // Converte cada EstoqueModel para EstoqueDto.
                                           // EstoqueMapper::toDto é uma "method reference".
                .toList();
    }

    @Transactional(readOnly = true)
    public EstoqueDto findById_produdtoCnpj_filial(UUID id_produto, String cnpj_filial) {
        EstoqueModelPk estoqueModelPk = new EstoqueModelPk(id_produto, cnpj_filial);
        return estoqueRepository.findById(estoqueModelPk) // Retorna um Optional<EstoqueModel>.
                .map(EstoqueMapper::toDto) // Converte o EstoqueModel para EstoqueDto apenas se o valor estiver presente.
                                           // EstoqueMapper::toDto é uma "method reference".
                .orElse(null); // Retorna null se o Optional estiver vazio (ou seja, se não encontrou o
                               // estoque).
    }

    @Transactional
    public EstoqueDto save(EstoqueDto estoqueDto) {
        EstoqueModel estoqueModel = estoqueRepository.save(EstoqueMapper.toModel(estoqueDto));
        return EstoqueMapper.toDto(estoqueModel);
    }

    @Transactional
    public EstoqueDto update(UUID id_produto, String cnpj_filial, EstoqueDto estoqueDtoComAtualizacao) {
        EstoqueModelPk estoqueModelPk = new EstoqueModelPk(id_produto, cnpj_filial);
        EstoqueModel estoqueModel = estoqueRepository.findById(estoqueModelPk).orElse(null);
        if (estoqueModel != null) {
            // Copia as propriedades de estoqueDtoComAtualizacao para estoqueModel, exceto as
            // propriedades "id_produto" e "cnpj_filial". Isso é útil para evitar que o id_produto e o cnpj_filial sejam sobrescritos.
            BeanUtils.copyProperties(estoqueDtoComAtualizacao, estoqueModel, "id_produto", "cnpj_filial");
            // Salva a filialModel atualizada, converte para FilialDto e retorna a FilialDto.
            return EstoqueMapper.toDto(estoqueRepository.save(estoqueModel));
        }
        return null;
    }

    @Transactional
    public void delete(UUID id_produto, String cnpj_filial) {
        EstoqueModelPk estoqueModelPk = new EstoqueModelPk(id_produto, cnpj_filial);
        estoqueRepository.deleteById(estoqueModelPk);
    }
}
