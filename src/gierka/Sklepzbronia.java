package gierka;

import java.util.ArrayList;
import java.util.List;

public class Sklepzbronia {
	public Bron bron;
	public Postac postac;
	public List<Bron> arsenal;
	
	public void sklep() {
		arsenal = new ArrayList<>();
		arsenal.add(new Bron("Sztylet", 3, 25,'W'));
		arsenal.add(new Bron("Maly miecz", 10, 150,'W'));
		arsenal.add(new Bron("Miecz", 25, 700,'W'));
		arsenal.add(new Bron("Duzy miecz", 50, 1200,'W'));
		arsenal.add(new Bron("Ogromny miecz", 80, 2000,'W'));
		arsenal.add(new Bron("Excalibur", 115, 3600,'W'));
		
		arsenal.add(new Bron("Proca", 3, 25, 'Z'));
		arsenal.add(new Bron("Krotki luk", 10, 175,'Z'));
		arsenal.add(new Bron("Luk", 25, 700,'Z'));
		arsenal.add(new Bron("Dlugi luk", 60, 1200,'Z'));
		
		arsenal.add(new Bron("Rozdzka", 3, 25,'M'));
		arsenal.add(new Bron("Maly kostur", 10, 175,'M'));
		arsenal.add(new Bron("Kostur", 25, 700,'M'));
		arsenal.add(new Bron("Dlugi kostur", 60, 1200, 'M'));
	}
	
	public void wyswietlOferte() {
		sklep();
		int i =1;
		System.out.println("Oto lista dostepnych broni w arsenale!");
		for(Bron bronie: arsenal) {
			System.out.println("Numer: "+i+", Nazwa: "+bronie.getName()+", Obrazenia: "+bronie.getObrazenia()+", Cena: "+bronie.getCena());
			i++;
		}
		System.out.println("Podaj nr broni, ktora chcesz kupic!");
	}

}
