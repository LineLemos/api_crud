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


    public Conta update(Long id, Conta conta){
        Conta contaExistente = getById(id);

        if(contaExistente == null){
            return null;
        }

        contaExistente.setNumeroConta(conta.getNumeroConta());
        contaExistente.setSaldo(conta.getSaldo());
       
        return contaRepository.save(contaExistente);

    }

    public void delete(Long id){
        contaRepository.deleteById(id);
    }
}
