import java.awt.Graphics;

public class CirculoConCentro extends Circulo implements FiguraGrafica {

	private Punto centro;

	public CirculoConCentro(int x, int y, int r) {
		super(r);
		centro = new Punto(x, y);
	}

	public Punto getCentro() {
		return centro;
	}

	void setCentro(int x, int y) {
		centro.setX(x);
		centro.setY(y);
	}

	void setCentro(Punto p) {
		centro = p;
	}

	public static boolean solapa(CirculoConCentro c1, CirculoConCentro c2) {
		double d = Punto.distancia(c1.getCentro(), c2.getCentro());

		boolean resultado = d < (c1.getRadio() + c2.getRadio());
		if (resultado)
			return resultado;
		else
			return resultado;

	}

	public void absorbe(CirculoConCentro c) {
		double sup1 = this.area();
		double sup2 = c.area();

		// Calculamos la proporcion que supone la superficie del circulo actual frente a
		// la suma de superficies de ambos circulos
		double ratio = sup1 / (sup1 + sup2);

		// Desplazamos la X del circulo actual hacia la X del circulo c en proporcion a
		// la ratio anterior
		int newX = (int) (this.getCentro().getX() + (c.getCentro().getX() - this.getCentro().getX()) * ratio);

		// Desplazamos la Y del circulo actual hacia la Y del circulo c en proporcion a
		// la ratio anterior
		int newY = (int) (this.getCentro().getY() + (c.getCentro().getY() - this.getCentro().getY()) * ratio);

		// El nuevo radio supondra un area del circulo resultado de la suma de areas de
		// los circulos originales
		// es decir sqrt(circulo_actual.radio^2 + c.radio^2)
		int newRadio = (int) Math.round(Math.sqrt(Math.pow(this.getRadio(), 2) + Math.pow(c.getRadio(), 2)));

		// actualizamos propiedades
		this.setCentro(newX, newY);
		this.setRadio(newRadio);

		// minimizamos el circulo absorvido
		c.setCentro(new Punto(0, 0));
		c.setRadio(0);

	}

	// interfaz FiguraGrafica
	private String etiqueta = "CC"; // la etiqueta a mostrar con la figura

	/**
	 * Fija la etiqueta de la FiguraGrafica
	 * 
	 * @param nuevaEtiqueta la nueva etiqueta asociada a la figura
	 */
	public void setEtiqueta(String nuevaEtiqueta) {
		etiqueta = nuevaEtiqueta;
	}

	/**
	 * Devuelve la etiqueta asociada a la figura
	 */
	public String getEtiqueta() {
		return etiqueta;
	}

	/**
	 * Pinta con el objeto Graphics el círculo junto con su etiqueta
	 * 
	 * @param g objeto Graphics con el que pintar
	 */
	public void pinta(Graphics g) {
		// dibujamos un óvalo inscrito en un rectángulo, que se corresponda
		// con el círculo a mostrar: (xInicial, YInicial,ancho,alto)
		g.drawOval((int) getCentro().getX() - (int) getRadio(),
				(int) getCentro().getY() - (int) getRadio(),
				2 * (int) getRadio(), 2 * (int) getRadio());

		// dibujamos la etiqueta
		g.drawString(etiqueta, 
				(int) getCentro().getX() - 3,
				(int) getCentro().getY() + 4);

	}

	// @Override
	public String toString() {
		return "(" + getCentro() + "|" + getRadio() + ")";
	}
}
