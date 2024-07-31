package crud.demo.service;

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

    public Transacao getbById(Long id){
        return transacaoRepository.findById(id).orElse(null);
    }

    public Transacao create(Transacao transacao){
        return transacaoRepository.save(transacao);
    }

    public Transacao update (Long id, Transacao transacao){
        Transacao transacaoExistente = getById(id);

        if (transacaoExistente == null){
            return null;
        }

        transacaoExistente.setOrigem(transacao.getOrigem());
        transacaoExistente.setDestino(transacao.getDestino());
        transacaoExistente.setTipo(transacao.getTipo());
        transacaoExistente.setData(transacao.getData());
        
        return transacaoRepository.save(transacaoExistente);
    }

    public void delete(Long id){
        transacaoRepository.deleteById(id);
    }
}

