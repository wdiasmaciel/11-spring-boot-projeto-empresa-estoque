package com.empresa.app.models;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Embeddable;

import jakarta.validation.constraints.NotNull;

import lombok.*;

import java.util.UUID;

@Data
@Embeddable
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EstoqueModelPK {

    @NotNull
	@ManyToOne
    @MapsId("id")
    @Column(name = "id_produto")
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @EqualsAndHashCode.Include
    private UUID id_produto;

    @NotNull
    @ManyToOne
    @MapsId("cnpj")
    @Column(name = "cnpj_filial")
    @JoinColumn(name = "cnpj_filial", referencedColumnName = "cnpj")
    @EqualsAndHashCode.Include
    private String cnpj_filial;
}
