package gierka;
import java.util.Scanner;
import java.util.NoSuchElementException;

class Main {

	public static void main(String[] args) {
		Turniej turniej = new Turniej();
		Scanner scanner = new Scanner(System.in);
		turniej.dodajZawodnikow();
		//turniej.ileZlota();
		//turniej.listaZawodnikow.get(0).ulepszSile();
		//turniej.listaZawodnikow.get(0).uleczSie();
		
	   // turniej.listaZawodnikow.get(1).pracuj();
	    //turniej.listaZawodnikow.get(1).pracuj();
	    
	    turniej.rozgrywka();
	    
	    /*
		System.out.println("Zloto gracza "+turniej.listaZawodnikow.get(0).name+": "+turniej.listaZawodnikow.get(0).gold);
		System.out.println("Sila gracza: "+turniej.listaZawodnikow.get(0).sila);
		System.out.println("HP gracza: "+turniej.listaZawodnikow.get(0).hp);
		
		turniej.listaZawodnikow.get(1).ulepszSile();
		System.out.println("Zloto gracza "+turniej.listaZawodnikow.get(1).name+": "+turniej.listaZawodnikow.get(0).gold);
		System.out.println("Sila gracza: "+turniej.listaZawodnikow.get(1).sila);
		
		
	    try {
	        turniej.listaZawodnikow.get(1).kupBron(scanner);
	    } catch (NoSuchElementException e) {
	        System.out.println("Błąd odczytu numeru broni.");
	    }
	    
	    
	    try {
	        turniej.listaZawodnikow.get(1).kupBron(scanner);
	    } catch (NoSuchElementException e) {
	        System.out.println("Błąd odczytu numeru broni.");
	    }
	    scanner.close();
	    

		System.out.println("Bron gracza: "+turniej.listaZawodnikow.get(1).bron.getName());
		System.out.println("Zloto gracza "+turniej.listaZawodnikow.get(1).name+": "+turniej.listaZawodnikow.get(1).gold);
		
		System.out.println("Sila gracza: "+turniej.listaZawodnikow.get(1).sila);
		System.out.println("Zrecznosc gracza: "+turniej.listaZawodnikow.get(1).zrecznosc);
		System.out.println("Inteligencja gracza: "+turniej.listaZawodnikow.get(1).inteligencja);
		System.out.println("Obrazenia broni: "+turniej.listaZawodnikow.get(1).bron.getObrazenia());
		System.out.println("Obrazenia gracza: "+turniej.listaZawodnikow.get(1).atak);
		
		turniej.listaZawodnikow.get(1).ulepszInteligencje();
		turniej.listaZawodnikow.get(1).ulepszInteligencje();
		
		System.out.println("Imie gracza: "+turniej.listaZawodnikow.get(1).name);
		System.out.println("Sila gracza: "+turniej.listaZawodnikow.get(1).sila);
		System.out.println("Zrecznosc gracza: "+turniej.listaZawodnikow.get(1).zrecznosc);
		System.out.println("Inteligencja gracza: "+turniej.listaZawodnikow.get(1).inteligencja);
		System.out.println("Obrazenia broni: "+turniej.listaZawodnikow.get(1).bron.getObrazenia());
		System.out.println("Obrazenia gracza: "+turniej.listaZawodnikow.get(1).atak);
		
		System.out.println("--------------------");
		
		System.out.println("Imie gracza: "+turniej.listaZawodnikow.get(0).name);
		System.out.println("Sila gracza: "+turniej.listaZawodnikow.get(0).sila);
		System.out.println("Zrecznosc gracza: "+turniej.listaZawodnikow.get(0).zrecznosc);
		System.out.println("Inteligencja gracza: "+turniej.listaZawodnikow.get(0).inteligencja);
		System.out.println("Obrazenia broni: "+turniej.listaZawodnikow.get(0).bron.getObrazenia());
		System.out.println("Obrazenia gracza: "+turniej.listaZawodnikow.get(0).atak);
		
		turniej.listaZawodnikow.get(0).walka(turniej.listaZawodnikow.get(2));
		
		System.out.println("--------------------");
		System.out.println("Obrazenia gracza: "+turniej.listaZawodnikow.get(0).atak);
		System.out.println("Obrazenia gracza: "+turniej.listaZawodnikow.get(2).atak);
		System.out.println("HP gracza 1: "+turniej.listaZawodnikow.get(0).hp);
		System.out.println("HP gracza 3: "+turniej.listaZawodnikow.get(2).hp);
		*/
		scanner.close();
		
	}

}
