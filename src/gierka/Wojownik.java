package gierka;

public class Wojownik extends Postac {

	public Wojownik(String name, String gildia) {
		super(name);
		this.gildia="Wojownik";
		this.atak=(sila+zrecznosc*0.1+inteligencja*0.1)*bron.getObrazenia();
		this.gildia=gildia;

	}
	@Override
    public void obliczAtak() {
		if (bron.getTyp()=='W') {
			this.atak = (1.1*(sila * 0.1 + zrecznosc * 0.1 + inteligencja) * bron.getObrazenia());
		}
		else {
			this.atak= (sila* 0.1 + zrecznosc * 0.1 + inteligencja) * bron.getObrazenia();
		}
    }
	
	
	@Override
	public void ulepszSile() {
		if (this.gold>=20) {
			this.sila+=2;
			this.gold-=20;
			obliczAtak();
		}
		else {
			System.out.println("Masz za malo zlota!");
		}
	}
}
