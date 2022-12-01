package com.br.lab.labshoppinglist.dto;

import com.br.lab.labshoppinglist.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProdutoDto {

    @NotBlank
    private String nome;

    @NotNull
    private Categoria categoria;

    @PositiveOrZero
    @NotNull
    private Double valor;

    private boolean comprado;
}
