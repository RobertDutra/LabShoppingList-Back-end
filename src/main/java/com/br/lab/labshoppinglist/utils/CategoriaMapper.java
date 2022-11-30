package com.br.lab.labshoppinglist.utils;

import com.br.lab.labshoppinglist.dto.CategoriaDto;
import com.br.lab.labshoppinglist.entity.Categoria;
import org.springframework.beans.BeanUtils;

public class CategoriaMapper {

    public static Categoria dtoToEntity(CategoriaDto categoriaDto){
        var categoriaEntity = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoriaEntity);
        return categoriaEntity;
    }

    public static CategoriaDto entityToDto(Categoria categoria){
        var categoriaDto = new CategoriaDto();
        BeanUtils.copyProperties(categoria, categoriaDto);
        return categoriaDto;
    }
}
