
public class PAS extends PersonalUniversidad implements Laboral{
	
	private static final int DIAS_INCREMENTO = 2; // las vacaciones se incrementan dos dias . . .
	private static final int POR_CADA_AÑOS = 5; // por cada 5 años de antiguedad
	
	private static final float POR_TRIENIO = 30; // 30 euros por trienio
	
	private Servicio servicio;
	
	public PAS(String ne, String dni, int ant, Servicio serv) {
		super(ne, dni, ant);
		servicio = serv;
	}
	
	public Servicio getServicio() {
		return servicio;
	}
	
	public void setServicio(Servicio serv) {
		servicio = serv;
	}
	
	public int vacaciones() {
		return super.vacaciones() + DIAS_INCREMENTO*(getAntiguedad()/POR_CADA_AÑOS);

	}
	
	@Override
	public float salario() {
		return getServicio().getSalarioBase() + POR_TRIENIO * numeroTrienios();
	}
	
	@Override
	public String toString() {
		return String.format("%s\n[PAS - Sevicio: %s - Indemnizacion Despido: %.2f]", 
				super.toString(), getServicio(), indemnizacionPorDespido());
	}
	
	// Implementacion de la interfaz Laboral
	
	public float indemnizacionPorDespido() {
		return getAntiguedad() * salario();
	}

}
