
public abstract class Personaje {
	private String nombre;
	private int puntos;
	
	public Personaje(String ne, int pt) {
		nombre = ne;
		puntos = pt;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setPuntos(int pt) {
		puntos = Math.max(0,pt);
	}
	public int getPuntos() {
		return puntos;
	}
	
	public int defender(Personaje p) {
		setPuntos(Math.max(0,getPuntos()-1));
		return getPuntos();
	}
	
	public abstract void actuar(Personaje [] vP);

	public String toString() {
		return String.format("[Nombre: %s Puntos: %d]", getNombre(), getPuntos());
	}
}
