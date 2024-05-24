package CEPSearch.calculations;

import CEPSearch.models.CEP;
import CEPSearch.models.CEPViaCEP;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class APIConection {
    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    public static String requestToAPI(String cep) throws IOException, InterruptedException {

        cep = cep.replace(" ", "+");
        String link = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public static CEPViaCEP convertFromJson(String json){
        return  gson.fromJson(json, CEPViaCEP.class);
    }

}
