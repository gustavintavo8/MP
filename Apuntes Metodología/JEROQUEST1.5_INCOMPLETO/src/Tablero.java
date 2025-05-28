
/**
 * Pr�cticas de Metodolog�a de la Programaci�n. Jeroquest - Un ejemplo de
 * Programaci�n orientada a objetos. Clase Tablero - clase que representa el
 * tablero del juego
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class Tablero {
	private Casilla[][] casillas; // matriz de casillas
	private int filas = 0; // n�mero de filas
	private int columnas = 0; // n�mero de columnas

	/**
	 * Crea un tablero con de acuerdo con unas dimensiones especificadas
	 * (constructor)
	 * 
	 * @param filas    el n�mero de filas del tablero
	 * @param columnas el n�mero de columnas del tablero
	 */
	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		casillas = new Casilla[filas][columnas];
		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				casillas[i][j] = new Casilla();
	}

	/**
	 * Obt�n el n�mero de filas del tablero (observador)
	 * 
	 * @return el n�mero de filas
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * Obt�n el n�mero de columnas del tablero (observador)
	 * 
	 * @return el n�mero de columnas
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Obt�n la casilla de una posici�n del tablero (observador)
	 * 
	 * @param pos posicion del tablero
	 * @return la casilla de dicha posici�n
	 */
	private Casilla getCasilla(XYLocation pos) {
		return casillas[pos.getX()][pos.getY()];
	}

	/**
	 * Saca a un aficha del tablero (modificador)
	 * 
	 * @param p ficha a sacar del tablero
	 */
	public void quitaFicha(Ficha p) {
		// si el personaje est� en el tablero
		if (p.getPosicion() != null) {
			// se saca de �l
			getCasilla(p.getPosicion()).setFicha(null);
			p.setPosicion(null);
		}
	}

	/**
	 * Situa una ficha en una casilla adyacente a la actual (M�todo sobrecargado)
	 * 
	 * @param f   la ficha a colocar
	 * @param dir direccion del momiviento: North, South, East o West
	 * @return cierto si se pudo colocar, falso si no estaba en el tablero, si la
	 *         casilla ya estaba ocupada o si se sale del tablero
	 */
	public boolean mueveFicha(Ficha f, Direction dir) {
		XYLocation pos1 = f.getPosicion();
		if (pos1 == null) // si no estaba en el tablero no se puede mover
			return false;

		XYLocation pos2 = null;
		// calculamos la casilla en esa direccion
		switch (dir) {
		case North:
			pos2 = pos1.norte();
			break;
		case South:
			pos2 = pos1.sur();
			break;
		case East:
			pos2 = pos1.este();
			break;
		case West:
			pos2 = pos1.oeste();
			break;
		}
		// movemos el personaje comprobando si la casilla en esa direccion es valida
		return mueveFicha(f, pos2); // se trata de mover a dicha casilla
	}

	/**
	 * Comprueba si la casilla es v�lida
	 * 
	 * @param pos posici�n a verificar
	 * @return cierto si la casilla es v�lida
	 */
	private boolean casillaValida(XYLocation pos) {
		// si la casilla no es valida
		if ((pos.getX() < 0) || (pos.getX() >= filas))
			return false;
		if ((pos.getY() < 0) || (pos.getY() >= columnas))
			return false;
		// en otro caso es valida
		return true;
	}

	/**
	 * Comprueba si la casilla es v�lida y est� vac�a
	 * 
	 * @param pos posici�n a verificar
	 * @return cierto si la casilla est� vac�a
	 */
	public boolean casillaLibre(XYLocation pos) {
		return casillaValida(pos) && getCasilla(pos).vacia();
	}

	/**
	 * Situa una ficha en una casilla vac�a (M�todo sobrecargado)
	 * 
	 * @param f   la ficha a colocar
	 * @param pos la posici�n de la casilla
	 * @return cierto si se pudo colocar, falso si la casilla ya estaba ocupada o no
	 *         era v�lida
	 */
	public boolean mueveFicha(Ficha f, XYLocation pos) {
		if (casillaLibre(pos)) {
			// quitamos la ficha de la casilla actual
			quitaFicha(f);
			// se fija la ficha a la nueva casilla
			f.setPosicion(pos);
			getCasilla(pos).setFicha(f);

			return true; // se movi� a la casilla
		} else
			return false; // no se pudo mover
	}

	/**
	 * Genera la versi�n String imprimible del objeto (M�todo reescrito)
	 * 
	 * @return La versi�n como String imprimible del tablero
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++)
				s += casillas[i][j];
			s += "\n";
			;
		}
		return s;
	}

}
