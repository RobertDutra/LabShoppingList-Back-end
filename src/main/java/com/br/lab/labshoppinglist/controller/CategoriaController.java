package com.br.lab.labshoppinglist.controller;

import com.br.lab.labshoppinglist.entity.Categoria;
import com.br.lab.labshoppinglist.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.catalog.Catalog;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvarCategoria(@RequestBody Categoria categoria){
        return this.categoriaService.salvar(categoria);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listarCategorias(){
        return this.categoriaService.listaCategorias();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria buscarCategoria(@PathVariable Long id){
        return this.categoriaService.buscar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        return this.categoriaService.atualizar(id, categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletarCategoria(@PathVariable Long id){
        this.categoriaService.deletar(id);
    }


}
