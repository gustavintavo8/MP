
public class Circulo {

	private double radio;

	public Circulo (double radio) {
		this.setRadio(radio);
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		if (radio > 0)
			this.radio = radio;
	}
	public double perimetro() {
		return this.getRadio()*2*Math.PI;
	}
	
	public double area() {
		return Math.PI * this.getRadio() * this.getRadio();
	}
	
	@Override
	public String toString() {
		return "Circulo [radio=" + radio + "]";
	}

}
