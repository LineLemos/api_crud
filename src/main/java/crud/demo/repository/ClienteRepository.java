package crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crud.demo.classes.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}