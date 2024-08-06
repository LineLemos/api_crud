package crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import crud.demo.classes.Endereco;
import crud.demo.repository.EnderecoRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EnderecoService {

     @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> getAll(){
        return enderecoRepository.findAll();
    }

    public Endereco getById(Long id){
        return enderecoRepository.findById(id).orElse(null);
    }

    public Endereco create(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }


    public Endereco update(Endereco endereco, Long id){
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public Endereco delete(Long id){
        Endereco endereco = getById(id);
        enderecoRepository.delete(endereco);
        return endereco;
    }

public Endereco getEnderecoByCep(String cep) {
        
        Endereco endereco = new Endereco();
        OkHttpClient client = new OkHttpClient();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        Request request = new Request.Builder().
        url(url).
        build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null){
                String result = response.body().string();

                // Mapper
                Gson gson = new Gson();
                endereco = gson.fromJson(result, Endereco.class);

            } else {
                System.out.println("Erro ao buscar o CEP: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP: " + e.getMessage());
        }

        return endereco;
    }

}


