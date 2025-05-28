
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Barbaro extends Heroe {
	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 7;
	protected static final int ATAQUE = 1;
	protected static final int DEFENSA = 2;
	protected static final int CUERPO = 8;

	/**
	 * Crea un b�rbaro a partir de su nombre y el de su jugador
	 * 
	 * @param nombre  el nombre del b�rbaro
	 * @param jugador el nombre del jugador que lo controla
	 */
	public Barbaro(String nombre, String jugador) {
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO, jugador, new Arma("Espada Ancha", 3));
	}

	/************************************************
	 * Implementaci�n de la interfaz Ficha
	 **********************************************/

	/**
	 * Genera la version texto de la vista del personaje en el tablero
	 * (implementando operaci�n abstracta)
	 * 
	 * @return la version en cadena del objeto orientada a la vista del tablero
	 */
	public char toChar() {
		return 'B';
	}

	/************************************************
	 * Implementaci�n de la interfaz ElementoGrafico
	 **********************************************/

	// Icono de un b�rbaro
	protected static Icon icono = new ImageIcon(ClassLoader.getSystemResource("barbaro.gif"));

	public Icon getImagen() {
		return icono;
	}

}
