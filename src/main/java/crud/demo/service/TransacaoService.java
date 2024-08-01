package crud.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.demo.classes.Transacao;
import crud.demo.repository.TransacaoRepository;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> getAll(){
        return transacaoRepository.findAll();
    }

    public Transacao getById(Long id){
        return transacaoRepository.findById(id).orElse(null);
    }

    public Transacao create(Transacao transacao){
        return transacaoRepository.save(transacao);
    }

}

