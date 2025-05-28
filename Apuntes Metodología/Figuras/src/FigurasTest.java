/**
 * Programa principal de visualizaci�n de figruas en una ventana
 * mediante la interfaz FiguraGrafica
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 *
 */

import java.util.Random; // generador de n�meros aleatorios

public class FigurasTest {

	
	/**
	 * Funci�n main de entrada al programa
	 * @param args
	 */
	public static void main(String[] args) {

		// constantes de total de figuras a crear
		final int TOTALCIRCULOS = 5;
		final int TOTALCIRCULOSCONCENTRO = 5;
		final int TOTALTRIANGULOS = 5;

		// creamos un generador de n�meros aleatorios
		Random gen = new Random();
		
		// array de figuras
		FiguraGeometrica[] figuras = new FiguraGeometrica[TOTALCIRCULOS + TOTALCIRCULOSCONCENTRO + TOTALTRIANGULOS];
		
		
		// Crea los c�rculos
		for(Integer x = 0; x < TOTALCIRCULOS; x++){
			figuras[x] = new Circulo(gen.nextInt(50));
		}
		
		// Crea los c�rculos con centro
		for(Integer x = 0; x < TOTALCIRCULOSCONCENTRO; x++){
			figuras[TOTALCIRCULOS + x] = new CirculoConCentro(gen.nextInt(300),gen.nextInt(300),gen.nextInt(50));
		}
		
		// Crea los tri�ngulos
		for(Integer x = 0; x < TOTALTRIANGULOS; x++){
			figuras[TOTALCIRCULOS + TOTALCIRCULOSCONCENTRO + x] = new Triangulo(gen.nextInt(300),gen.nextInt(300),
					gen.nextInt(300),gen.nextInt(300),
					gen.nextInt(300),gen.nextInt(300));
		}
		
		
		// Definir m�todos est�ticos para:
		
		// Mostrar todas las figuras geometricas en modo texto
		
		// Calcular la superficie total de las figuras del vector
		
		// Ordenar las figuras del vector por superficie de menor a mayor 
		
	}


	 
}
