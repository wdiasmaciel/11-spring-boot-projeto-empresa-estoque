package com.empresa.app.models;

import com.empresa.app.dtos.FilialDto;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import lombok.*;

@Entity
@Table(name = "filial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FilialModel {

    @Id
    @EqualsAndHashCode.Include
    private String cnpj;

    @NotNull
    @Column(unique = true)
    private String nome;

    @NotNull
    @Column(unique = true)
    private String telefone;

    @NotNull
    private String endereco;

    public FilialModel(FilialDto filialDto) throws IllegalArgumentException {
        if (filialDto == null)
            throw new IllegalArgumentException("FilialDto não pode ser nulo.");

        if (filialDto.getCnpj() == null)
            throw new IllegalArgumentException("FilialDto não pode ter CNPJ nulo.");

        BeanUtils.copyProperties(filialDto, this);
    }
}
