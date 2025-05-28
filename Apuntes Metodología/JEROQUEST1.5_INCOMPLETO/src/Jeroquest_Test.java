
// Demo de la clase jeroquest

/**
 * Programa principal de prueba del juego Jeroquest
 * 
 * @author Jorge Puente Peinador
 * @version 1.4
 *
 */
public class Jeroquest_Test {

	public static void main(String[] args) {

		Jeroquest jq = new Jeroquest();
		// vamos a jugar una partida de 3 Bárbaros contra 4 Momias
		// en un tablero de 7 por 10
		// en 20 turnos
		jq.nuevaPartida(20,20,10,15,2);
		jq.aJugar();
	}

}
