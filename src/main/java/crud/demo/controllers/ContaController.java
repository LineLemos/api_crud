package crud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import crud.demo.classes.Conta;
import crud.demo.service.ContaService;


@RestController
@RequestMapping("conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    //Buscar TODAS as contas
    @GetMapping
    public ResponseEntity<List<Conta>> getAll(){
        List<Conta> contas = contaService.getAll();
        return ResponseEntity.ok(contas);
    }

    //Buscar UMA CONTA por id
    @GetMapping("/{id}")
    public ResponseEntity<Conta> getById(@PathVariable Long id){
        Conta conta = contaService.getById(id);

        if(conta == null){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(conta);
    }

    //Criar um cliente
    @PostMapping
    public ResponseEntity<Conta> create(@RequestBody Conta conta){
        Conta contaSalva = contaService.create(conta);
        return ResponseEntity.ok(contaSalva);
    }
    //Atualizar um cliente
    @PutMapping("/{id}")
    public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta){
        Conta contaExistente = contaService.getById(id);

        if (contaExistente == null){
            return ResponseEntity.notFound().build();

        }

        contaExistente.setNumeroConta(conta.getNumeroConta());
        contaExistente.setSaldo(conta.getSaldo());

        Conta contaSalva = contaService.create(contaExistente);

        return ResponseEntity.ok(contaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Conta conta = contaService.getById(id);

        if (conta == null) {
            return ResponseEntity.notFound().build();
        }

        contaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
