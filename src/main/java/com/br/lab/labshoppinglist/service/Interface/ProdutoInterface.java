package com.br.lab.labshoppinglist.service.Interface;

import com.br.lab.labshoppinglist.dto.ProdutoDto;
import com.br.lab.labshoppinglist.entity.Produto;

import java.util.List;

public interface ProdutoInterface {

    ProdutoDto salvar(ProdutoDto produtoDto);

    List<Produto> listaProdutos();

    ProdutoDto atualizar(Long id, ProdutoDto produtoDto);

    Produto buscar(Long id);

    String deletar(Long id);

    String valorTotal();
}
