package crud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import crud.demo.classes.Endereco;
import crud.demo.service.EnderecoService;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    // GetAll
    @GetMapping
    public ResponseEntity<List<Endereco>> getAll() {
        return ResponseEntity.ok(enderecoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getById(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.create(endereco));
    }

    @PostMapping("/cep/{cep}")
    public ResponseEntity<Endereco> createEnderecoByCep(@PathVariable String cep) {
        // Tipo de resposta quando der erro
        return ResponseEntity.ok(enderecoService.getEnderecoByCep(cep));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.update(id, endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}