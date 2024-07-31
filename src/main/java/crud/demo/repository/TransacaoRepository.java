package crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crud.demo.classes.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
