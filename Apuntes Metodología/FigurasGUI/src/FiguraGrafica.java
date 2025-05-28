import java.awt.Graphics;

public interface FiguraGrafica {
	/**
	* Pinta la figura y su etiqueta en la ventana que se le
	* especifica utilizando el objeto Graphics que se le
	* proporciona
	* @param g objeto Graphics sobre el que pintar la figura
	*/
	public void pinta(Graphics g);
	/**
	* Fija la etiqueta a mostrar junto con la figura
	* @param nuevaEtiqueta etiqueta a asociar a la figura
	*/
	public void setEtiqueta(String nuevaEtiqueta);
	/**
	* Devuelve la etiqueta asociada a la figura
	*/
	public String getEtiqueta();

}
