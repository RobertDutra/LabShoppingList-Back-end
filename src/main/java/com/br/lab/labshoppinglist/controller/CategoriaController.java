package com.br.lab.labshoppinglist.controller;

import com.br.lab.labshoppinglist.dto.CategoriaDto;
import com.br.lab.labshoppinglist.entity.Categoria;
import com.br.lab.labshoppinglist.execptions.InvalidCategoriaException;
import com.br.lab.labshoppinglist.service.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @ApiOperation("Serviço para cadastrar categoria.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDto salvarCategoria(@RequestBody @Valid CategoriaDto categoriaDto){
        return this.categoriaService.salvar(categoriaDto);
    }

    @ApiOperation("Serviço para listar categorias cadastradas.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listarCategorias(){
        return this.categoriaService.listaCategorias();
    }

    @ApiOperation("Serviço para buscar categoria, passando seu Id.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria buscarCategoria(@PathVariable Long id){
        return this.categoriaService.buscar(id);
    }

    @ApiOperation("Serviço para atualizar categoria, passando seu Id.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaDto atualizarCategoria(@PathVariable Long id, @RequestBody @Valid CategoriaDto categoriaDto){
        return this.categoriaService.atualizar(id, categoriaDto);
    }

    @ApiOperation("Serviço para deletar categoria, passando seu Id.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletarCategoria(@PathVariable Long id) throws InvalidCategoriaException {
        return this.categoriaService.deletar(id);
    }


}
