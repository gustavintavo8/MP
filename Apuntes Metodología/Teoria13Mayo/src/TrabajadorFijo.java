
public class TrabajadorFijo extends Trabajador implements Incentivo {
	
	
	private double sueldoFijo;
	private double incentivo;

	public TrabajadorFijo(String ne, String ni, double sf, double in){
		super(ne,ni);
		setSueldoFijo(sf);
		setIncentivo(in);
	}
	
	// sets y gets 
	public void setSueldoFijo(double sf){
		sueldoFijo = sf;
	}
	public void setIncentivo(double in){
		incentivo = in;
	}
	public double getSueldoFijo(){
		return sueldoFijo;
	}
	public double getIncentivo(){ // Interfaz Incentivo
		return incentivo;
	}
	@Override
	public double salario() {
		return getSueldoFijo() + getIncentivo();
	}
	
	// toString()
	public String toString(){
		return String.format("%s[sueldoFijo: %s, incentivo: %s]\n", 
				super.toString(), getSueldoFijo(), getIncentivo());
	}

}
