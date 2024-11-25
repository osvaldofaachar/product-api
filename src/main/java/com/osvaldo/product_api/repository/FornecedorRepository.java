package com.osvaldo.product_api.repository;

import com.osvaldo.product_api.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}