package com.br.lab.labshoppinglist.controller;

import com.br.lab.labshoppinglist.entity.Categoria;
import com.br.lab.labshoppinglist.entity.Produto;
import com.br.lab.labshoppinglist.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvarProduto(@RequestBody Produto produto){
        return this.produtoService.salvar(produto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listaProdutos(){
        return this.produtoService.listaProdutos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto buscarProduto(@PathVariable Long id){
        return this.produtoService.buscar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto){
        return this.produtoService.atualizar(id,produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarProduto(@PathVariable Long id){
        this.produtoService.deletar(id);
    }

}
