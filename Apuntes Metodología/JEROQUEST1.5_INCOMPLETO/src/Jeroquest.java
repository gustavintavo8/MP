
/**
 * Prácticas de Metodología de la Programación. Clase Jeroquest - Representa al
 * juego de Jeroquest, y permite jugar partidas de este juego. Para ello dispone
 * de un método para crear una nueva partida y jugarla
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

// La clase Jeroquest incluye una Partida y el metodo aJugar
// que implementa la logica del juego

public class Jeroquest {

	private Partida partidaActual; // partida actual
	protected static VentanaJeroquest monitor;

	/**
	 * Simula una partida de Jeroquest
	 */
	public void aJugar() {
		// GUI - Creamos la ventana para la partida actual
		monitor = new VentanaJeroquest(partidaActual);
		// finRatas();
		// Comienza la partida
		System.out.println("INICIO DE LA PARTIDA");

		// CONSOLA - imprime el estado inicial de la partida
		System.out.println(partidaActual);

		// GUI - actualizamos la partida en la ventana
		monitor.muestraPartida();
		// MiTeclado.pulsaIntro();

		// resuelve la partida en rondas sucesivas
		while (noFinalPartida()) {
			// resolvemos la ronda actual
			resuelveRonda();

			// CONSOLA - imprime el estado actual de la partida
			System.out.println(partidaActual);

			// GUI - actualizamos la partida en la ventana
			monitor.muestraPartida();
			// MiTeclado.pulsaIntro();

			// avanzamos ronda
			siguienteRonda();
		}

		// CONSOLA - muestra el final de la partida
		System.out.println("FIN DE LA PARTIDA");
		System.out.println("Ganan: " + masCuerpo());
		finRatas();

		MiTeclado.pulsaIntro();

		// GUI - Cerramos la ventana
		monitor.finaliza();
	}

	/**
	 * crea una nueva partida a partir de sus componentes
	 * 
	 * @param numHeroes    cuantos héroes
	 * @param numMonstruos cuantos monstruos
	 * @param filas        alto del tablero
	 * @param columnas     ancho del tablero
	 */
	public void nuevaPartida(int numHeroes, int numMonstruos, int filas, int columnas, int totalRondas) {
		// Listo para
		// la ronda
		// 1
		partidaActual = new Partida(numHeroes, numMonstruos, filas, columnas, totalRondas);

		// distribuimos los personajes por el tablero al azar
		distribuyePersonajes();
	}

	/**
	 * Avanza una ronda más
	 */
	private void siguienteRonda() {

		partidaActual.setRondaActual(partidaActual.getRondaActual() + 1);
	}

	/**
	 * Comprobamos si se no se alcanzó el final de la partida
	 * 
	 * @return cierto si ya se superó el total de rondas de la partida o no quedan
	 *         personajes vivos en ambos bandos, falso en otro caso
	 */
	private boolean noFinalPartida() {
		return ((partidaActual.getRondaActual() <= partidaActual.getTotalRondas()) && quedanContrincantes());
	}

	/**
	 * Ejecuta una ronda de la partida: cada personaje "vivo" resuelve su turno La
	 * ronda finaliza inmediatamente si en algún momento no quedan personjes con
	 * vida en ambos bandos
	 */
	private void resuelveRonda() {
		System.out.println("    Ronda: " + partidaActual.getRondaActual());
		System.out.println("");

		for (int x = 0; (x < partidaActual.getPersonajes().length()) && quedanContrincantes(); x++) {
			Personaje p = partidaActual.getPersonajes().get(x);
			if (p.estaVivo())
				p.resuelveTurno(partidaActual);
		}

		// aplicamos la degradación por turnos del zombi
		for (int i = 0; i < partidaActual.getPersonajes().length(); i++) {
			Personaje tmp = partidaActual.getPersonajes().get(i);
			if (tmp instanceof Zombi)
				((Zombi) tmp).degradacion();
			if (!tmp.estaVivo()) {
				partidaActual.getTablero().quitaFicha(tmp);
				tmp.setPosicion(null);
			}
		}
		// barajar
		int longitud = partidaActual.getPersonajes().length();
		for (int i = 0; i < longitud; i++) {
			Personaje p = partidaActual.getPersonajes().get(i);
			int posicionAzar = Dado.tira(longitud) - 1;
			Personaje tmp = partidaActual.getPersonajes().get(posicionAzar);
			partidaActual.getPersonajes().set(i, tmp);
			partidaActual.getPersonajes().set(posicionAzar, p);
		}

	}

	/**
	 * Distribuye los personajes por el tablero al azar en posiciones válidas:
	 * (vacías y dentro del tablero)
	 */
	private void distribuyePersonajes() {
		int filas = partidaActual.getTablero().getFilas();
		int columnas = partidaActual.getTablero().getColumnas();

		for (int i = 0; i < partidaActual.getPersonajes().length(); i++) {
			Personaje p = partidaActual.getPersonajes().get(i);
			// busca una posición al azar dentro del tablero
			int fil = Dado.tira(filas) - 1;
			int col = Dado.tira(columnas) - 1;
			// mientras la posicion no sea válida...
			while (!partidaActual.getTablero().mueveFicha(p, new XYLocation(fil, col))) {
				// se busca una nueva posición al azar
				fil = Dado.tira(filas) - 1;
				col = Dado.tira(columnas) - 1;
			}
		}
	}

	/**
	 * Calcula que bando en total tiene más puntos de vida
	 * 
	 * @return el nombre del bando que tiene más puntos de vida
	 */
	private String masCuerpo() { // Devuelve el nombre de la clase con mas puntos de cuerpo en la situacion
									// actual de la partida
		int cHeroes = 0;
		int cMonstruos = 0;

		for (int i = 0; i < partidaActual.getPersonajes().length(); i++) {
			Personaje p = partidaActual.getPersonajes().get(i);
			if (p instanceof Heroe)
				cHeroes += p.getCuerpo();
			else if (p instanceof Monstruo)
				cMonstruos += p.getCuerpo();
			// System.out.println(p.getClass());
		}
		if (cMonstruos > cHeroes)
			return "Monstruos";
		else if (cHeroes > cMonstruos)
			return "Héroes";
		else
			return "Empate";
	}

	private void finRatas() {
		System.out.println("total ratas");
		VectorDinamicoPersonajes vdp = new VectorDinamicoPersonajes();
		int j = 0;
		for (int i = 0; i < partidaActual.getPersonajes().length(); i++) {
			Personaje p = partidaActual.getPersonajes().get(i);
			if (p instanceof RataTraicionera) {
				vdp.add(p);

			}
		}
		Personaje pj = null;
		for (int i = 0; i < vdp.length(); i++) {
			for (int k = (i + 1); k < (vdp.length() - 1); k++) {

				if (vdp.get(i).getCuerpo() > vdp.get(k).getCuerpo())
					pj = vdp.get(i);
					vdp.set(i, vdp.get(k));
					vdp.set(k, pj);
			}

		}
		int tmp1 = 0;
		for (int i = 0; i < vdp.length(); i++) {
			System.out.println(vdp.get(i));
			if (vdp.get(i) != null)
				if (!vdp.get(i).estaVivo())
					tmp1++;

		}

		System.out.println(tmp1);

	}

	/**
	 * Comprueba que haya personajes de ambos bandos con vida
	 * 
	 * @return cierto si al menos hay un personaje vivo de cada bando
	 */

	public boolean quedanContrincantes() { // Devuelve cierto si al menos los dos bandos tienen algun personaje vivo
		boolean heroesVivos = false;
		boolean monstruosVivos = false;
		int x = 0;
		while ((x < partidaActual.getPersonajes().length()) && !(heroesVivos && monstruosVivos)) {
			if (partidaActual.getPersonajes().get(x).estaVivo())
				if (partidaActual.getPersonajes().get(x) instanceof Heroe)
					heroesVivos = true;
				else // es necesario este segundo if porque puede haber personajes "neutrales" (no
						// heredan ni de Monstruo ni de Heroe)
				if (partidaActual.getPersonajes().get(x) instanceof Monstruo)
					monstruosVivos = true;
			x++;
		}

		return heroesVivos && monstruosVivos;
	}

	/**
	 * Devuelve un array con las casillas válidas a las que se puede mover
	 * directamente un personaje desde su posición actual:(N, S, E y O) (se define
	 * como estático ya que responde a las normas del juego en todo momento)
	 * 
	 * @param partidaActual partida que contiene el tablero y los personajes
	 * @param pj            personaje a analizar
	 * @return el vector de posiciones (posiblemente vacío) a las que se puede mover
	 */
	public static VectorDinamicoXYLocation posicionesValidas(Partida partidaActual, Personaje pj) {

		VectorDinamicoXYLocation posiciones = new VectorDinamicoXYLocation();

		XYLocation posicion = pj.getPosicion().sur();
		if (partidaActual.getTablero().casillaLibre(posicion))
			posiciones.add(posicion);

		posicion = pj.getPosicion().oeste();
		if (partidaActual.getTablero().casillaLibre(posicion))
			posiciones.add(posicion);
		posicion = pj.getPosicion().norte();
		if (partidaActual.getTablero().casillaLibre(posicion))
			posiciones.add(posicion);

		posicion = pj.getPosicion().este();
		if (partidaActual.getTablero().casillaLibre(posicion))
			posiciones.add(posicion);

		return posiciones;
	}

	/**
	 * Devuelve un array con los objetivos válidos para el personaje actual (se
	 * define como estático ya que responde a las normas del juego en todo momento)
	 * 
	 * @param partidaActual la partida en juego
	 * @param pj            el personaje que actua
	 * @return los objetivos validos para el personaje en su posición actual
	 */
	public static VectorDinamicoPersonajes objetivosValidos(Partida partidaActual, Personaje pj) {
		// busca objetivos
		VectorDinamicoPersonajes objetivosValidos = new VectorDinamicoPersonajes();

		VectorDinamicoPersonajes pers = partidaActual.getPersonajes();

		for (int i = 0; i < pers.length(); i++) {
			if ((pers.get(i).estaVivo() == true) && (pj.esEnemigo(pers.get(i)))
					&& (estanATiro(pj.getPosicion(), pers.get(i).getPosicion()))) {
				objetivosValidos.add(pers.get(i));
			}
		}
		// Hay que recorrer los personajes de la partida y añadir los objetivos validos,
		// es decir:
		// 1.- Que estén vivos
		// 2.- Que sean enemigos
		// 3.- Que estén a tiro (ver manual del Jeroquest2.0)

		return objetivosValidos;
	}

	/**
	 * Comprueba si las posiciones de dos personajes son adyacentes (se define como
	 * estático ya que responde a las normas del juego en todo momento)
	 * 
	 * @param pos1 posición del primer personaje
	 * @param pos2 posición del segundo personaje
	 * @return cierto si las casilla son adyacentes, falso en otro caso
	 */
	public static boolean estanATiro(XYLocation pos1, XYLocation pos2) {
		// pos2 al Norte o Sur de pos1
		if ((pos1.getX() == pos2.getX() - 1) && (pos1.getY() == pos2.getY()))
			return true;

		// pos2 al Sur de pos1
		if ((pos1.getX() == pos2.getX() + 1) && (pos1.getY() == pos2.getY()))
			return true;

		// pos2 al Este de pos1
		if ((pos1.getY() == pos2.getY() - 1) && (pos1.getX() == pos2.getX()))
			return true;

		// pos2 al Oeste de pos1
		if ((pos1.getY() == pos2.getY() + 1) && (pos1.getX() == pos2.getX()))
			return true;

		return false;
	}

	/**
	 * Comprueba si el personaje está bloqueado, es decir, si no puede moverse a
	 * ninguna posición: N, S, E, O (se define como estático ya que responde a las
	 * normas del juego en todo momento)
	 * 
	 * @param partidaActual la partida en juego
	 * @param p             personaje a comprobar
	 * @return cierto si no puede moverse en ninguna dirección
	 */
	public static boolean bloqueado(Partida partidaActual, Personaje p) {
		Tablero tab = partidaActual.getTablero();
		return !(tab.casillaLibre(p.getPosicion().norte()) || tab.casillaLibre(p.getPosicion().sur())
				|| tab.casillaLibre(p.getPosicion().este()) || tab.casillaLibre(p.getPosicion().oeste()));
	}

	/**
	 * Genera una direccion de movimiento al azar
	 * 
	 * @return una direccion: North, South, East o West
	 */
	public static Direction direccionAlAzar() {
		int dir = Dado.tira(4);
		// System.out.println(dir);
		switch (dir) {
		case 1:
			return Direction.North;
		case 2:
			return Direction.South;
		case 3:
			return Direction.East;
		case 4:
		default:
			return Direction.West;
		}
	}

}
