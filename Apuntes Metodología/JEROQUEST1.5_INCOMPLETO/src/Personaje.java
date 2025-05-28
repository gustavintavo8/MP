
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Personaje implements Ficha, ElementoGrafico {
	// atributos actuales del personaje
	protected int mueve; // unidades de movimiento por turno
	protected int ataque; // total dados de ataque
	protected int defensa; // total dados de defensa
	protected int cuerpo; // puntos de vida

	// atributos iniciales del personaje
	protected int mueveInicial; // unidades de movimiento por turno
	protected int ataqueInicial; // total dados de ataque
	protected int defensaInicial; // total dados de defensa
	protected int cuerpoInicial; // puntos de vida

	protected String nombre; // nombre del personaje

	/**
	 * Crea un personaje a partir de su nombre y sus atributos iniciales
	 * inicialmente su posición es nula (fuera del tablero)
	 * 
	 * @param nombre  nombre del personaje
	 * @param mueve   casillas que mueve por turno
	 * @param ataque  dados que tira por ataque sin arma
	 * @param defensa dados que tira para defenderse
	 * @param cuerpo  vida inicial
	 */
	public Personaje(String nombre, int mueve, int ataque, int defensa, int cuerpo) {

		this.nombre = nombre;

		// fijamos los atributos iniciales
		this.mueveInicial = mueve;
		this.ataqueInicial = ataque;
		this.defensaInicial = defensa;
		this.cuerpoInicial = cuerpo;

		// fijamos los atributos actuales
		this.mueve = mueve;
		this.ataque = ataque;
		this.defensa = defensa;
		this.cuerpo = cuerpo;

		// posicion nula (fuera del tablero)
		this.posicion = null;
	}

	/**
	 * Obtén las unidades de movimiento por turno (observador)
	 * 
	 * @return unidades de movimiento del personaje
	 */
	public int getMueve() {
		return mueve;
	}
	public void setCuerpo(int cp) {
		this.cuerpo=cp;
	}

	/**
	 * Obtén los dados de ataque
	 * 
	 * @return dados de ataque del personaje
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Obtén los dados de defensa
	 * 
	 * @return dados de defensa del personaje
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Obtén los puntos de vida
	 * 
	 * @return puntos de vida del personaje
	 */
	public int getCuerpo() {
		return cuerpo;
	}

	/**
	 * observador de mueveInicial
	 * 
	 * @return the mueveInicial
	 */
	public int getMueveInicial() {
		return mueveInicial;
	}

	/**
	 * observador de ataqueInicial
	 * 
	 * @return the ataqueInicial
	 */
	public int getAtaqueInicial() {
		return ataqueInicial;
	}

	/**
	 * observador de defensaInicial
	 * 
	 * @return the defensaInicial
	 */
	public int getDefensaInicial() {
		return defensaInicial;
	}

	/**
	 * observador de cuerpoInicial
	 * 
	 * @return the cuerpoInicial
	 */
	public int getCuerpoInicial() {
		return cuerpoInicial;
	}

	/**
	 * Obtén el nombre
	 * 
	 * @return el nombre del personaje
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Comprueba si al personaje le queda algún punto de vida
	 * 
	 * @return cierto si está vivo, falso en otro caso
	 */
	public boolean estaVivo() {
		return cuerpo > 0;
	}

	/**
	 * Calcula un ataque del personaje calculando el número de impactos, para ello
	 * tira tantos dados como su propiedad ataque indique
	 * 
	 * @return el número de impactos del personaje
	 */
	public int atacar() {
		int impactos = 0;
		for (int x = 0; x < ataque; x++)
			if (Dado.tira() > 3)
				impactos++;
		return impactos;
	}

	/**
	 * Simula un ataque a otro personaje, realiza el ataque y la defensa. Si acaba
	 * con el objetivo lo saca del tablero
	 * 
	 * @param p             personaje al que se ataca
	 * @param partidaActual partida actual
	 */
	public void combatir(Personaje p, Partida partidaActual) { // ataca a p y p se defiende
		int dano = p.getCuerpo(); //estadisticas
		p.defender(this.atacar());
		if (!p.estaVivo()) {
			partidaActual.getTablero().quitaFicha(p);
		}
		
		//Estadisticas
		dano = dano - p.getCuerpo();
		if (p instanceof Heroe) {
			partidaActual.getEstadopartida()
					.setDaniomonstruos(partidaActual.getEstadopartida().getDaniomonstruos() + dano);
		} else {
			partidaActual.getEstadopartida().setDanioheroes(partidaActual.getEstadopartida().getDanioheroes() + dano);
		}

		if (this instanceof Heroe) {
			partidaActual.getEstadopartida()
			.setAtaqueheroes(partidaActual.getEstadopartida().getAtaqueheroes() + 1);
		} else {
			partidaActual.getEstadopartida()
					.setAtaquemonstruos(partidaActual.getEstadopartida().getAtaquemonstruos() + 1);
		}
	}

	/**
	 * El personaje se defiende de un ataque (método abstracto: cada subclase
	 * definirá su comportamiento propio)
	 * 
	 * @param impactos el total de impactos que tiene que intentar detener o sufrir
	 * @return el numero de heridas sufridas
	 */
	public abstract int defender(int impactos);

	/**
	 * Comprueba que el personaje pasado como argumento sea enemigo del actual
	 * Enemigo será todo aquel que no sea de la misma clase
	 * 
	 * @param p personaje a comprobar afiliación
	 * @return cierto si es enemigo del personaje actual
	 */
	public boolean esEnemigo(Personaje p) {
		return this.getClass() != p.getClass();
	}

	/**
	 * Accion de combate del personaje
	 * 
	 * @param partidaActual partida en la que tiene que actuar el personaje
	 * @return cierto si llega a combatir con un enemigo, falso en otro caso
	 */
	public boolean accionCombatir(Partida partidaActual) {
		// Atacar a un enemigo al azar
		VectorDinamicoPersonajes objetivos = Jeroquest.objetivosValidos(partidaActual, this);
		// Personaje tmp = objetivos.get(1);
		if (objetivos.length() > 0) {
			// Elegimos al objetivo valido con más cuerpo
			Personaje tmp = objetivos.get(0);
			for (int i = 1; i < objetivos.length(); i++) {
				if (tmp.getCuerpo() < objetivos.get(i).getCuerpo()) {
					tmp = objetivos.get(i);
				}
			}
			// Personaje objetivo = objetivos.get(Dado.tira(objetivos.length()) - 1);
			System.out.println(this.getNombre() + this.getPosicion() + " ataca a " + tmp.getNombre() + tmp.getPosicion());
			this.combatir(tmp, partidaActual);
			return true;
		}
		return false;
	}

	/**
	 * Accion de movimiento del personaje
	 * 
	 * @param partidaActual partida en al que tiene que actuar el personaje
	 * @return el número de casillas que se ha movido
	 */
	public int accionMovimiento(Partida partidaActual) {
		// Nos movemos al azar por el tablero
		System.out.print(this.getNombre() + this.getPosicion() + " se mueve a ");
		VectorDinamicoXYLocation posicionesValidas = Jeroquest.posicionesValidas(partidaActual, this);
		int mov = this.getMueve();
		while ((posicionesValidas.length() > 0) && (mov > 0)) {
			// si puede se mueve en una dirección escogida al azar
			XYLocation nuevaPosicion = posicionesValidas.get(Dado.tira(posicionesValidas.length()) - 1);
			// System.out.println(nuevaPosicion);
			partidaActual.getTablero().mueveFicha(this, nuevaPosicion);
			mov--;
			System.out.println(this.getPosicion());

			// ventana
			Jeroquest.monitor.muestraPartida();
			//MiTeclado.pulsaIntro();

			posicionesValidas = Jeroquest.posicionesValidas(partidaActual, this);
		}

		if (Jeroquest.bloqueado(partidaActual, this))
			System.out.println("<<<BLOQUEADO");
		// ventana
		 Jeroquest.monitor.muestraPartida();
		 //MiTeclado.pulsaIntro();

		return this.getMueve() - mov;
	}

	/**
	 * IA: Inteligencia Artificial de los personajes Se realizan las acciones
	 * correspondientes a su turno: ataque y movimiento
	 * 
	 * @param partidaActual partida en la que tiene que actuar el personaje
	 */
	public void resuelveTurno(Partida partidaActual) {

		// Atacar a un enemigo al azar
		accionCombatir(partidaActual);

		// Nos movemos al azar por el tablero
		accionMovimiento(partidaActual);
		

		// Posibles mejoras (entre otras):
		// - Moverse hacia el enemigo más cercano/ con menos vida /...
		// A.- Primero en Xs y luego en Ys
		// B.- Primero en la coordenada que tenga mayor diferencia con la posición del
		// objetivo
		// - IA: comprobar si hay una ruta libre hasta el objetivo
		// - ¿Qué hacer si tenemos el camino bloqueado por otros personajes aliados?
		// - Detenerse si tenemos un enemigo a tiro
		// y si esta libre y dentro del tablero se mueve a esa posicion

	}

	/**
	 * Genera la versión String imprimible del objeto (Método reescrito)
	 * 
	 * @return La versión como String imprimible del personaje
	 */
	@Override
	public String toString() {
		return String.format("%s (mueve:%d ataque:%d defensa:%d cuerpo:%d/%d)", getNombre(), getMueve(), getAtaque(),
				getDefensa(), getCuerpo(), getCuerpoInicial());
	}

	/************************************************
	 * Implementación de la interfaz PersonajeGrafico
	 **********************************************/

	// Icono de un personaje abstracto
	protected static Icon icono = new ImageIcon(ClassLoader.getSystemResource("desconocido.png"));

	/**
	 * Devuelve el icono asociado a un personaje abstracto
	 * 
	 * @return el icono asociado a la clase Personaje
	 */
	public Icon getImagen() {
		return icono;
	}

	/**
	 * Muestra un icono representando el personaje como un icono en la capa 2
	 * 
	 * @param v panel gráfico donde mostrar el icono
	 */
	public void muestra(MiPanelTablero v) {
		XYLocation pos = getPosicion();
		// si el personaje está muerto no está en el tablero
		if (pos != null) {
			// se crea una JLabel con el icono asociado a la clase del personaje
			JLabel lab = new MiJLabelPersonaje(this);

			// se añade la etiqueta en la capa 2
			v.add(lab, new Integer(2));
		}

	}

	/************************************************
	 * Implementación de la interfaz Ficha
	 **********************************************/
	// por composicion
	protected XYLocation posicion; // posicion ocupada en el tablero

	/**
	 * Obtén la posición en el tablero
	 * 
	 * @return laposición en el tablero del personaje
	 */
	public XYLocation getPosicion() {
		return posicion;
	}

	/**
	 * Fija la posición del personaje en el tablero
	 * 
	 * @param pos nueva posición del personaje en el tablero
	 */
	public void setPosicion(XYLocation pos) {
		posicion = pos;
	}

	/**
	 * Genera la version texto de la vista del personaje en el tablero
	 * 
	 * @return caracter del Personaje orientada a la vista del tablero
	 */
	public char toChar() {
		// si la sublcase no define otra cosa, los personajes aparecerán
		// como '?'s
		return '?';
	}

}
