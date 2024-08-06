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

   
    @GetMapping
    public ResponseEntity<List<Transacao>> getAll() {
        List<Transacao> transacoes = transacaoService.getAll();
        return ResponseEntity.ok(transacoes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getByid(@PathVariable Long id){
        return ResponseEntity.ok(transacaoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Transacao transacao){
        if( transacao.getContaOrigem().temSaldo(transacao.getValor()) ) {
            return ResponseEntity.ok(transacaoService.create(transacao));
        }
        return ResponseEntity.badRequest().body("Saldo insuficiente");
    }

}