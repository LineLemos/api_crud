package crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crud.demo.classes.Endereco;


public interface EnderecoRepository extends JpaRepository <Endereco, Long> {

}
