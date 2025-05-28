
public class ConjuntoDeEnteros {
	
	VectorDinamicoEnteros datos;

	// Constructores
	public ConjuntoDeEnteros() {
		datos=new VectorDinamicoEnteros();
	}

	public ConjuntoDeEnteros(ConjuntoDeEnteros c) {
		datos = new VectorDinamicoEnteros(c.datos);
	}

	public ConjuntoDeEnteros(int[] v) {
		datos=new VectorDinamicoEnteros(v.length);
		for (int x: v) {
			datos.adjoin(x);
		}
	}

	// Metodos observadores y modificadores
	public void adjoin(int x) {
		if (!member(x)) datos.add(x);
	}

	public boolean member(int x) {
		return datos.member(x);
	}
	public boolean esVacio(ConjuntoDeEnteros c) {
		return datos.length()==0; //si el numero de datos es cero
	}

	public boolean subset(ConjuntoDeEnteros c) {
		return false;
	}

	public ConjuntoDeEnteros union(ConjuntoDeEnteros c) {
		
		return null;
	}

	public ConjuntoDeEnteros intersection(ConjuntoDeEnteros c) {
		return null;
	}

	public ConjuntoDeEnteros setDifference(ConjuntoDeEnteros c) {
		return null;
	}

	public String toString() {
		return null;
	}

}
