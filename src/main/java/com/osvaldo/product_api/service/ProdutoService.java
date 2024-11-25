package com.osvaldo.product_api.service;

import com.osvaldo.product_api.dto.ProdutoDTO;
import com.osvaldo.product_api.model.Categoria;
import com.osvaldo.product_api.model.Fornecedor;
import com.osvaldo.product_api.model.Produto;
import com.osvaldo.product_api.repository.CategoriaRepository;
import com.osvaldo.product_api.repository.FornecedorRepository;
import com.osvaldo.product_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {



        @Autowired
        private ProdutoRepository produtoRepository;

        @Autowired
        private CategoriaRepository categoriaRepository;

        @Autowired
        private FornecedorRepository fornecedorRepository;

        public List<ProdutoDTO> listarTodos() {
            return produtoRepository.findAll()
                    .stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        }

        public ProdutoDTO buscarPorId(Long id) {
            Produto produto = produtoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            return toDTO(produto);
        }
    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
        // Verifica se os IDs não são nulos
        if (produtoDTO.getCategoriaId() == null || produtoDTO.getFornecedorId() == null) {
            throw new IllegalArgumentException("Categoria ID ou Fornecedor ID não podem ser nulos");
        }

        Categoria categoria = categoriaRepository.findById(produtoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Fornecedor fornecedor = fornecedorRepository.findById(produtoDTO.getFornecedorId())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        Produto produto = toEntity(produtoDTO, categoria, fornecedor);
        produtoRepository.save(produto);
        return toDTO(produto);
    }
        public ProdutoDTO atualizar(Long id, ProdutoDTO produtoDTO) {
            Produto produtoExistente = produtoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            Categoria categoria = categoriaRepository.findById(produtoDTO.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

            Fornecedor fornecedor = fornecedorRepository.findById(produtoDTO.getFornecedorId())
                    .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

            produtoExistente.setNome(produtoDTO.getNome());
            produtoExistente.setPreco(produtoDTO.getPreco());
            produtoExistente.setEstoque(produtoDTO.getEstoque());
            produtoExistente.setCategoria(categoria);
            produtoExistente.setFornecedor(fornecedor);

            produtoRepository.save(produtoExistente);
            return toDTO(produtoExistente);
        }

        public void excluir(Long id) {
            if (!produtoRepository.existsById(id)) {
                throw new RuntimeException("Produto não encontrado");
            }
            produtoRepository.deleteById(id);
        }

        private ProdutoDTO toDTO(Produto produto) {
            ProdutoDTO dto = new ProdutoDTO();
            dto.setId(produto.getId());
            dto.setNome(produto.getNome());
            dto.setPreco(produto.getPreco());
            dto.setEstoque(produto.getEstoque());
            dto.setCategoriaId(produto.getCategoria().getId());
            dto.setFornecedorId(produto.getFornecedor().getId());
            return dto;
        }

        private Produto toEntity(ProdutoDTO dto, Categoria categoria, Fornecedor fornecedor) {
            Produto produto = new Produto();
            produto.setId(dto.getId());
            produto.setNome(dto.getNome());
            produto.setPreco(dto.getPreco());
            produto.setEstoque(dto.getEstoque());
            produto.setCategoria(categoria);
            produto.setFornecedor(fornecedor);
            return produto;
        }
    }

