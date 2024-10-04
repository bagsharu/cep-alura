package bagsharu.principal;

import bagsharu.consulta.ConsultaCEP;
import bagsharu.consulta.Info;
import java.util.Scanner;
import java.io.IOException;

public class Principal {
    public static void main(String[] args){

        // Instanciação de objetos utilizados.
        ConsultaCEP consultarCEP = new ConsultaCEP();
        Scanner leitura = new Scanner(System.in);

        // Entrada de informações pelo usuário.
        System.out.println("Informe o CEP a ser recebido: ");
        System.out.println("Atente-se à formação, o CEP NÃO pode conter mais que oito digitos ou caracteres além de números!");

        var buscaCEP = leitura.nextLine();

        // Bloco try-catch para lidar com possíveis erros de entrada
        try {

            // Instancia objeto "endereco" e consulta o CEP informado posteriormente
            Info endereco = consultarCEP.Consultar(buscaCEP);
            System.out.println("As informações foram registradas em " + endereco.cep() + ".json !");

            // Instacia objeto "gerarArquivo" para manipulação e registro de dados em um arquivo.
            GeradorArquivo gerarArquivo = new GeradorArquivo();
            gerarArquivo.escritaArquivo(endereco);

        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Encerrando a aplicação.");
        }


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

    }
}
