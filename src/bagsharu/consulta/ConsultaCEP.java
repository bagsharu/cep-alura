package bagsharu.consulta;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {

    public Info Consultar(String cepConsulta) {

        var busca = "https://viacep.com.br/ws/" + cepConsulta + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busca))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Info.class);

        } catch (Exception e) {
            throw new RuntimeException("CEP inválido! Não foi possível realizar a operação.");
        }

    }
}
