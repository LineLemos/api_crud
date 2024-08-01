package crud.demo.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tipo;

    private LocalDateTime data = LocalDateTime.now();

    @Column(nullable = false)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "conta_origem_id", referencedColumnName = "id")
    private Conta origem;
 
    @ManyToOne
    @JoinColumn(name = "conta_destino_id", referencedColumnName = "id")
    private Conta destino;



    // origem, destino, valor, tipo de operação: pix, transferência, etc.
    // saque/depósito
}
