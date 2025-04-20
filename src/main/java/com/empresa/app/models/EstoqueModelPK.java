package com.empresa.app.models;

import jakarta.persistence.Embeddable;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EstoqueModelPk implements Serializable {

    @EqualsAndHashCode.Include
    private UUID id_produto;

    @EqualsAndHashCode.Include
    private String cnpj_filial;
}
