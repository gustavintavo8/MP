
/**
 * Prácticas de Metodología de la Programación. Jeroquest - Un ejemplo de
 * Programación orientada a objetos. Clase Tablero - clase que representa el
 * tablero del juego
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class Tablero {
	private Casilla[][] casillas; // matriz de casillas
	private int filas = 0; // número de filas
	private int columnas = 0; // número de columnas

	/**
	 * Crea un tablero con de acuerdo con unas dimensiones especificadas
	 * (constructor)
	 * 
	 * @param filas    el número de filas del tablero
	 * @param columnas el número de columnas del tablero
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
	 * Obtén el número de filas del tablero (observador)
	 * 
	 * @return el número de filas
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * Obtén el número de columnas del tablero (observador)
	 * 
	 * @return el número de columnas
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Obtén la casilla de una posición del tablero (observador)
	 * 
	 * @param pos posicion del tablero
	 * @return la casilla de dicha posición
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
		// si el personaje está en el tablero
		if (p.getPosicion() != null) {
			// se saca de él
			getCasilla(p.getPosicion()).setFicha(null);
			p.setPosicion(null);
		}
	}

	/**
	 * Situa una ficha en una casilla adyacente a la actual (Método sobrecargado)
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
	 * Comprueba si la casilla es válida
	 * 
	 * @param pos posición a verificar
	 * @return cierto si la casilla es válida
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
	 * Comprueba si la casilla es válida y está vacía
	 * 
	 * @param pos posición a verificar
	 * @return cierto si la casilla está vacía
	 */
	public boolean casillaLibre(XYLocation pos) {
		return casillaValida(pos) && getCasilla(pos).vacia();
	}

	/**
	 * Situa una ficha en una casilla vacía (Método sobrecargado)
	 * 
	 * @param f   la ficha a colocar
	 * @param pos la posición de la casilla
	 * @return cierto si se pudo colocar, falso si la casilla ya estaba ocupada o no
	 *         era válida
	 */
	public boolean mueveFicha(Ficha f, XYLocation pos) {
		if (casillaLibre(pos)) {
			// quitamos la ficha de la casilla actual
			quitaFicha(f);
			// se fija la ficha a la nueva casilla
			f.setPosicion(pos);
			getCasilla(pos).setFicha(f);

			return true; // se movió a la casilla
		} else
			return false; // no se pudo mover
	}

	/**
	 * Genera la versión String imprimible del objeto (Método reescrito)
	 * 
	 * @return La versión como String imprimible del tablero
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
