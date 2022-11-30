package com.br.lab.labshoppinglist.service;

import com.br.lab.labshoppinglist.dto.CategoriaDto;
import com.br.lab.labshoppinglist.entity.Categoria;
import com.br.lab.labshoppinglist.entity.Produto;
import com.br.lab.labshoppinglist.execptions.InvalidCategoriaException;
import com.br.lab.labshoppinglist.repository.CategoriaRepository;
import com.br.lab.labshoppinglist.repository.ProdutoRepository;
import com.br.lab.labshoppinglist.service.Interface.CategoriaInterface;
import com.br.lab.labshoppinglist.utils.CategoriaMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements CategoriaInterface {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public CategoriaDto salvar(CategoriaDto categoriaDto) {
        boolean categoria1 = this.categoriaRepository.existsByNome(categoriaDto.getNome());
        if (categoria1){
            throw new EntityNotFoundException("Categoria já cadastrada.");
        }
        this.categoriaRepository.save(CategoriaMapper.dtoToEntity(categoriaDto));
        return categoriaDto;
    }

    @Override
    public List<Categoria> listaCategorias() {
//        Caso tenha como retorno CategoriaDto
//        return this.categoriaRepository.findAll().stream().map(CategoriaMapper::dtoToEntity).collect(Collectors.toList());
        return this.categoriaRepository.findAll();
    }

    @Override
    public CategoriaDto atualizar(Long id, CategoriaDto categoriaDto) {
        Optional<Categoria> categoriaBuscada = categoriaRepository.findById(id);
        if(categoriaBuscada.isPresent()){
            Categoria categoria = CategoriaMapper.dtoToEntity(categoriaDto);
            BeanUtils.copyProperties(categoria, categoriaBuscada.get(), "id");
            this.categoriaRepository.save(categoriaBuscada.get());
            return categoriaDto;
        }
        else{
            throw new EntityNotFoundException("Categoria com id " + id + " não encontrado!");
        }
    }

    @Override
    public Categoria buscar(Long id) {
        return this.categoriaRepository.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("Categoria com id " + id + " não encontrado!");
        });
    }

    @Override
    public String deletar(Long id) throws InvalidCategoriaException {
        List<Produto> produtos = this.produtoRepository.findAll();
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);

        if(categoria.isPresent()){
        for (Produto produto: produtos) {
            if (categoria.get().getId() == produto.getCategoria().getId()){
                return "Categoria já associada a um produto.";
                }
            }
            this.categoriaRepository.delete(categoria.get());
            return "Categoria excluida com sucesso.";
        }
        return "Categoria com id " + id + " não encontrado!";
    }
}
