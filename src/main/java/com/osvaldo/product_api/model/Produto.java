package com.osvaldo.product_api.model;

import jakarta.persistence.*;
import lombok.Data;

    @Data
    @Entity
    @Table(name = "produtos")
    public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String nome;

        @Column(nullable = false)
        private Double preco;

        @Column(nullable = false)
        private Integer estoque;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "categoria_id", nullable = false)
        private Categoria categoria;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "fornecedor_id", nullable = false)
        private Fornecedor fornecedor;
    }

