package com.br.lab.labshoppinglist.service.Interface;

import com.br.lab.labshoppinglist.entity.Categoria;
import com.br.lab.labshoppinglist.entity.Produto;

import java.util.List;

public interface ProdutoInterface {

    Produto salvar(Produto produto);

    List<Produto> listaProdutos();

    Produto atualizar(Long id, Produto produto);

    Produto buscar(Long id);

    String deletar(Long id);

    String valorTotal();
}
