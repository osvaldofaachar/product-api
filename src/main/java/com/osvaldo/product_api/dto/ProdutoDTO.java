package com.osvaldo.product_api.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double preco;
    private Integer estoque;
    @NotNull()
    private Long categoriaId;

    @NotNull()
    private Long fornecedorId;
}