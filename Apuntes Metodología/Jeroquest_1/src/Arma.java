
public class Arma {

	private String nombre; 
	private int ataque;
	
	public Arma(String Nombre, int Ataque) {
		nombre = Nombre;
		ataque = Ataque;
	}

	
	public String getNombre() {
		return nombre;
	}


	public int getAtaque() {
		return ataque;
	}

	
	@Override
	public String toString() {
		return nombre + " (" + ataque + " dados)";
	}
}