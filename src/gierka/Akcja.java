package gierka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Akcja {


    public static void RobAkcje(Postac postac, List<Postac> listaZawodnikow) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz akcje dla gracza " + postac.name + ":");
        System.out.println("1. Pracuj");
        System.out.println("2. Ulepsz sile");
        System.out.println("3. Ulepsz zrecznosc");
        System.out.println("4. Ulepsz inteligencje");
        System.out.println("5. Ulecz sie");
        System.out.println("6. Zakup nowa bron");
        System.out.println("7. Rozpocznij walke");
        System.out.println("0. Pas");

        int wybor = scanner.nextInt();

        switch (wybor) {
            case 1:
                postac.pracuj();
                break;
            case 2:
                postac.ulepszSile();
                break;
            case 3:
                postac.ulepszZrecznosc();
                break;
            case 4:
                postac.ulepszInteligencje();
                break;
            case 5:
                postac.uleczSie();
                break;
            case 6:
                postac.kupBron(scanner);
                break;
            case 7:
                System.out.println("Wybierz przeciwnika:");
                for (int i = 0; i < listaZawodnikow.size(); i++) {
                    if (listaZawodnikow.get(i) != postac && listaZawodnikow.get(i).status.equals("Active")) {
                        System.out.println((i + 1) + ". " + listaZawodnikow.get(i).name);
                    }
                }
                int wyborPrzeciwnika = scanner.nextInt();
                if (wyborPrzeciwnika > 0 && wyborPrzeciwnika <= listaZawodnikow.size()) {
                    Postac przeciwnik = listaZawodnikow.get(wyborPrzeciwnika - 1);
                    postac.walka(przeciwnik); // Wywołanie metody walka() z klasy Postac
                    if (przeciwnik.hp<=0) {
                        System.out.println("Gracz " + przeciwnik.name + " zostal wyeliminowany!");
                        listaZawodnikow.get(wyborPrzeciwnika-1).status="Defeated";
                    }
                    if (postac.hp<=0) {
                        System.out.println(postac.name + ", zostales wyeliminowany!");
                        postac.status="Defeated";
                    }
                } else {
                    System.out.println("Nieprawidłowy numer przeciwnika.");
                }
                break;          
            case 0:
                System.out.println("Gracz " + postac.name+ " pasuje.");
                break;
            default:
                System.out.println("Nieprawidlowy wybór.");
                break;
        }

    }
}