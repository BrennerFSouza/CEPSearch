package CEPSearch.calculations;

import CEPSearch.models.CEP;
import CEPSearch.models.CEPViaCEP;

import java.util.List;

public class Validation {


    public static void createNewCEP(CEPViaCEP cepJson, List<CEP> listCEP){
        try{
            CEP newCEP = new CEP(cepJson);
            listCEP.add(newCEP);

            System.out.println(newCEP);


        }catch (Exception e){
            System.out.println("Unexpected Error");
            e.getMessage();
        }
    }
    public static void listSectionCEPs(List<CEP> listCEP){

        if (listCEP.isEmpty()){
            System.out.println("You need to make searchs before");

        }else {
            for (CEP item : listCEP){
                System.out.println(item);
            }
        }

    }
}
