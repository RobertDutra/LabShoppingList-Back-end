package com.br.lab.labshoppinglist.service.Interface;

import com.br.lab.labshoppinglist.dto.CategoriaDto;
import com.br.lab.labshoppinglist.entity.Categoria;
import com.br.lab.labshoppinglist.execptions.InvalidCategoriaException;


import java.util.List;

public interface CategoriaInterface {

    CategoriaDto salvar(CategoriaDto dto);

    List<Categoria> listaCategorias();

    CategoriaDto atualizar(Long id, CategoriaDto categoriaDto);

    Categoria buscar(Long id);

    String deletar(Long id) throws InvalidCategoriaException;


}
