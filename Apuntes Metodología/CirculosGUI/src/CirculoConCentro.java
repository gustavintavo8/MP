
public class CirculoConCentro extends Circulo {

	private Punto centro;
	
	public CirculoConCentro(int x, int y, double radio) {
		super(radio);
		centro = new Punto(x, y);
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public void setCentro(int i, int y) {
		this.centro.setX(i);
		this.centro.setY(y);
	}

	public double area() {
		return Math.PI * Math.pow(getRadio(), 2);
	}

	public void absorbe(CirculoConCentro c) {
		double dt = Punto.distancia(this.getCentro(), c.getCentro());
		System.out.println(dt);
		double superficie1= this.area();
		double superficie2 = c.area();
		
		int x = this.getCentro().getX();
		int y = this.getCentro().getY();
		Punto uno = new Punto(x,y);
		
		double f_escala = superficie1 / (superficie1 + superficie2);
		int coorX = (int) (this.getCentro().getX() + (c.getCentro().getX() - this.getCentro().getX())*f_escala);
		int coorY = (int) (this.getCentro().getY() + (c.getCentro().getY() - this.getCentro().getY())*f_escala);
		
		double newR = 	Math.sqrt((superficie1 + superficie1)/Math.PI);
		
		
		this.setCentro(coorX, coorY);
		
		double d1 = Punto.distancia(this.getCentro(), uno);
		double d2 = Punto.distancia(c.getCentro(), this.getCentro());
		System.out.println("d1= " + d1 + "; d2= " + d2);
		System.out.printf("%b", d2 + d1 == dt);
		this.setRadio(newR);
		
		c.setRadio(0);
		c.setCentro(0, 0);
		
		
	}
	
	private static void limpiezaCirculos(CirculoConCentro c[]) {
		for (int i = 0; i < c.length; i++) {
			if(!esNulo(c[i]))
				for (int j = 0; j < c.length; j++) {
					if(i!=j && (!esNulo(c[j])))
						if(solapa(c[i],c[j]))
							c[i].absorbe(c[j]);
				}
		}
	}
	
	private static boolean esNulo(CirculoConCentro c) {
		return (c.getCentro().getX()==0 && c.getRadio()==0.0 && c.getCentro().getY()==0);
	}
	
	private static boolean solapa(CirculoConCentro c1, CirculoConCentro c2) {
		// la distancia entre sus centros es menor que la suma de ambos radios
		if (Punto.distancia(c1.getCentro(), c2.getCentro()) < (c1.getRadio() + c2.getRadio())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Centro: %s\n%s", this.getCentro(), super.toString());
	}

}
