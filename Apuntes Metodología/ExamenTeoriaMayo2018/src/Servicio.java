
public class Servicio {
	
	private String nombre;
	private float salarioBase;
	
	public Servicio(String ne, float sal) {
		setNombre(ne);
		setSalarioBase(sal);
	}
	
	public void setSalarioBase(float sal) {
		salarioBase = sal;
	}
	
	public void setNombre(String nom) {
		nombre = nom;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public float getSalarioBase() {
		return salarioBase;
	}
	
	@Override
	public String toString() {
		return String.format("[SERVICO - Nombre: %s - SalarioBase: %.2f]", getNombre(), getSalarioBase());
	}

}
