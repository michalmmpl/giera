package gierka;

public class Zwiadowca extends Postac{
	public Zwiadowca(String name, String gildia, Sklepzbronia sklepzbronia) {
		super(name);
		this.gildia="Wojownik";
		this.atak=(sila*0.1+zrecznosc+inteligencja*0.1)*bron.getObrazenia();
		this.gildia=gildia;
		this.sklepzbronia=sklepzbronia;
	}
	
	@Override
    public void obliczAtak() {
		if (bron.getTyp()=='Z') {
			this.atak = 1.1*((0.1*sila + zrecznosc + 0.1 * inteligencja) * bron.getObrazenia());
		}
		else{
			this.atak = (0.1*sila + zrecznosc + 0.1 * inteligencja) * bron.getObrazenia();
		}
    }
	
	@Override
	public void ulepszZrecznosc() {
		if (this.gold>=20) {
			this.zrecznosc+=2;
			this.gold-=20;
			obliczAtak();
		}
		else {
			System.out.println("Masz za malo zlota!");
		}
	}

}



