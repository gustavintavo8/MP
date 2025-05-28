
public class PDI_Funcionario extends PDI{

	protected static final float POR_TRAMO_INVESTIGACION = 120;
	protected static final float POR_TRAMO_DOCENTE = 100;
	
	private int tramosDocentes;
	private int tramosInvestigacion;
	
	public PDI_Funcionario (String ne, String dni, int ant, String dep, int nTD, int nTI) {
		super(ne, dni, ant, dep);
		tramosDocentes = nTD;
		tramosInvestigacion = nTI;
	}
	
	public int getTramosDocentes() {
		return tramosDocentes;
	}
	
	public int getTramosInvestigacion() {
		return tramosInvestigacion;
	}
		
		
	@Override
	public float salario() {
		return super.salario() + POR_TRAMO_INVESTIGACION * getTramosDocentes() +  POR_TRAMO_DOCENTE * getTramosInvestigacion();
	}
	
	@Override
	public String toString() {
		return String.format("%s\n[PDI_Funcinario - tramos docentes: %d - tramos investigacion: %d]", 
				super.toString(), getTramosDocentes(), getTramosInvestigacion());
		
	}
	
}
