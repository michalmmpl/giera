package gierka;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Turniej {
	public List<Postac> listaZawodnikow;
	public Sklepzbronia sklepzbronia;
	
	public Turniej() {
	    //sklepzbronia = new Sklepzbronia(); // Inicjalizacja sklepu
	}
	
	public void dodajZawodnikow() {
		listaZawodnikow = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<4;i++) {

	        System.out.println("Jak masz na imie?");
	        String firstName = scan.nextLine();
	        String guildInput;
	        Gildie wybranaGildia = null;
	        
	        do {
	            System.out.println("Jaka gildia?");
	            guildInput = scan.nextLine();
	            try {
	                wybranaGildia = Gildie.valueOf(guildInput.toUpperCase());
	            } catch (IllegalArgumentException e) {
	                System.out.println("Podana gildia nie istnieje. Dostepne gildie to: Wojownik, Mag, Zwiadowca.");
	            }
	        } while (wybranaGildia == null);

	        Postac nowaPostac=null;

	        if (wybranaGildia == Gildie.WOJOWNIK) {
	            nowaPostac = new Wojownik(firstName, wybranaGildia.toString());
	        } else if (wybranaGildia == Gildie.MAG) {
	            nowaPostac = new Mag(firstName, wybranaGildia.toString());
	        } else if (wybranaGildia == Gildie.ZWIADOWCA) {
	            nowaPostac = new Zwiadowca(firstName, wybranaGildia.toString());

	        }
		
	        
	        listaZawodnikow.add(nowaPostac);
	        //scan.nextLine();

	
	    }
 
		
	}
	public void rozgrywka() {
		//Lambda, do zliczania ilości obiektów których wartość pola wynosi wskazaną wartość
		long h=listaZawodnikow.stream()
				.filter(postac -> "Active".equals(postac.status))
				.count();
		
		while(h>1) {		
			for (int i=0; i<listaZawodnikow.size();i++) {
				if (listaZawodnikow.get(i).status.equals("Active")) {
					System.out.println("Nr gracza: "+(i+1));
					listaZawodnikow.get(i).parametry();
					Akcja.RobAkcje(listaZawodnikow.get(i), listaZawodnikow);
					System.out.println("Nr gracza: "+(i+1));
					listaZawodnikow.get(i).parametry();
				}
				h=listaZawodnikow.stream()
					.filter(postac -> "Active".equals(postac.status))
					.count();
				if (h<=1) {
					break;
				}
				
			}
			//h++;
		}
		String namewinner="";
		for (int i=0; i<listaZawodnikow.size();i++) {
			if((listaZawodnikow.get(i).status.equals("Active"))) {
				namewinner = listaZawodnikow.get(i).name;
				break;
			}
		}
		System.out.println("KONIEC ROZGRYWKI. ZWYCIEZYŁ " + namewinner);
		System.out.println("CHWALA CI " + namewinner);
		
	
	}
	public void ileZlota() {
		for(Postac postac: listaZawodnikow) {
			System.out.println("Ilosc zlota "+postac.name+" : "+postac.gold);
		}
	}
}
