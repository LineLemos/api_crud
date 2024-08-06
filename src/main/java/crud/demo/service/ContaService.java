package crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.demo.classes.Conta;
import crud.demo.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getAll(){
        return contaRepository.findAll();
    }

    public Conta getById(Long id){
        return contaRepository.findById(id).orElse(null);
    }

    public Conta create(Conta conta) {
        return contaRepository.save(conta);
    }


    public Conta atualizarConta(Conta conta, Long id){
        Conta contaAtualizar = getById(id);
         if (contaAtualizar == null) {
             return null;
             }
             contaAtualizar.setSaldo(conta.getSaldo());
            return contaRepository.save(contaAtualizar);
     }

    public void delete(Long id){
        contaRepository.deleteById(id);
    }
}
