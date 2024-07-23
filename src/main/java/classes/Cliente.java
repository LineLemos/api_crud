package classes;

import lombok.Data;

@Data
public class Cliente {

    private String nome;
    private String cpf;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String dataNascimento;

}