import javax.swing.Icon;
import javax.swing.ImageIcon;

public class RataTraicionera extends Monstruo {

	protected static final int MOVIMIENTO = 5;
	protected static final int ATAQUE = 4;
	protected static final int DEFENSA = 2;
	protected static final int CUERPO = 2;
	private boolean asustada = false;

	/**
	 * @return the asustada
	 */
	public boolean isAsustada() {
		return asustada;
	}

	/**
	 * @param asustada the asustada to set
	 */
	public void setAsustada(boolean asustada) {
		this.asustada = asustada;
	}

	/**
	 * Crea una RataTraicionera a partir de su nombre
	 * 
	 * @param nombre nombre de la RataTraicionera
	 */
	public RataTraicionera(String nombre) {
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO);
	}
	/**
	 * Genera la version texto de la vista del personaje en el tablero
	 * (implementando operaci�n abstracta)
	 * 
	 * @return la version en cadena del objeto orientada a la vista del tablero
	 */
	public char toChar() {
		return 'R';
	}

	public void resuelveTurno(Partida partidaActual) {

		if (this.isAsustada()) {
			System.out.println("La rata esta asustada y no hace nada");
		} else {

			super.resuelveTurno(partidaActual);
		}
	}

	public void regenera() {
		if (!this.isAsustada() && this.getCuerpo() < 3)
			this.setCuerpo(this.getCuerpo() + 1);
		if (this.isAsustada())
			this.setAsustada(false);

	}

	public void defender(int impactos) {
		int cuerpoActual = this.cuerpo; // guardamos el cuerpo antes del ataque
		super.defender(impactos); // resolvemos la defensa con el metodo del padre

		if (this.cuerpo < cuerpoActual)
			if (this.asustada && (this.cuerpo - cuerpoActual) >= (this.cuerpoInicial / 2)) {
				this.cuerpo = 0; // se muere de miedo
				System.out.println(this.getNombre() + " se muere de miedo");
			} else
				this.asustada = true; // se asusta del golpe
		else // el ataque no le hizo danio
			this.asustada = false;
	}

	public boolean esEnemigo(Personaje p) {
		if (p instanceof RataTraicionera)
			return (p.getCuerpo() < this.getCuerpo());
		else
			return super.esEnemigo(p);
	}

	/************************************************
	 * Implementaci�n de la interfaz PersonajeGrafico
	 **********************************************/

	// Icono de un enano
	protected static Icon icono1 = new ImageIcon(ClassLoader.getSystemResource("rata.png"));
	protected static Icon icono2 = new ImageIcon(ClassLoader.getSystemResource("rata_asustada.png"));

	public Icon getImagen() {
		if (this.isAsustada())
			return icono2;
		else
			return icono1;
	}
}
