
/**
 * Programa principal de visualizaci�n de figruas en una ventana
 * mediante la interfaz FiguraGrafica
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 *
 */

import java.util.Random; // generador de n�meros aleatorios

public class FigurasTest {

	// ventana donde mostrar las figuras
	private static MiVentana v = null;

	/**
	 * Funci�n main de entrada al programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Observa esto
		FiguraGrafica fg = (FiguraGrafica) new Triangulo(1, 2, 3, 4, 5, 6);
		System.out.println(fg.getEtiqueta());

		// Y comprueba que esto va bien
		Circulo c = new CirculoConCentro(2, 3, 4);
		System.out.println(((FiguraGrafica) c).getEtiqueta());

		// Y que esto no va bien, �por qu�?
		Circulo c1 = new Circulo(4);
		//System.out.println(((FiguraGrafica) c1).getEtiqueta());

		// Ahora vamos a crear un vector de objetos con etiquetas

		// constantes de total de figuras a crear
		final int TOTALCIRCULOS = 5;
		final int TOTALCIRCULOSCONCENTRO = 5;
		final int TOTALTRIANGULOS = 5;

		// creamos un generador de n�meros aleatorios
		Random gen = new Random();

		// array de figuras
		FigurasGeometricas[] fig = new FigurasGeometricas[TOTALCIRCULOS + TOTALCIRCULOSCONCENTRO + TOTALTRIANGULOS];

		// Crea y muestra la ventana de la aplicaci�n
		iniciaVentana();

		// Crea los c�rculos
		for (Integer x = 0; x < TOTALCIRCULOS; x++) {
			fig[x] = new Circulo(gen.nextInt(50));
			// Fijamos el "C"+x como etiqueta

		}

		// Crea los c�rculos con centro
		for (Integer x = 0; x < TOTALCIRCULOSCONCENTRO; x++) {
			fig[TOTALCIRCULOS + x] = new CirculoConCentro(gen.nextInt(300), gen.nextInt(300), gen.nextInt(50));
			// Fijamos el "C"+x como etiqueta

		}

		// Crea los tri�ngulos
		for (Integer x = 0; x < TOTALTRIANGULOS; x++) {
			fig[TOTALCIRCULOS + TOTALCIRCULOSCONCENTRO + x] = new Triangulo(gen.nextInt(300), gen.nextInt(300),
					gen.nextInt(300), gen.nextInt(300), gen.nextInt(300), gen.nextInt(300));
			// Fijamos el "T"+x como etiqueta

		}
		FigurasGeometricas.mostrar(fig);
		// Reutiliza los algoritmos de la pr�ctica anterior

		// Ordenar el vector por superficie de menor a mayor
		FigurasGeometricas.ordena(fig);
		
		//FigurasGeometricas.mostrar(fig);
		// mostramos las figuras
		v.muestraFiguras(fig);

		// calculamos y mostramos el �rea total
		System.out.printf("El �rea total es: %.2f\n", FigurasGeometricas.areaTotal(fig));

		// Pausa de teclado
		MiTeclado.pulsaIntro();

		// destruimos la ventana
		 finalizaVentana();
		 System.out.println("A tu CASA");
	}

	private static void iniciaVentana() {
		v = new MiVentana("Figuras geom�tricas");
	}

	private static void finalizaVentana() {
		v.finaliza();
	}

}
