package crud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import crud.demo.classes.Transacao;
import crud.demo.service.TransacaoService;

@RestController.
@RequestMapping("transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

   
    @GetMapping
    public ResponseEntity<List<Transacao>> getAll() {
        List<Transacao> transacoes = transacaoService.getAll();
        return ResponseEntity.ok(transacoes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getById(@PathVariable Long id) {
        Transacao transacao = transacaoService.getById(id);

        if (transacao == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transacao);
    }

    @PostMapping
    public ResponseEntity<Transacao> create(@RequestBody Transacao transacao) {
        Transacao transacaoSalvo = transacaoService.create(transacao);
        return ResponseEntity.ok(transacaoSalvo);
    }

}