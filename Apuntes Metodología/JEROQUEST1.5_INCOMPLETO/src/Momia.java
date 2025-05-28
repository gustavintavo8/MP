
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Momia extends Monstruo {

	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 4;
	protected static final int ATAQUE = 3;
	protected static final int DEFENSA = 4;
	protected static final int CUERPO = 2;

	/**
	 * Crea una momia a partir de su nombre
	 * 
	 * @param nombre nombre de la momia
	 */
	public Momia(String nombre) {
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO);
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
		return 'M';
	}

	/************************************************
	 * Implementaci�n de la interfaz PersonajeGrafico
	 **********************************************/

	// Icono de un enano
	protected static Icon icono = new ImageIcon(ClassLoader.getSystemResource("momia.gif"));

	public Icon getImagen() {
		return icono;
	}

}
