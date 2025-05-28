
public class TrabajadorFijoTiempoParcial extends TrabajadorFijo implements Precario {
	
	private static final double  MIN_JORNADA = 0.25;
	private static final double  MAX_JORNADA = 0.75;
	
	private double jornada;
	
	public TrabajadorFijoTiempoParcial(String ne, String ni, double sf, double in, double jo){
		super(ne,ni,sf,in);
		setJornada(jo);
	}
	
	// sets y gets
	public void setJornada(double jo){
		if (jo < MIN_JORNADA) jornada = MIN_JORNADA;
		else if (jo > MAX_JORNADA) jornada = MAX_JORNADA;
		else jornada = jo;
	}
	public double getJornada(){
		return jornada;
	}
	
	// sobreescribe salario
	@Override
	public double salario(){
		return getJornada()*getSueldoFijo() + getIncentivo();
	}
	
	// Implementacion de la interfaz Precario
	public double indiceDePrecariedad(){
		return salario() / salarioSiJornadaCompleta();
	}
	private double salarioSiJornadaCompleta(){
		return super.salario();
	}
	
	// toString()
	public String toString(){
		return String.format("%s[jornada: %s, indicePrecariedad: %.2f]\n", 
				super.toString(), getJornada(), indiceDePrecariedad());
	}

}
