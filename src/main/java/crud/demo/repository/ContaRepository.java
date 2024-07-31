package crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crud.demo.classes.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
