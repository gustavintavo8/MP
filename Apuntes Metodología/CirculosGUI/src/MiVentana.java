import javax.swing.JFrame; // necesario para la ventana
import javax.swing.JPanel; // necesario para el panel dentro de la ventana
import java.awt.Graphics; // necesario para pintar el contenido de la ventana

import java.io.BufferedReader; // necesarios para leer pulsaciones de teclas del teclado
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase Ventana, para representar información gráfica por medio de un panel y
 * su array de objetos a mostrar
 * 
 * @author los profesores de MTP
 *
 */
public class MiVentana {

	private MiPanel panel; // panel de contenidos a mostrar
	private JFrame aplicacion = null;

	/**
	 * Constructor de ventana
	 * 
	 * @param titulo será el título de la ventana
	 */
	public MiVentana(String titulo) {
		// creamos el objeto JFrame que representa la ventana
		aplicacion = new JFrame(titulo);

		// creamos un panel
		panel = new MiPanel();

		// accion a realizar cuando se cierra la ventana -> se finaliza la aplicacion
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// se añade el panel a la ventana
		aplicacion.add(panel);
		// establecemos las dimensiones de la ventana
		aplicacion.setSize(350, 350);
		// hacemos visible la ventana
		aplicacion.setVisible(true);
	}

	/**
	 * Fija el array de objetos a ser mostrados y fuerza su pintado
	 * 
	 * @param cirs nuevo a array de objetos a mostrar
	 */
	public void muestraCirculos(CirculoConCentro[] cirs) {
		panel.setCirculos(cirs);
		// fuerza que se repinten los círculos en la ventana
		panel.repaint();
	}

	/**
	 * Finaliza la ventana y libera los recursos utilizados
	 */
	public void finaliza() {
		aplicacion.dispose();
	}

}

/**
 * Clase MiPanel, representa un panel de contenidos a mostrar en una ventana
 * concretamente un array de objetos
 * 
 * @author Profesores de Metodología de la Programación
 *
 */
class MiPanel extends JPanel {
	// NOTA: esto evita un warning referido a clases serializables
	private static final long serialVersionUID = 1L;

	// array de objetos a mostrar
	private CirculoConCentro[] circulos = null;

	/**
	 * Observador de circulos
	 * 
	 * @return circulos
	 */
	public CirculoConCentro[] getCirculos() {
		return circulos;
	}

	/**
	 * modificador de circulos
	 * 
	 * @param circulos nuevo array con circulos
	 */
	public void setCirculos(CirculoConCentro[] circulos) {
		this.circulos = circulos;
	}

	/**
	 * Método para mostrar un círculo en el panel actual
	 * 
	 * @param etiqueta texto a mostrar en el centro del círculo
	 * @param c        círculo a mostrar
	 * @param g        objeto Graphics en el que dibujar
	 */
	private void muestraCirculo(String etiqueta, CirculoConCentro c, Graphics g) {
		int offset = -(int) (c.getRadio());
		int cX = (int) (c.getCentro().getX());
		int cY = (int) (c.getCentro().getY());
		int cRadio = (int) (c.getRadio());
		// dibujamos el círculo
		g.drawOval(cX + offset, cY + offset, 2 * cRadio, 2 * cRadio);

		// dibujamos el texto
		g.drawString(etiqueta, cX + cRadio + offset - 5, cY + cRadio + offset + 5);
	}

	/**
	 * Método para repintar el array de objetos
	 * 
	 * @param g objeto Graphcis en el que dibujar (NOTA: este método lo invoca JAVA
	 *          cada vez que sea necesario repintar el panel (ej: al maximizar,
	 *          minimizar, mover la ventana,...)
	 */
	public void paintComponent(Graphics g) {
		// permitimos a la clase Padre que pinte sus contenidos
		super.paintComponent(g);

		// pintamos los círculos del array
		Integer x2 = 0;
		if (circulos != null)
			for (CirculoConCentro c : circulos) {
				muestraCirculo(x2.toString(), c, g);
				x2++;
			}

	}

}

/**
 * Clase estática Teclado para acceder a las pulsaciones del teclado desde la
 * consola de texto. (las ventanas tienen otro sistema, basado en eventos, para
 * detectar pulsaciones)
 * 
 * @author Profesores de Metodología de la Programación
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
