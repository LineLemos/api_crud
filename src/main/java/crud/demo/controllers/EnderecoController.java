package crud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import crud.demo.classes.Endereco;
import crud.demo.service.EnderecoService;

public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    // Buscar todos os enderecos - getAll
    @GetMapping
    public ResponseEntity<List<Endereco>> getAll() {
        List<Endereco> enderecos = enderecoService.getAll();
        return ResponseEntity.ok(enderecos);
    }
    
   
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getById(@PathVariable Long id) {
        Endereco endereco = enderecoService.getById(id);

        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(endereco);
    }

  
    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco) {
        Endereco enderecoSalvo = enderecoService.create(endereco);
        return ResponseEntity.ok(enderecoSalvo);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco) {
        Endereco enderecoExistente = enderecoService.getById(id);

        if (enderecoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        enderecoExistente.setCep(endereco.getCep());
       
        Endereco enderecoSalvo = enderecoService.create(enderecoExistente);

        return ResponseEntity.ok(enderecoSalvo);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Endereco endereco = enderecoService.getById(id);

        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }

        enderecoService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
}


