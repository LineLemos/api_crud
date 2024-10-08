package crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.demo.classes.Cliente;
import crud.demo.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente atualizarCliente(Cliente clienteSalvo, Cliente clienteNovo) {

        if (clienteNovo.getNome() != null) {
            clienteSalvo.setNome(clienteNovo.getNome());
        }
        if (clienteNovo.getCpf() != null) {
            clienteSalvo.setCpf(clienteNovo.getCpf());
        }
        if (clienteNovo.getTelefone() != null) {
            clienteSalvo.setTelefone(clienteNovo.getTelefone());
        }
        if (clienteNovo.getDataNascimento() != null) {
            clienteSalvo.setDataNascimento(clienteNovo.getDataNascimento());
        }
        if (clienteNovo.getEndereco() != null) {
            clienteSalvo.setEndereco(clienteNovo.getEndereco());
        }
        if (clienteNovo.getEmail() != null) {
            clienteSalvo.setEmail(clienteNovo.getEmail());  
        }
        if (clienteNovo.isAtivo() == false) {
            clienteSalvo.setAtivo(false);
        }

        return clienteRepository.save(clienteSalvo);
    }

    public Cliente delete(Long id) {
        
        Cliente cliente = getById(id);

        Cliente clienteInativo = new Cliente();
        clienteInativo.setAtivo(false);

        return atualizarCliente(cliente, clienteInativo);

    }
}