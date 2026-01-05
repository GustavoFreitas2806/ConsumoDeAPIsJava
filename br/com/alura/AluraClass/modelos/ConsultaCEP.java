package br.com.alura.AluraClass.modelos;

import br.com.alura.AluraClass.excecao.ErroDeCEP;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {

    HttpResponse<String> response;

    public Endereco buscaEndereco(String cep) throws ErroDeCEP {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP");
        }

        return new Gson().fromJson(response.body(), Endereco.class);
    }
}
