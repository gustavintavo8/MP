
public abstract class Trabajador {
	
	private String nombre;
	private String nif;
	
	// constructor
	public Trabajador(String ne, String ni){
		setNombre(ne);
		setNif(ni);
	}

	// sets y gets, modificadores y observadores
	public void setNombre(String ne){
		nombre = ne;
	}
	public void setNif(String ni){
		nif = ni;
	}
	public String getNombre(){
		return nombre;
	}
	public String getNif(){
		return nif;
	}
	
	// método abstracto. Se sobreescribe en cada subclase
	public abstract double salario();
	
	// toString()
	public String toString(){
		return String.format("%s - [salario: %s]\n[nombre: %s, NIF: %s]\n", 
				getClass().getName(), salario(), getNombre(), getNif());
	}

}
