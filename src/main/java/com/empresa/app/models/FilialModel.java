package com.empresa.app.models;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
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
}
