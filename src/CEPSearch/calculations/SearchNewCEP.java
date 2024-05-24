package CEPSearch.calculations;

import CEPSearch.models.CEP;
import CEPSearch.models.CEPViaCEP;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SearchNewCEP {
    public static void SearchNewCEP(List<CEP> listCEP) throws IOException, InterruptedException {
        Scanner writeCEP = new Scanner(System.in);
        System.out.println("Enter the CEP you want to search:");
        String cep = writeCEP.nextLine();

        String json = APIConection.requestToAPI(cep);

        CEPViaCEP cepJson = APIConection.convertFromJson(json);

        Validation.createNewCEP(cepJson, listCEP);
        System.out.println(cepJson);
    }


}
