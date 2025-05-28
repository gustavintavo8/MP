
public class CirculosTest {

	// ventana donde mostrar los círculos
	private static MiVentana v = null;

	public static void main(String[] args) {

		// total de círculos a mostrar
		final int TOTAL = 2;
		// array de círculos con centro
		CirculoConCentro[] circulos = new CirculoConCentro[TOTAL];

		// Crea y muestra la ventana de la aplicación
		// (de momento sin círculos)
		iniciaVentana();

		// Genera los circulos
		// centro con X e Y en el rango [1..250]
		// y radio [1..50]
		for (int x = 0; x < TOTAL; x++)
			circulos[x] = new CirculoConCentro(Dado.tira(300), Dado.tira(300), Dado.tira(100));

		// System.out.println("Imprime centro de:" + circulos[0].toString());
		// CONSOLA: se muestran los círculos en formato texto
		// for (CirculoConCentro c : circulos)
		// System.out.println(c);

		// VENTANA: mostramos los circulos (en la ventana)
		muestraCirculos(circulos);
		// int k = 130;
		// moverCirculos(circulos, k);
		MiTeclado.pulsaIntro();
		circulos[0].absorbe(circulos[1]);

		muestraCirculos(circulos);
		// esperamos que se pulse la tecla Intro
		// MiTeclado es una clase estatica definida en MiVentana.java
		MiTeclado.pulsaIntro();
		// cierra y libera los recursos de la ventana
		/*
		 * for (int x = 0; x < 10 ; x++) { circulos[x] = new
		 * CirculoConCentro(Dado.tira(250), Dado.tira(250), Dado.tira(50));
		 * muestraCirculos(circulos); MiTeclado.pulsaIntro(); }
		 */
		finalizaVentana();

	}

	private boolean dentro(Punto p, CirculoConCentro c) {
		double radio = c.getRadio();
		int xPoint = c.getCentro().getX();
		int yPoint = c.getCentro().getY();
		int Xcentro = p.getX();
		int Ycentro = p.getY();

		if (Math.sqrt((Xcentro - xPoint) ^ 2 + (Ycentro - yPoint) ^ 2) <= radio)
			return true;
		return false;
	}

	private static void moverCirculos1(CirculoConCentro[] circulos, int k) {
		for (int i = 0; i < circulos.length; i++) {
			int cuanto = Dado.tira(k) - 1;
			if (Dado.tira(2) == 1)
				cuanto = -cuanto;
			int cual = Dado.tira(3);
			int coorX = circulos[i].getCentro().getX();
			int coorY = circulos[i].getCentro().getX();
			double radio = circulos[i].getRadio();
			switch (cual) {
			case 1:
				coorX = Math.max(0, coorX + cuanto);
				circulos[i].getCentro().setX(coorX);
				break;

			case 2:
				coorY = Math.max(0, coorY + cuanto);
				circulos[i].getCentro().setY(coorY);
				break;
			case 3:
				radio = Math.max(0, radio + cuanto);
				circulos[i].setRadio(radio);
				break;
			}
		}
	}

	private static void moverCirculos(CirculoConCentro[] circulos, int k) {
		int datoModifico;
		boolean cambio;
		for (int i = 0; i < circulos.length; i++) {
			datoModifico = Dado.tira(3);
			cambio = modifico();
			variar(circulos[i], k, datoModifico, cambio);
		}

	}

	private static void variar(CirculoConCentro circulo, int k, int datoModifico, boolean cambio) {
		int tmp1; // variable temporal para las coordenadas
		int tmp2; // variable temporal para las coordenadas

		if (datoModifico == 1) {
			double tmp3 = circulo.getRadio(); // variable temporal para el raddio
			if (cambio)
				circulo.setRadio(Dado.tira(k) + tmp3);
			else {
				circulo.setRadio(Dado.tira(k) - tmp3);
				if (circulo.getRadio() < 0)
					circulo.setRadio(0);
			}
		}
		tmp1 = circulo.getCentro().getX();
		tmp2 = circulo.getCentro().getY();
		if (datoModifico == 2) {
			if (cambio) // sumo getX()
				circulo.setCentro(Dado.tira(k) + tmp1, tmp2);
			else { // resto getX()
				circulo.setCentro(Dado.tira(k) - tmp1, tmp2);
				if (circulo.getCentro().getX() < 0)
					circulo.setCentro(0, tmp2);
			}
		} else {
			if (cambio) // sumo getY()
				circulo.setCentro(tmp1, Dado.tira(k) + tmp2);
			else { // resto getY()
				circulo.setCentro(tmp1, Dado.tira(k) - tmp2);
				if (circulo.getCentro().getY() < 0)
					circulo.setCentro(tmp1, 0);
			}
		}

	}

	private static boolean modifico() {
		return Dado.tira(2) == 1;
	}

	private static void iniciaVentana() {
		v = new MiVentana("Círculos");
	}

	private static void finalizaVentana() {
		v.finaliza();
	}

	/**
	 * Actualiza el array de círculos a mostrar por la ventana y los repinta
	 * 
	 * @param circulos array de círculos a mostrar
	 */
	private static void muestraCirculos(CirculoConCentro[] circulos) {
		// Los muestra graficamente en la ventana
		v.muestraCirculos(circulos);
	}
}
