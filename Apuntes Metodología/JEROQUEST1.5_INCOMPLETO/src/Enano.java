
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Enano extends Heroe {
	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 6;
	protected static final int ATAQUE = 1;
	protected static final int DEFENSA = 2;
	protected static final int CUERPO = 7;

	/**
	 * Crea un enano a partir de su nombre y el de su jugador
	 * 
	 * @param nombre  nombre del b�rbaro
	 * @param jugador el nombre del jugador que lo controla
	 */
	public Enano(String nombre, String jugador) {
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO, jugador, new Arma("Hacha de mano", 2));

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
		return 'E';
	}

	/************************************************
	 * Implementaci�n de la interfaz PersonajeGrafico
	 **********************************************/

	// Icono de un enano
	protected static Icon icono = new ImageIcon(ClassLoader.getSystemResource("enano.gif"));

	public Icon getImagen() {
		return icono;
	}

}
