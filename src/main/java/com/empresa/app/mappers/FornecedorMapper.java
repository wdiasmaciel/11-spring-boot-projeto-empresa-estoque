package com.empresa.app.mappers;

import com.empresa.app.dtos.FornecedorRequestDto;
import com.empresa.app.dtos.FornecedorResponseDto;
import com.empresa.app.models.FornecedorModel;
import org.springframework.beans.BeanUtils;

public class FornecedorMapper {

    public static FornecedorModel toModel(FornecedorRequestDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("FornecedorRequestDto não pode ser nulo.");
        return new FornecedorModel(dto.getNome(), dto.getTelefone(), dto.getEndereco());
    }

    public static FornecedorModel toModel(FornecedorResponseDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("FornecedorResponseDto não pode ser nulo.");
        return new FornecedorModel(dto.getId(), dto.getNome(), dto.getTelefone(), dto.getEndereco());
    }

    public static FornecedorResponseDto toResponseDto(FornecedorModel model) {
        if (model == null)
            throw new IllegalArgumentException("FornecedorModel não pode ser nulo.");
        return new FornecedorResponseDto(model.getId(), model.getNome(), model.getTelefone(), model.getEndereco());
    }

    public static FornecedorRequestDto toRequestDto(FornecedorModel model) {
        if (model == null)
            throw new IllegalArgumentException("FornecedorModel não pode ser nulo.");
        return new FornecedorRequestDto(model.getNome(), model.getTelefone(), model.getEndereco());
    }

    // Atualiza os dados de um model com base no DTO, ignorando o id.
    public static void atualizarModel(FornecedorRequestDto dto, FornecedorModel model) {
        if (dto == null || model == null)
            throw new IllegalArgumentException("DTO e Model não podem ser nulos.");
        BeanUtils.copyProperties(dto, model, "id");
    }
}
