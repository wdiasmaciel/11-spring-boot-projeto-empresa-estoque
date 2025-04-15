package com.empresa.app.mappers;

import com.empresa.app.dtos.FilialDto;
import com.empresa.app.models.FilialModel;

public class FilialMapper {

    public static FilialModel toModel(FilialDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("FilialDto não pode ser nulo.");
        return new FilialModel(dto.getCnpj(), dto.getNome(), dto.getTelefone(), dto.getEndereco());
    }

    public static FilialDto toDto(FilialModel model) {
        if (model == null)
            throw new IllegalArgumentException("FlialModel não pode ser nulo.");
        return new FilialDto(model.getCnpj(), model.getNome(), model.getTelefone(), model.getEndereco());
    }
}
