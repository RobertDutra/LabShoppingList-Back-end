package com.br.lab.labshoppinglist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoriaDto {

    @NotBlank
    private String nome;

    private String descricao;
}
