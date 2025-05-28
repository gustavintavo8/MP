
public class Listo extends Bueno implements Enfadado{
	private boolean estaEnfadado;
	
	public Listo(String ne) {
		super(ne);
		estaEnfadado = false;
	}
	
	public int defender(Personaje p) {
		super.defender(p);
		if (estaEnfadado())
			contraatacar(p);
		else estaEnfadado = true;
		return getPuntos();
	}
	
	private void contraatacar(Personaje p) {
		int x = p.defender(this);
		if (x==0) {
			setPuntos(getPuntos()+5);
		}
	}
	
	public boolean estaEnfadado() {
		return estaEnfadado;
	}
	
	public String toString() {
		return String.format("[Listo - %s estaEnfadado: %s]", super.toString(), (estaEnfadado ? "si" : "no"));
	}

}
