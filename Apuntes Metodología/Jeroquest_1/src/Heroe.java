
public abstract class Heroe extends Personaje {

	private Arma arma; 

	public Heroe(String nombre, int mueve, int ataque, int defensa, int cuerpo, Arma arma) {
		super(nombre, mueve, ataque, defensa, cuerpo);
		this.setArma(arma);
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		// fijamos el arma actual
		this.arma = arma;
		// fijamos su ataque actual
		if (arma != null) {
			this.ataque = arma.getAtaque();
		} else
			// si es null, indica que atacará con su ataque inicial
			this.ataque = this.getAtaque();
	}

	public int defender(int impactos) {
		int heridas = 0;

		// se tratan de bloquear los impactos con la defensa
		for (int totalDadosDefensa = defensa; (impactos > 0) && (totalDadosDefensa > 0); totalDadosDefensa--)
			if (Dado.tira() > 4) // se necesita un 5 o 6 para detener un impacto
				impactos--;

		// si hay algun impacto se resta de la vida
		if (impactos > 0) {
			// la vida de un personaje no puede ser menor que cero
			heridas = Math.min(cuerpo, impactos);
			cuerpo -= heridas;
			System.out.printf(this.getNombre() + " no puede bloquear %d impactos%s", impactos,
					(estaVivo() ? "\n" : " y se muere\n"));
		} else {
			System.out.printf("El héroe %s bloquea totalmente el ataque\n", this.getNombre());
		}

		return heridas;
	}

	@Override
	public String toString() {
		String s = super.toString();
		if (arma != null)
			s += " Equipado con " + arma.toString();

		return s;
	}
}