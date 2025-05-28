
public class TrabajadorPorHoras extends Trabajador implements Precario{
	
	private static final double SALARIO_POR_HORA = 10.0;
	private static final double MIN_HORAS = 10.0;
	private static final double MAX_HORAS = 20.0;
	private static final double HORAS_JORNADA_COMPLETA = 35.0;
	
	private double horasTrabajadas;
	
	// contructor
	public TrabajadorPorHoras(String ne, String ni, double ht){
		super(ne,ni);
		setHorasTrabajadas(ht);
	}
    // sets y gets
	public void setHorasTrabajadas(double horas){
		if (horas < MIN_HORAS) horasTrabajadas = MIN_HORAS;
		else if (horas > MAX_HORAS) horasTrabajadas = MAX_HORAS;
		else horasTrabajadas = horas;
	}
	public double getHorasTrabajadas(){
		return horasTrabajadas;
	}
	@Override
	public double salario(){
		return getHorasTrabajadas()*SALARIO_POR_HORA;
	}
	
	// Implementacion de la interfaz Precario
	public double indiceDePrecariedad(){
		return salario() / salarioSiJornadaCompleta();
	}
	public double salarioSiJornadaCompleta(){
		return HORAS_JORNADA_COMPLETA * SALARIO_POR_HORA;
	}
	
	// toString()
	public String toString(){
		return String.format("%s[horasTrabajadas: %s, indicePrecariedad: %.2f]\n", 
				super.toString(), getHorasTrabajadas(), indiceDePrecariedad());
	}


}
