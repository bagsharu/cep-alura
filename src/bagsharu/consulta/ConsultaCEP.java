package bagsharu.consulta;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {

    public Info Consultar(String cepConsulta) {

        // Recebe o CEP para consulta e concatena em uma URL.

        var busca = "https://viacep.com.br/ws/" + cepConsulta + "/json/";

        // Instancia um objeto "client" e "request"
        HttpClient client = HttpClient.newHttpClient();

        // Realiza o acesso à API viaCEP.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busca))
                .build();

        // Bloco try-catch para lidar com erros de formatação
        try {

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Info.class);

        } catch (Exception e) {
            // Caso o CEP tenha sido informado incorretamente, lança a seguinte mensagem:
            throw new RuntimeException("CEP inválido! Não foi possível realizar a operação.");
        }

    }
}
