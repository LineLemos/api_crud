package crud.demo.classes;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "Conta Corrente")
public class Conta {
    public static ArrayList<Conta> contas = new ArrayList<Conta>();

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numeroConta;

    @Column(nullable = false)
    private Double Saldo;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

}