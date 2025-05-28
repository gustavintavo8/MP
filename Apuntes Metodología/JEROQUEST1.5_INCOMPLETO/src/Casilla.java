
/**
 * Pr�cticas de Metodolog�a de la Programaci�n. Jeroquest - Un ejemplo de
 * Programaci�n orientada a objetos. Clase Casilla - clase que representa a cada
 * una de las celdas del tablero
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class Casilla {
	private Ficha ficha; // personaje que est� en la casilla

	/**
	 * Construye una casilla vac�a (sin personaje)
	 */
	public Casilla() {
		ficha = null;
	}

	/**
	 * Obt�n la ficha de la casilla
	 * 
	 * @return la ficha de la casilla, o null si no hay
	 */
	public Ficha getFicha() {
		return ficha;
	}

	/**
	 * Fija un personaje en la casilla
	 * 
	 * @param ficha la ficha que se coloca en esa casilla
	 */
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	/**
	 * Comprueba que si la casilla no tiene personaje
	 * 
	 * @return cierto si no tiene personaje
	 */
	public boolean vacia() {
		return ficha == null;
	}

	/**
	 * Genera la versi�n String imprimible del objeto (M�todo reescrito)
	 * 
	 * @return La versi�n como String imprimible de la casilla
	 */
	@Override
	public String toString() {
		if (ficha == null)
			return "-";
		else
			return String.format("%c", ficha.toChar());
	}
}
