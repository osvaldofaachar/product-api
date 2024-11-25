package com.osvaldo.product_api.repository;

import com.osvaldo.product_api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}