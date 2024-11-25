package com.osvaldo.product_api.controller;

import com.osvaldo.product_api.dto.FornecedorDTO;
import com.osvaldo.product_api.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/")
    public ResponseEntity<List<FornecedorDTO>> listarTodos() {
        return ResponseEntity.ok(fornecedorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.buscarPorId(id));
    }

    @PostMapping("/")
    public ResponseEntity<FornecedorDTO> salvar(@RequestBody FornecedorDTO fornecedorDTO) {
        return ResponseEntity.ok(fornecedorService.salvar(fornecedorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorDTO> atualizar(@PathVariable Long id, @RequestBody FornecedorDTO fornecedorDTO) {
        return ResponseEntity.ok(fornecedorService.atualizar(id, fornecedorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        fornecedorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}