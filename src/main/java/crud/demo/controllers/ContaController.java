package crud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import crud.demo.classes.Conta;
import crud.demo.service.ContaService;


@RestController
@RequestMapping("contas")
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

    
    @PostMapping
    public ResponseEntity<Conta> create(@RequestBody Conta conta){
        Conta contaSalva = contaService.create(conta);
        return ResponseEntity.ok(contaSalva);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizarConta(@PathVariable Long id, @RequestBody Conta contaAtualizada){
       Conta conta = contaService.getById(id);
       if (conta == null) {
        return null;
        }
        conta.setSaldo(contaAtualizada.getSaldo());
        return ResponseEntity.ok(conta);

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
