package crud.demo.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import crud.demo.classes.Cliente;

@RestController
@RequestMapping("clientes")
public class ClienteControllers {

    // Get all clients
    @GetMapping
    public String getAllClientes() {
        if (!Cliente.clientes.isEmpty()) {
            // Usar o Gson para retornar os objetos
            return Cliente.clientes.toString();
        } else {
            return "Não há clientes cadastrados.";
        }
    }
    
    @PostMapping
    public String addCliente(@RequestBody Cliente cliente) {

        System.out.println("Adicionando cliente...");

        Cliente.clientes.add(cliente);
        return "Cliente adicionado com sucesso!";
    }

    @GetMapping("/{id}")
    public String getbyId(@PathVariable UUID id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                return cliente.toString();
            }
        }
        return "Cliente não encontrado.";
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable UUID id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                Cliente.clientes.remove(cliente);
                return "Cliente adicionado com sucesso!";
            }
        }
        return "Cliente não encontrado.";
    }
}
