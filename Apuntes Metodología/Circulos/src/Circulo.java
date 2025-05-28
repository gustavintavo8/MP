
public class Circulo {
	
	private double radio;
	
	public Circulo(double radio) {
		this.setRadio(radio);
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getRadio() {
		return radio;
	}
	
	public double perimetro() {
		return Math.PI*2*this.getRadio();
	}
	
	public double area() {
		return Math.PI*this.getRadio()*this.getRadio();
	}
	
	@Override
	public String toString() {
		return String.format("Circulo: radio= %f", this.getRadio());
	}
	
	
}
