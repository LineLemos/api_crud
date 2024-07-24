package crud.demo.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import classes.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("clientes")
public class ClienteControllers {

    // Get all clients
    @GetMapping
    public String getAllClientes() {
        // if(!Cliente.clientes.isEmpty()) {
        //     // Usar o Gson para retornar os objetos
        //     return Cliente.clientes.toString();
        // } else {
        //     return "Não há clientes cadastrados.";
        // }
        return "teste";
    }

    @PostMapping
    public String addCliente(@RequestBody Cliente cliente) {

        System.out.println("Adicionando cliente...");

        Cliente.clientes.add(cliente);
        return "Cliente adicionado com sucesso!";
    }

    @GetMapping("(id)")
    public String getbyId(@RequestParam UUID id){
        for(Cliente cliente: Cliente.clientes){
            if(cliente.getId().equals(id)){
                return cliente.toString();
            }
        }
        return "Cliente não encontrado.";
    }

    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    // @DeleteMapping
    // public String deleteCliente(UUID id){
    //     Cliente.clientes
    // }
}

