package bagsharu.principal;

import bagsharu.consulta.Info;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

    // Método para salvar um arquivo com as informações do CEP


    public void escritaArquivo (Info endereco) throws IOException {

        // Instacia objeto "gson" e formata de forma legível.
        Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();

        // Instacia objeto "escrita" que cria o arquivo nomeado a partir do CEP informado.
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();

    }
}
