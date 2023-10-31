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
	public Sklepzbronia sklepzbronia;	
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
	    if (index >= 0 && index < sklepzbronia.arsenal.size()) {
	        if (this.gold>sklepzbronia.arsenal.get(index).getCena()) {
	        	this.bron = sklepzbronia.arsenal.get(index);
		        System.out.println("Zakupiono bron: " + bron.getName());
		        this.gold-=sklepzbronia.arsenal.get(index).getCena();
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
	    sklepzbronia.wyswietlOferte();
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
	    	System.out.println("Wygrywasz walke!");
	    	przeciwnik.hp-=(this.atak-przeciwnik.atak);
	    	System.out.println("Przeciwnik otrzymal "+(this.atak-przeciwnik.atak)+" obrazen.");
	    	double goldy=przeciwnik.gold*0.3;
	    	przeciwnik.gold-=goldy;
	    	this.gold+=goldy;
	    	if (przeciwnik.hp<=0) {
	    		System.out.println("Gracz "+przeciwnik.name+" zostal wyeliminowany!");
	    		
	    	}
	    }
	    else if (this.atak<przeciwnik.atak) {
		    System.out.println("Przegrywasz walke!");
		    this.hp-=(przeciwnik.atak-this.atak);
		    double goldy=przeciwnik.gold*0.3;
		    przeciwnik.gold+=goldy;
		    this.gold-=goldy;
		    if (this.hp<=0) {
		    	System.out.println(this.name+" , zostaleś wyeliminowany!");
		    		
		    }
	    }
		else if (this.atak==przeciwnik.atak){
		    	System.out.println("Walka nieroztrzygnieta!");
		
	    }
	}	
}
