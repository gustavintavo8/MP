
import javax.swing.Icon;

public interface ElementoGrafico {
	/**
	 * Devuelve la imagen de icono asociada al elemento gr�fico
	 * 
	 * @return el icono asociado a al elemento gr�fico
	 */
	Icon getImagen();

	/**
	 * Muestra un icono representando el personaje como un icono en la capa 2
	 * 
	 * @param v panel gr�fico donde mostrar el icono
	 */
	void muestra(MiPanelTablero v);
}
