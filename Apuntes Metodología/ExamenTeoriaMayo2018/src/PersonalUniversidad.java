
public abstract class PersonalUniversidad {
	
	protected static final int DIAS_DE_VACACIONES = 30; // Dias de vacaciones 
	
	private String nombre;
	private String DNI;
	private int antiguedad;
	
	public PersonalUniversidad(String ne, String dni, int ant) {
		nombre  = ne;
		DNI = dni;
		antiguedad = ant;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public int getAntiguedad() {
		return antiguedad;
	}
	
	public int vacaciones() {
		return DIAS_DE_VACACIONES;
	}
	
	public int numeroTrienios() {
		return getAntiguedad()/3;
	}
	
	public abstract float salario();
	
	@Override
	public String toString() {
		return String.format("\n[PU - Nombre: %s - DNI: %s - Antiguedad: %d - Salario: %.2f - Vacaciones: %d]", 
				getNombre(), getDNI(), getAntiguedad(), salario(), vacaciones());
	}

}
