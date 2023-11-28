package gierka;

public class Mag extends Postac{
	public Mag(String name, String gildia) {
		super(name);
		this.gildia="Mag";
		this.atak=(sila*0.1+zrecznosc*0.1+inteligencja)*bron.getObrazenia();
		this.gildia=gildia;
		//this.sklepzbronia=sklepzbronia;
	}
	
	@Override
    public void obliczAtak() {
		if (bron.getTyp()=='M') {
			this.atak = 1.1*((0.1*sila + 0.1 * zrecznosc + inteligencja) * bron.getObrazenia());
		}
		else {
		this.atak = (0.1*sila + 0.1 * zrecznosc + inteligencja) * bron.getObrazenia();	
		}    
    }
	
	@Override
	public void ulepszInteligencje() {
		if (this.gold>=20) {
			this.inteligencja+=2;
			this.gold-=20;
			obliczAtak();
		}
		else {
			System.out.println("Masz za malo zlota!");
		}
	}



}
