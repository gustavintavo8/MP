
public class Barbaro extends Heroe {

	protected static final int MOVIMIENTO = 7;
	protected static final int ATAQUE = 1;
	protected static final int DEFENSA = 2;
	protected static final int CUERPO = 8;

	public Barbaro(String nombre) {
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO, new Arma("Espada Ancha", 3));
	}

	public int defender(int impactos) {

		for (int totalDadosDefensa = defensa; (impactos > 0) && (totalDadosDefensa > 0); totalDadosDefensa--)
			if (Dado.tira() > 4)
				impactos--;

		if (impactos > 0) {

			cuerpo = Math.max(0, cuerpo - impactos);
			System.out.printf("El bárbaro " + this.getNombre() + " no puede bloquear %d impactos%s", impactos,
					(estaVivo() ? "\n" : " y se muere\n"));
		} else {
			System.out.printf("El bárbaro" + this.getNombre() + " bloquea totalmente el ataque\n");
		}

		return impactos;
	}

	
	/**
	 * Genera la versión String imprimible del objeto (Método reescrito)
	 * 
	 * @return La versión como String imprimible del barbaro
	 */
	public String toString() {
		return String.format("El bárbaro: %s", super.toString());
	}

}
