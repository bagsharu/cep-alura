package bagsharu.principal;

import bagsharu.consulta.ConsultaCEP;
import bagsharu.consulta.Info;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

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

        /*
        // Implementação básica da consulta

        Info endereco = consultarCEP.Consultar("01001000");
        System.out.println(endereco);

        */

        ConsultaCEP consultarCEP = new ConsultaCEP();
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe o CEP a ser recebido: ");
        System.out.println("Atente-se à formação, o CEP NÃO pode conter mais que oito digitos ou caracteres além de números!");
        var buscaCEP = leitura.nextLine();

        try {
            Info endereco = consultarCEP.Consultar(buscaCEP);
            // System.out.println(endereco);
            System.out.println("As informações foram registradas em " + endereco.cep() + ".json !");
            GeradorArquivo gerarArquivo = new GeradorArquivo();
            gerarArquivo.escritaArquivo(endereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Encerrando a aplicação.");
        }


    }
}
