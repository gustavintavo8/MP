public class Enano extends Heroe {
	 
	protected static final int MOVIMIENTO = 6;
	protected static final int ATAQUE = 1;
	protected static final int DEFENSA = 2;
	protected static final int CUERPO = 7;


	public Enano(String nombre) {
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO, new Arma("Hacha de mano", 2));
	
	}
	public int defender(int impactos) {

		for (int totalDadosDefensa = defensa; (impactos > 0) && (totalDadosDefensa > 0); totalDadosDefensa--)
			if (Dado.tira() > 4)
				impactos--;

		if (impactos > 0) {

			cuerpo = Math.max(0, cuerpo - impactos);
			System.out.printf("El enano " + this.getNombre() + " no puede bloquear %d impactos%s", impactos,
					(estaVivo() ? "\n" : " y se muere\n"));
		} else {
			System.out.printf("El enano" + this.getNombre() + " bloquea totalmente el ataque\n");
		}

		return impactos;
	}

	
	public String toString() {
		return String.format("El enano: %s", super.toString());
	}
}
