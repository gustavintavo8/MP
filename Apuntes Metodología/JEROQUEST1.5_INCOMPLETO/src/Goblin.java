
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Goblin extends Monstruo {

	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 10;
	protected static final int ATAQUE = 2;
	protected static final int DEFENSA = 1;
	protected static final int CUERPO = 1;

	/**
	 * Crea una goblin a partir de su nombre
	 * 
	 * @param nombre nombre de El goblin
	 */
	public Goblin(String nombre) {
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
		return 'G';
	}

	/************************************************
	 * Implementaci�n de la interfaz PersonajeGrafico
	 **********************************************/

	// Icono de un enano
	protected static Icon icono = new ImageIcon(ClassLoader.getSystemResource("goblin.png"));

	public Icon getImagen() {
		return icono;
	}

}
