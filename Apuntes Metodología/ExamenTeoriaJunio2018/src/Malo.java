
public class Malo extends Personaje implements Enfadado{
	private static final int PUNTOS = 4;
	private boolean estaEnfadado;
	
	public Malo(String ne) {
		super(ne, PUNTOS);
		estaEnfadado = false;
	}
	
	@Override
	public int defender(Personaje p) {
		if (estaEnfadado()) setPuntos(Math.max(0, getPuntos()-2));
		else {
			 super.defender(p);
			 estaEnfadado = true;
		}
		return getPuntos();
	}
	
	public int atacar(Personaje p) {
		if (p.getPuntos()>0) {
		    int x = p.defender(this);
		    if (x==0) {
		    	setPuntos(getPuntos()+10);
				estaEnfadado = false;
		    }
		}
		return getPuntos();
	}
	
	public void actuar(Personaje [] vP) {
		if (getPuntos()>0) {
			int k = Dado.tira(vP.length)-1;
			while (vP[k] == this) k = Dado.tira(vP.length)-1;
			atacar(vP[k]);
		}
	}
	
	// Interfaz Enfadado
	public boolean estaEnfadado() {
		return estaEnfadado;
	}
	
	@Override
	public String toString() {
		return String.format("[Malo - %s estaEnfadado: %s]", super.toString(), (estaEnfadado ? "si" : "no"));
	}

}
