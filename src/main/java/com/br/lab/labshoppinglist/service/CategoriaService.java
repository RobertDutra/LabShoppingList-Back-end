package com.br.lab.labshoppinglist.service;

import com.br.lab.labshoppinglist.entity.Categoria;
import com.br.lab.labshoppinglist.entity.Produto;
import com.br.lab.labshoppinglist.repository.CategoriaRepository;
import com.br.lab.labshoppinglist.repository.ProdutoRepository;
import com.br.lab.labshoppinglist.service.Interface.CategoriaInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements CategoriaInterface {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Categoria salvar(Categoria categoria) {
        boolean categoria1 = this.categoriaRepository.existsByNome(categoria.getNome());

        return this.categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> listaCategorias() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public Categoria atualizar(Long id, Categoria categoria) {
        Optional<Categoria> categoria1 = categoriaRepository.findById(id);
        if(categoria1.isPresent()){
            BeanUtils.copyProperties(categoria, categoria1.get(), "id");
            return this.categoriaRepository.save(categoria1.get());
        }

        return null;
    }

    @Override
    public Categoria buscar(Long id) {
        return this.categoriaRepository.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("Categoria com id " + id + " não encontrado!");
        });
    }

    @Override
    public String deletar(Long id) {
        List<Produto> produtos = this.produtoRepository.findAll();
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        for (Produto produto: produtos) {
            if (categoria.get().getId() == produto.getCategoria().getId()){
                return "Categoria já associada a um produto.";
            }
        }
        if(categoria.isPresent()){
            this.categoriaRepository.delete(categoria.get());
            return "Categoria excluida com sucesso.";
        }
        return "Categoria com id " + id + " não encontrado!";
    }
}
