package com.empresa.app.models;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.*;

import java.util.UUID;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EstoqueModelPk {

    @NotNull
	@ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @EqualsAndHashCode.Include
    private UUID id_produto;

    @NotNull
    @NotBlank
    @ManyToOne
    @MapsId("cnpj")
    @JoinColumn(name = "cnpj_filial", referencedColumnName = "cnpj")
    @EqualsAndHashCode.Include
    private String cnpj_filial;
}
