
public class TrabajadorPorHorasConIncentivo extends TrabajadorPorHoras implements Incentivo {
	
	private double incentivo;

	public TrabajadorPorHorasConIncentivo(String ne, String ni, double ht, double in) {
		super(ne, ni, ht);
		setIncentivo(in);
	}
	
	//sets gets
	public void setIncentivo(double in){
		incentivo = (in >= 0 ? in : 0);
	}
	public double getIncentivo(){
		return incentivo;
	}
	
	// Salario sobreescrito
	@Override
	public double salario(){
		return super.salario() + getIncentivo();
	}
	
	// Interfaz Precario
	@Override
	public double salarioSiJornadaCompleta(){
		return super.salarioSiJornadaCompleta() + getIncentivo();
	}
	
	// toString()
	public String toString(){
		return String.format("%s[incentivo: %s]\n", 
				super.toString(), getIncentivo());
	}


}
