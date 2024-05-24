package CEPSearch.main;

import CEPSearch.calculations.APIConection;
import CEPSearch.calculations.LocalJson;
import CEPSearch.calculations.SearchNewCEP;
import CEPSearch.calculations.Validation;
import CEPSearch.models.CEP;
import CEPSearch.models.CEPViaCEP;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner write = new Scanner(System.in);
        List<CEP> listCEP = new ArrayList<>();
        int operation = 0;
        System.out.println("Brazilian CEP Search");
        do{

            System.out.println("***** Menu *****");

            System.out.println("1 - Search new CEP");
            System.out.println("2 - List This Section Searchs");
            System.out.println("3 - List Saved Searchs");
            System.out.println("4 - Clear Saved Searchs");
            System.out.println("5 - Save This Section Searchs");
            System.out.println("6 - Close Section");

            operation = write.nextInt();

            switch (operation){
                case 1:
                    SearchNewCEP.SearchNewCEP(listCEP);
                    break;
                case 2:
                    Validation.listSectionCEPs(listCEP);
                    break;
                case 3:
                    LocalJson.listSavedJson(listCEP);
                    break;
                case 4:
                    LocalJson.deleteJson();
                    break;
                case 5:
                    LocalJson.saveToJson(listCEP);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid value");
                    break;
            }
            write.nextLine();

        }while (operation != 6);


    }
}