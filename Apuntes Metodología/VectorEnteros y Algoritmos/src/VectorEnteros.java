
// Clase que permite representar vectores de enteros (int)
//   Incluye operaciones como set, get, length, ...

public class VectorEnteros {

	// representacion de los datos
	private int [] datos;
	
	// Constructores
	
	/**constructor por defecto*/
	public VectorEnteros(){  // constructor por defecto
		datos = null;
	}

	/**
	 * constructor de copia
	 * @param vDE vector a replicar
	 */
	public VectorEnteros(VectorEnteros vDE){ // constructor de copia
		datos = new int[vDE.length()];
		for (int i=0; i<datos.length; i++)
			datos[i] = vDE.get(i);
	}
	
	/**
	 * constructor a partir del tama�o del vector
	 * @param size tama�o del vector
	 */
	public VectorEnteros(int size){ 
		datos = new int [size];
		for (int i = 0; i < datos.length; i++)
			datos[i] = 0;
	}
	
	/**
	 * constructor a partir de un array est�tico de Java
	 * @param v array est�tico de java a duplicar
	 */
	public VectorEnteros(int [] v){
		if (v==null) datos = null;
		else{
			datos = new int [v.length];
			for (int i = 0; i<datos.length; i++)
				datos[i] = v[i];
		}
	}
	
	// Observadores
	
	/**
	 * Observador de la longitud del vector
	 * @return la longitud del vector
	 */
	public int length() {
		if (datos == null) return 0;
		else return datos.length;
	}
	
	/**
	 * Observador que comprueba si el vector tiene tama�o nulo
	 * @return cierto si el vector tiene tama�o nulo y falso en otro caso
	 */
	public boolean isEmpty(){
		return length() == 0;
	}
	
	/**
	 * observador de los elementos del vector 
	 * @param i posicion del elemento
	 * @return elemento en dicha posici�n
	 */
	public int get(int i){
		return datos[i];
	}
	
	@Override
	/**
	 * Versi�n texto del vector
	 */
	public String toString(){
		String s;
		s= "[ ";
		for(int i = 0; i<length(); i++)
			s += datos[i] + " "; 
		s += "]";
		
		return s;
	}
	
	/**
	 * Observador que muestra por consola el vector
	 */
	public void muestra(){
		System.out.println("\nVectorEnteros");
		System.out.printf("Longitud: %d", length());
		System.out.print("\nDatos: ");
		for(int i = 0; i<length(); i++)
			System.out.printf(" %d", datos[i]);
		System.out.println();
	}
	
	
	//Modificadores
	
	/**
	 * Modifica el valor de un elemento del vector
	 * @param i posici�n del elemento
	 * @param x nuevo valor del elemento
	 */
	public void set(int i, int x){
		datos[i] = x;
	}
		
}
