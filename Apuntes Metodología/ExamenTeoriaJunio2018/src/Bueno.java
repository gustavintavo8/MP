
public abstract class Bueno extends Personaje{
	private static final int PUNTOS = 8;
	
	public Bueno(String ne) { 	
		super(ne,PUNTOS);
	}
	
	public void actuar(Personaje [] vP) {}
	
	public String toString() {
		return String.format("[Bueno - %s]", super.toString());
	}
}
