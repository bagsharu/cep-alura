package bagsharu.principal;

import bagsharu.consulta.ConsultaCEP;
import bagsharu.consulta.Info;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args){


        /*
        // Recebe a URL correspondente do CEP.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/01001000/json/"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Verificação da requisição json.
        System.out.println(response.body());
        */

        ConsultaCEP consultarCEP = new ConsultaCEP();

        Info endereco = consultarCEP.Consultar("01001000");
        System.out.println(endereco);
    }
}
