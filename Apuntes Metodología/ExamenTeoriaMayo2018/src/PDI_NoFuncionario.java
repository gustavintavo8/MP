
public class PDI_NoFuncionario extends PDI implements Laboral{
	
	public PDI_NoFuncionario (String ne, String dni, int ant, String dep) {
		super(ne, dni, ant, dep);
	}
	
	// Implementacion de la interfaz Laboral
	
	public float indemnizacionPorDespido() {
		return getAntiguedad() * salario();
	}
	
	@Override
	public String toString() {
		return String.format("%s\n[PDI_Nofuncionario - Indemnizacion Despido: %.2f]", super.toString(), indemnizacionPorDespido());
	}

}
