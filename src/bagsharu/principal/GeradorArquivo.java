package bagsharu.principal;

import bagsharu.consulta.Info;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

    public void escritaArquivo (Info endereco) throws IOException {
        Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();

        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();

    }
}
