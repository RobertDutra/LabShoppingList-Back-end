package com.br.lab.labshoppinglist.service.Interface;

import com.br.lab.labshoppinglist.entity.Categoria;

import java.util.List;

public interface CategoriaInterface {

    Categoria salvar(Categoria categoria);

    List<Categoria> listaCategorias();

    Categoria atualizar(Long id, Categoria categoria);

    Categoria buscar(Long id);

    void deletar(Long id);


}
