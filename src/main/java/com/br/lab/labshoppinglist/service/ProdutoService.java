package com.br.lab.labshoppinglist.service;

import com.br.lab.labshoppinglist.dto.ProdutoDto;
import com.br.lab.labshoppinglist.entity.Produto;
import com.br.lab.labshoppinglist.repository.ProdutoRepository;
import com.br.lab.labshoppinglist.service.Interface.ProdutoInterface;
import com.br.lab.labshoppinglist.utils.ProdutoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements ProdutoInterface {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoDto salvar(ProdutoDto produtoDto) {
        this.produtoRepository.save(ProdutoMapper.dtoToEntity(produtoDto));
        return produtoDto;
    }
    @Override
    public List<Produto> listaProdutos() {
        return this.produtoRepository.findAll();
    }

    @Override
    public ProdutoDto atualizar(Long id, ProdutoDto produtoDto) {
        Optional<Produto> produto1 = this.produtoRepository.findById(id);
        if (produto1.isPresent()){
            Produto produto = ProdutoMapper.dtoToEntity(produtoDto);
            BeanUtils.copyProperties(produto, produto1.get(), "id");
            this.produtoRepository.save(produto1.get());
            return produtoDto;
        }
        else{
            throw new EntityNotFoundException("Produto com id " + id + " não encontrado!");
        }
    }
    @Override
    public Produto buscar(Long id) {
        return this.produtoRepository.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("Produto com id " + id + " não encontrado!");
        });
    }
    @Override
    public String deletar(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        if (produto.isPresent()){
            this.produtoRepository.delete(produto.get());
            return "Produto deletado com sucesso.";
        }
        return "Produto com id " + id + " não encontrado!";
    }
    @Override
    public String valorTotal(){
        List<Produto> produtosComprados = this.produtoRepository.findAll();
        Double valorTotal = 0.0;
        for (Produto produto: produtosComprados) {
            if (produto.isComprado()){
                valorTotal += produto.getValor();
            }
        }
        return "Valor total dos produtos: " + valorTotal ;
    }
}
