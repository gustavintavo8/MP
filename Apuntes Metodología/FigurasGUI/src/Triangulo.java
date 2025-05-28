import java.awt.Graphics;
import java.awt.Polygon;

public class Triangulo extends FigurasGeometricas implements FiguraGrafica{
	
	private Punto A, B, C;
	private String etiqueta = "T";

	public Triangulo(Punto a, Punto b, Punto c) {
		A = a;
		B = b;
		C = c;
	}

	public Triangulo(int a1, int a2, int b1, int b2, int c1, int c2) {
		A = new Punto(a1, a2);
		B = new Punto(b1, b2);
		C = new Punto(c1, c2);
	}

	/**
	 * @return the a
	 */
	public Punto getA() {
		return A;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(Punto a) {
		A = a;
	}

	/**
	 * @return the b
	 */
	public Punto getB() {
		return B;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(Punto b) {
		B = b;
	}

	/**
	 * @return the c
	 */
	public Punto getC() {
		return C;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(Punto c) {
		C = c;
	}

	public double area() {
		Punto AB = new Punto(this.getA().getX() - this.getB().getX(), this.getA().getY() - this.getB().getY());
		Punto AC = new Punto(this.getA().getX() - this.getC().getX(), this.getA().getY() - this.getC().getY());
		Punto Nab = new Punto(AB.getY(), -AB.getX());
		// Nab *AC * 1/2
		return Math.abs(Nab.getX() * AC.getX() + Nab.getY() * AC.getY()) * (1.0/ 2);
	}
	
	public double perimetro() {
		return Punto.distancia(A, B)+Punto.distancia(C, B)+Punto.distancia(A, C);
	}
	
	public double area2() {
		double semi = this.perimetro()/2;
		return Math.sqrt(semi*(semi -Punto.distancia(A, B))*(semi - Punto.distancia(B, C))*(semi - Punto.distancia(C,A)));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Triangulo [A=" + A + ", B=" + B + ", C=" + C + "]";
	}

	@Override
	public void pinta(Graphics g) {
		// creamos un array con las Xs y otro con las Ys
		int [] xs = {A.getX(), B.getX(), C.getX()};
		int [] ys = {A.getY(), B.getY(), C.getY()};
		// creamos un objeto polígono con esos 3 puntos
		Polygon p = new Polygon(xs, ys, 3);
		// dibujamos el polígono
		g.drawPolygon(p);
		// dibujamos la etiqueta
		int x = (int)((A.getX() + B.getX() + C.getX())/3);
		int y = (int)((A.getY()+ B.getY() + C.getY())/3);
		g.drawString(this.getEtiqueta(), x - 3, y + 4);
		
	}
	

	@Override
	public void setEtiqueta(String nuevaEtiqueta) {
		this.etiqueta = nuevaEtiqueta;
		
	}

	@Override
	public String getEtiqueta() {
		// TODO Auto-generated method stub
		return etiqueta;
	}
	
	
}
