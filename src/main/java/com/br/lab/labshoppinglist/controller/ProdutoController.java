package com.br.lab.labshoppinglist.controller;

import com.br.lab.labshoppinglist.dto.ProdutoDto;
import com.br.lab.labshoppinglist.entity.Produto;
import com.br.lab.labshoppinglist.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @ApiOperation("Serviço para criar um produto.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDto salvarProduto(@RequestBody @Valid ProdutoDto produtoDto){
        return this.produtoService.salvar(produtoDto);
    }

    @ApiOperation("Serviço para listar os produtos cadastrados.")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listaProdutos(){
        return this.produtoService.listaProdutos();
    }

    @ApiOperation("Serviço para procurar produto pelo Id.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto buscarProduto(@PathVariable Long id){
        return this.produtoService.buscar(id);
    }

    @ApiOperation("Serviço para atualizar produdo, passando o Id.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDto atualizarProduto(@PathVariable Long id, @RequestBody @Valid ProdutoDto produtoDto){
        return this.produtoService.atualizar(id,produtoDto);
    }

    @ApiOperation("Serviço para deletar produto, passando seu Id.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletarProduto(@PathVariable Long id){
        return this.produtoService.deletar(id);
    }

    @ApiOperation("Serviço para mostrar valor total dos produtos já comprados.")
    @GetMapping("/valortotal")
    @ResponseStatus(HttpStatus.OK)
    public String valorTotalProdutos(){
        return this.produtoService.valorTotal();
    }

}
