package com.osvaldo.product_api.service;

import com.osvaldo.product_api.dto.FornecedorDTO;
import com.osvaldo.product_api.model.Fornecedor;
import com.osvaldo.product_api.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    //listarTodos: Retorna todos os fornecedores convertidos para DTOs.
    public List<FornecedorDTO> listarTodos() {
        return fornecedorRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //buscarPorId: Busca um fornecedor pelo ID. Lança exceção caso não seja encontrado.
    public FornecedorDTO buscarPorId(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        return toDTO(fornecedor);
    }

    //salvar: Converte o DTO em uma entidade e salva no banco de dados.
    public FornecedorDTO salvar(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = toEntity(fornecedorDTO);
        fornecedorRepository.save(fornecedor);
        return toDTO(fornecedor);
    }

    //atualizar: Atualiza os dados de um fornecedor existente.
    public FornecedorDTO atualizar(Long id, FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        fornecedorExistente.setNome(fornecedorDTO.getNome());
        fornecedorExistente.setContato(fornecedorDTO.getContato());
        fornecedorRepository.save(fornecedorExistente);
        return toDTO(fornecedorExistente);
    }

    //excluir: Verifica a existência do fornecedor e o remove.
    public void excluir(Long id) {
        if (!fornecedorRepository.existsById(id)) {
            throw new RuntimeException("Fornecedor não encontrado");
        }
        fornecedorRepository.deleteById(id);
    }

    private FornecedorDTO toDTO(Fornecedor fornecedor) {
        FornecedorDTO dto = new FornecedorDTO();
        dto.setId(fornecedor.getId());
        dto.setNome(fornecedor.getNome());
        dto.setContato(fornecedor.getContato());
        return dto;
    }

    private Fornecedor toEntity(FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(dto.getId());
        fornecedor.setNome(dto.getNome());
        fornecedor.setContato(dto.getContato());
        return fornecedor;
    }
}
