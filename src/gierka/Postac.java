package gierka;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

abstract class Postac {
	public String name;
	public String gildia;
	public double hp;
	public double gold;
	public double sila;
	public double zrecznosc;
	public double inteligencja;
	public Bron bron;
	//public Sklepzbronia sklepzbronia;	
	public double atak;
	public String status;
	
	public Postac(String name) {
		this.name=name;
		this.bron=new Bron("Piesc",1, 1, 'N');
		this.gold=100;
		this.hp=100;
		this.sila=10;
		this.zrecznosc=10;
		this.inteligencja=10;
		this.atak=1;
		this.status="Active";
		
	}
	
	public void obliczAtak(){
		
	}
    public static class sklep {
        public static List<Bron> arsenal;

        static {
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

        public static void wyswietlOferte() {
            int i = 1;
            System.out.println("Oto lista dostepnych broni w arsenale!");
            for(Bron bronie: arsenal) {
                System.out.println("Numer: "+i+", Nazwa: "+bronie.getName()+", Obrazenia: "+bronie.getObrazenia()+", Cena: "+bronie.getCena());
                i++;
            }
            System.out.println("Podaj nr broni, ktora chcesz kupic!");
        }
    }
	
	public void parametry() {
		System.out.println("----------------------------");
		System.out.println("Imie: "+this.name);
		System.out.println("Gildia: "+this.gildia);
		System.out.println("Sila gracza: "+this.sila);
		System.out.println("Zrecznosc gracza: "+this.zrecznosc);
		System.out.println("Inteligencja gracza: "+this.inteligencja);
		System.out.println("Zloto gracza: "+this.gold);
		System.out.println("HP gracza: "+this.hp);
		System.out.println("Nazwa broni: "+this.bron.getName());
		System.out.println("Obrazenia broni: "+this.bron.getObrazenia());
		System.out.println("Obrazenia gracza: "+this.atak);
		System.out.println("----------------------------");
	}
	
	public void ulepszSile() {
		if (this.gold>=20) {
			this.sila+=1;
			this.gold-=20;
			obliczAtak();
		}
		else {
			System.out.println("Masz za malo zlota!");
		}
	}
	public void ulepszZrecznosc() {
		if (this.gold>=20) {
			this.zrecznosc+=1;
			this.gold-=20;
			obliczAtak();
		}
		else {
			System.out.println("Masz za malo zlota!");
		}
	}
	public void ulepszInteligencje() {
		if (this.gold>=20) {
			this.inteligencja+=1;
			this.gold-=20;
			obliczAtak();
		}
		else {
			System.out.println("Masz za malo zlota!");
		}
	}
	
	public void uleczSie() {
		this.hp+=100;
	}
	
	public void pracuj() {
		this.gold+=100;
	}
	
	public void kupujeBron(int index) {
	    if (index >= 0 && index < sklep.arsenal.size()) {
	        if (this.gold>sklep.arsenal.get(index).getCena()) {
	        	this.bron = sklep.arsenal.get(index);
		        System.out.println("Zakupiono bron: " + bron.getName());
		        this.gold-=sklep.arsenal.get(index).getCena();
		        obliczAtak();
	        }
	        else {
	        	System.out.println("Masz za malo zlota!");
	        }
	    } else {
	        System.out.println("Nieprawidłowy numer broni.");
	    }
	}

	public void kupBron(Scanner scanner) {
	    sklep.wyswietlOferte();
	    try {
	        int num = scanner.nextInt();
	        scanner.nextLine(); 
	        kupujeBron(num - 1);
	    } catch (InputMismatchException e) {
	        System.out.println("Nieprawidłowy format danych. Wprowadź liczbę.");
	    } catch (NoSuchElementException e) {
	        System.out.println("Brak dostępnych danych do odczytu.");
	    }
	}
	
	public void walka(Postac przeciwnik) {
	    System.out.println(name + " walczy z " + przeciwnik.name + "!");
	
	    if (this.atak>przeciwnik.atak) {
	    	double goldy;
	    	System.out.println("Wygrywasz walke!");
	    	przeciwnik.hp-=(this.atak-przeciwnik.atak);
	    	System.out.println("Przeciwnik otrzymal "+(this.atak-przeciwnik.atak)+" obrazen.");
	    	if (przeciwnik.gold>100) {
	    		goldy=przeciwnik.gold*0.3;
	    	}
	    	else if (przeciwnik.gold<=100 && przeciwnik.gold>20) {
	    		goldy=przeciwnik.gold*0.5;
	    	}
	    	else if(przeciwnik.gold<=20 && przeciwnik.gold>0) {
	    		goldy=przeciwnik.gold;
	    	}
	    	else {
	    		goldy=0;
	    	}
	    	
	    	przeciwnik.gold-=goldy;
	    	this.gold+=goldy;
	    	if (przeciwnik.hp<=0) {
	    		System.out.println("Gracz "+przeciwnik.name+" zostal wyeliminowany!");
	    		
	    	}
	    }
	    else if (this.atak<przeciwnik.atak) {
		    double golds;
	    	System.out.println("Przegrywasz walke!");
		    this.hp-=(przeciwnik.atak-this.atak);
		    if (this.gold>100) {
		    	golds=this.gold*0.5;
		    }
		    else if (this.gold<=100 && this.gold>0) {
		    	golds=this.gold*0.7;
		    }
		    else {
		    	golds=0;
		    }
		    this.gold-=golds;
		    przeciwnik.gold+=golds;
		    if (this.hp<=0) {
		    	System.out.println(this.name+" , zostales wyeliminowany!");
		    		
		    }
	    }
		else if (this.atak==przeciwnik.atak){
		    	System.out.println("Walka nieroztrzygnieta!");
		
	    }
	}	
}
