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

    @Column(nullable = false)
    @Enumerated
    private TipoTransacao tipoTransacao;

    @Column(nullable = false)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "conta_origem", referencedColumnName = "id")
    private Conta contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino", referencedColumnName = "id")
    private Conta contaDestino;

}