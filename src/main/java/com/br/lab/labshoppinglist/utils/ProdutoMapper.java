package com.br.lab.labshoppinglist.utils;

import com.br.lab.labshoppinglist.dto.CategoriaDto;
import com.br.lab.labshoppinglist.dto.ProdutoDto;
import com.br.lab.labshoppinglist.entity.Categoria;
import com.br.lab.labshoppinglist.entity.Produto;
import org.springframework.beans.BeanUtils;

public class ProdutoMapper {

    public static Produto dtoToEntity(ProdutoDto produtoDto){
        var produtoEntity = new Produto();
        BeanUtils.copyProperties(produtoDto, produtoEntity);
        return produtoEntity;
    }

    public static ProdutoDto entityToDto(Produto produto){
        var produtoDto = new ProdutoDto();
        BeanUtils.copyProperties(produto, produtoDto);
        return produtoDto;
    }
}
