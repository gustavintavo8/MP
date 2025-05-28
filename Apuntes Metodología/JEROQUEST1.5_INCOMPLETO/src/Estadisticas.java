
public class Estadisticas {

	private int ataqueheroes;
	private int ataquemonstruos;
	private int danioheroes;
	private int daniomonstruos;
	
	public Estadisticas() {
		this.setAtaqueheroes(0);
		this.setAtaquemonstruos(0);
		this.setDanioheroes(0);
		this.setDaniomonstruos(0);
	}
	public int getAtaqueheroes() {
		return ataqueheroes;
	}
	public void setAtaqueheroes(int ataqueheroes) {
		this.ataqueheroes = ataqueheroes;
	}
	public int getAtaquemonstruos() {
		return ataquemonstruos;
	}
	public void setAtaquemonstruos(int ataquemonstruos) {
		this.ataquemonstruos = ataquemonstruos;
	}
	public int getDanioheroes() {
		return danioheroes;
	}
	public void setDanioheroes(int danioheroes) {
		this.danioheroes = danioheroes;
	}
	public int getDaniomonstruos() {
		return daniomonstruos;
	}
	public void setDaniomonstruos(int daniomonstruos) {
		this.daniomonstruos = daniomonstruos;
	}
}