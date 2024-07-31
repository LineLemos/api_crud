package crud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import crud.demo.classes.Transacao;
import crud.demo.service.TransacaoService;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    // Buscar todos os clientes - getAll
    @GetMapping
    public ResponseEntity<List<Transacao>> getAll() {
        List<Transacao> transacoes = transacaoService.getAll();
        return ResponseEntity.ok(transacoes);
    }
    
    // Buscar um cliente por id - getById
    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getById(@PathVariable Long id) {
        Transacao transacao = transacaoService.getById(id);

        if (transacao == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transacao);
    }

    // Criar um cliente - create
    @PostMapping
    public ResponseEntity<Transacao> create(@RequestBody Transacao transacao) {
        Transacao transacaoSalvo = transacaoService.create(transacao);
        return ResponseEntity.ok(transacaoSalvo);
    }

    // Atualizar um cliente - update
    // Combinação do getById e create
    @PutMapping("/{id}")
    public ResponseEntity<Transacao> update(@PathVariable Long id, @RequestBody Transacao transacao) {
        Transacao transacaoExistente = transacaoService.getById(id);

        if (transacaoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        transacaoExistente.setOrigem(transacao.getOrigem());
        transacaoExistente.setDestino(transacao.getDestino());
        transacaoExistente.setTipo(transacao.getTipo());
        transacaoExistente.setData(transacao.getData());
        

        Transacao transacaoSalvo = transacaoService.create(transacaoExistente);

        return ResponseEntity.ok(transacaoSalvo);
    }

    // Deletar um cliente - delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Transacao transacao = transacaoService.getById(id);

        if (transacao == null) {
            return ResponseEntity.notFound().build();
        }

        transacaoService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
}