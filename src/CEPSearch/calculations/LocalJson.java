package CEPSearch.calculations;

import CEPSearch.models.CEP;
import CEPSearch.models.CEPViaCEP;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class LocalJson {
    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    public static void saveToJson(List<CEP> listCEP) throws IOException {
        try {
            File file = new File("CEPs.json");
            FileWriter write = new FileWriter("CEPs.json");

            if(file.exists()){
                write.append(gson.toJson(listCEP));
            }else{
                write.write(gson.toJson(listCEP));
            }

            write.close();
            System.out.println("Save with sucess!");
        }catch (Exception e){
            System.out.println("Unexpected Error");
        }

    }

    public static void listSavedJson(List<CEP> listCEP) throws IOException{
        File file = new File("CEPs.json");
        if (file.exists()){
            try (Reader reader = new FileReader(file)) {
                Type tipoListaCEP = new TypeToken<List<CEP>>() {}.getType();
                List<CEP> ceps = gson.fromJson(reader, tipoListaCEP);
                System.out.println(ceps);
            }

        }else{
            Validation.listSectionCEPs(listCEP);
        }
    }
    public static void deleteJson(){
        File file = new File("CEPs.json");
        if (file.exists()){
            file.delete();
        }else{
            System.out.println("Searchs was empty");
        }
    }
}
