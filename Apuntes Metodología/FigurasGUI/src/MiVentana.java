
/** Representa gr�ficamente en una ventana un array de figuras geom�tricas
 *  Utilizando polimorfismo al aplicar la interfaz FiguraGrafica 
 *  @author Profesores de Metodolog�a de la Programaci�n
 *  @version 1.0  */

import javax.swing.JFrame; // necesario para la ventana
import javax.swing.JPanel; // necesario para el panel dentro de la ventana
import java.awt.Graphics; // necesario para pintar el contenido de la ventana

import java.io.BufferedReader; // necesarios para leer pulsaciones de teclas del teclado
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase Ventana, para representar informaci�n gr�fica por medio de un panel y
 * su array de objetos a mostrar En esta versi�n heredamos directamente de
 * JFrame
 * 
 * @author los profesores de MTP
 *
 */
public class MiVentana extends JFrame {

	private MiPanel panel = null; // panel de contenidos a mostrar

	/**
	 * Constructor de ventana
	 * 
	 * @param titulo ser� el t�tulo de la ventana
	 */
	public MiVentana(String titulo) {
		// fijamos el t�tulo de la ventana por medio del constructor de JFrame
		super(titulo);

		// creamos un panel
		panel = new MiPanel();

		// accion a realizar cuando se cierra la ventana -> se finaliza la aplicacion
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// se a�ade el panel a la ventana
		add(panel);
		// establecemos las dimensiones de la ventana
		setSize(350, 350);
		// hacemos visible la ventana
		setVisible(true);
	}

	/**
	 * Fija el array de objetos a ser mostrados y fuerza su pintado
	 * 
	 * @param figs nuevo a array de objetos a mostrar
	 */
	public void muestraFiguras(FigurasGeometricas[] figs) {
		panel.setFigs(figs);
		// fuerza que se repinten los c�rculos en la ventana
		panel.repaint();
	}

	/**
	 * Finaliza la ventana y libera los recursos utilizados
	 */
	public void finaliza() {
		dispose();
	}

}

/**
 * Clase MiPanel, representa un panel de contenidos a mostrar en una ventana
 * concretamente un array de figuras geom�tricas
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 *
 */
class MiPanel extends JPanel {
	// esto evita un warning referido a clases serializables
	private static final long serialVersionUID = 1L;

	// array de figuras a mostrar
	protected FigurasGeometricas[] figs = null;

	/**
	 * Observador de figs
	 * 
	 * @return figs
	 */
	public FigurasGeometricas[] getFigs() {
		return figs;
	}

	/**
	 * modificador de figs
	 * 
	 * @param figs nuevo array de figuras a mostrar
	 */
	public void setFigs(FigurasGeometricas[] figs) {
		this.figs = figs;
	}

	/**
	 * M�todo para repintar el array de objetos
	 * 
	 * @param g objeto Graphcis en el que dibujar (NOTA: este m�todo lo invoca JAVA
	 *          cada vez que sea necesario repintar el panel (ej: al maximizar,
	 *          minimizar, mover la ventana,...) (NOTA2: m�todo polim�rfico ya que
	 *          no todas las figuras se saben mostrar)
	 */
	public void paintComponent(Graphics g) {
		// se invoca al metodo del padre
		// para que JAVA pinte lo que considere necesario
		super.paintComponent(g);

		// si hay figuras definidas se repintan
		// por medio de la interfaz FiguraGrafica
		for (FigurasGeometricas fg : figs) {
			if (fg instanceof FiguraGrafica) {
				((FiguraGrafica) fg).pinta(g);
			}

		}
		// Para cada figura del campo figs
		// si es una figura gr�fica se pinta . . .
	}
}

/**
 * Clase est�tica Teclado para acceder a las pulsaciones del teclado desde la
 * consola de texto. (las ventanas tienen otro sistema, basado en eventos, para
 * detectar pulsaciones)
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 *
 */
class MiTeclado {

	/**
	 * Espera que se pulse la tecla Intro del teclado
	 */
	static public void pulsaIntro() {

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Pulsa Intro para continuar");
		try {
			teclado.readLine();
		} catch (IOException ex1) {
		}
	}
}
