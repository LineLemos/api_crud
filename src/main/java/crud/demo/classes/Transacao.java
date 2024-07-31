package crud.demo.classes;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "Transação")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String origem;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false, unique = true)
    private String tipo;

    @Column(nullable = false)
    private LocalDate data;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta conta;

    // origem, destino, valor, tipo de operação: pix, transferência, etc.
    // saque/depósito
}
