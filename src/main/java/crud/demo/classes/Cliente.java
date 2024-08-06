package crud.demo.classes;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "clientes")
public class Cliente {
   

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(length = 11)
    private String telefone;

    @Column(unique = true)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    
    @Column(name = "cliente_ativo", nullable = false)
    private boolean ativo = true;

}