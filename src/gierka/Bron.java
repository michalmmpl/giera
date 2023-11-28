package gierka;

public class Bron {
	private String name;
	private int obrazenia;
	private int cena;
	private char typ;
	public Bron(String name, int obrazenia, int cena, char typ) {
		this.name = name;
		this.obrazenia = obrazenia;
		this.cena=cena;
		this.typ=typ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getObrazenia() {
		return obrazenia;
	}
	public void setObrazenia(int obrazenia) {
		this.obrazenia = obrazenia;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public char getTyp() {
		return typ;
	}
	public void setTyp(char typ) {
		this.typ = typ;
	}
}
