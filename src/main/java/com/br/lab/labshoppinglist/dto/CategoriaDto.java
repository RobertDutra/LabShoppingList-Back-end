package com.br.lab.labshoppinglist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoriaDto {

    @NotBlank
    private String nome;

    private String descricao;
}
