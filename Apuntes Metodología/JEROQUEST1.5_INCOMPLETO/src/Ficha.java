
/**
 * Pr�cticas de Metodolog�a de la Programaci�n. Jeroquest - Un ejemplo de
 * Programaci�n orientada a objetos. Interface Ficha - interfaz que modela el
 * comportamiento de una ficha en el tablero
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public interface Ficha {

	/**
	 * Obt�n la posici�n en el tablero
	 * 
	 * @return laposici�n en el tablero del personaje
	 */
	XYLocation getPosicion();

	/**
	 * Fija la posici�n del personaje en el tablero
	 * 
	 * @param pos nueva posici�n del personaje en el tablero
	 */
	void setPosicion(XYLocation pos);

	/**
	 * Devuelve un caracter que representa a la ficha
	 * 
	 * @return la version char de la ficha actual
	 */
	char toChar();

}
