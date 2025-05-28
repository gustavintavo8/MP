import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Zombi extends Monstruo {

	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 3;
	protected static final int ATAQUE = 4;
	protected static final int DEFENSA = 0;
	protected static final int CUERPO = 3;

	/**
	 * Crea una momia a partir de su nombre
	 * 
	 * @param nombre nombre de la momia
	 */
	public Zombi(String nombre) {
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO);
	}

	/************************************************
	 * Implementación de la interfaz Ficha
	 **********************************************/

	/**
	 * Genera la version texto de la vista del personaje en el tablero
	 * (implementando operación abstracta)
	 * 
	 * @return la version en cadena del objeto orientada a la vista del tablero
	 */
	public char toChar() {
		return 'Z';
	}

	/**
	 * Accion de combate del personaje
	 * 
	 * @param partidaActual partida en la que tiene que actuar el zombi
	 * @return cierto si llega a combatir con un enemigo, falso en otro caso
	 */
	public boolean accionCombatir(Partida partidaActual) {

		VectorDinamicoPersonajes objetivos = Jeroquest.objetivosValidos(partidaActual, this);
		Boolean barbaroEncontrado = false;
		int tam = objetivos.length();
		Personaje tmp = null;

		if (tam > 0) {
			for (int i = 0; i < tam && !barbaroEncontrado; i++) {
				if (objetivos.get(i) instanceof Barbaro) {
					tmp = objetivos.get(i);
					barbaroEncontrado = true; // para el bucle
				}
			}
			if (!barbaroEncontrado) {
				tmp = objetivos.get(0);
				for (int i = 1; i < tam; i++) {
					if (tmp.getCuerpo() < objetivos.get(i).getCuerpo())
						tmp = objetivos.get(i);
				}
			}
			System.out
					.println(this.getNombre() + this.getPosicion() + " ataca a " + tmp.getNombre() + tmp.getPosicion());
			this.combatir(tmp, partidaActual);
			return true;
		}
		return false;
	}

	public void degradacion() {
		this.setCuerpo(this.getCuerpo() - 1);
	}

	@Override
	public int defender(int impactos) {
		return 0;
	}

	/************************************************
	 * Implementación de la interfaz PersonajeGrafico
	 **********************************************/

	// Icono de un zombi
	protected static Icon icono = new ImageIcon(ClassLoader.getSystemResource("zombi (1).gif"));

	public Icon getImagen() {
		return icono;
	}

}
