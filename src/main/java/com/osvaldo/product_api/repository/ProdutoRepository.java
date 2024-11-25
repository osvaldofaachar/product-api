package com.osvaldo.product_api.repository;

import com.osvaldo.product_api.model.Categoria;
import com.osvaldo.product_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    // Buscar produtos por parte do nome (case insensitive)
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    // Buscar produtos por uma categoria
    List<Produto> findByCategoria(Categoria categoria);
}