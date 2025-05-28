
public abstract class PDI extends PersonalUniversidad{
	
	protected static final float POR_TRIENIO = 40; // 40 euros por trienio
	protected static final float SALARIO_BASE = 1500;
	
	private String departamento;
	
	public PDI (String ne, String dni, int ant, String dep) {
		super(ne, dni, ant);
		departamento = dep;
	}
	
	@Override
	public float salario() {
		return SALARIO_BASE + POR_TRIENIO * numeroTrienios();
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	@Override
	public String toString() {
		return String.format("%s\n[PDI - Departamento: %s]", super.toString(), getDepartamento());	
	}

}
