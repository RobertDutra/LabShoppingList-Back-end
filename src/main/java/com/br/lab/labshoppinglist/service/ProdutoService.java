package com.br.lab.labshoppinglist.service;

import com.br.lab.labshoppinglist.entity.Produto;
import com.br.lab.labshoppinglist.repository.ProdutoRepository;
import com.br.lab.labshoppinglist.service.Interface.ProdutoInterface;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PostLoad;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements ProdutoInterface {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listaProdutos() {
        return this.produtoRepository.findAll();
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        Optional<Produto> produto1 = this.produtoRepository.findById(id);
        if (produto1.isPresent()){
            BeanUtils.copyProperties(produto, produto1.get(), "id");
            return this.produtoRepository.save(produto1.get());
        }


        return null;
    }

    @Override
    public Produto buscar(Long id) {
        return this.produtoRepository.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("Produto com id " + id + " não encontrado!");
        });
    }

    @Override
    public void deletar(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        if (produto.isPresent()){
            this.produtoRepository.delete(produto.get());}
    }
}
