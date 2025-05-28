
// Clase que permite representar vectores dinamicos de enteros (int)
//   Incluye operaciones como insert, remove, set, get, ...

public class VectorDinamicoEnteros {
	// representacion de los datos
	private int [] datos;

	private int longitud; // distinto a datos.length
	
	private static final int MINIMO = 4; // capacidad minima
	
	private static final int INCREMENTO = 2;
	
	private static final int C1 = 4; // 1/C1 es limite para redimensionar a la baja
	
	
	// observadores de longitud y capacidad
	public int capacity(){ 
		return (datos==null) ? 0 : datos.length;
	}
	
	public int length(){
		return longitud;
	}
	
	// Constructores
	public VectorDinamicoEnteros(){
		datos = new int [MINIMO];
		longitud = 0;
	}
	
	public VectorDinamicoEnteros(VectorDinamicoEnteros vDE){
		datos = new int[vDE.capacity()];
		for (int i=0; i<vDE.length(); i++)
			datos[i] = vDE.get(i);	
		longitud = vDE.length();
	}
	
	public VectorDinamicoEnteros(int size){
		datos = new int [Math.max(size,MINIMO)];
		longitud = 0;
	}
	
	public VectorDinamicoEnteros(int [] v){
		if (v==null) {
			datos = new int [MINIMO]; // la capacidad como minimo MINIMO
			longitud = 0;
		}
		else{
			longitud = v.length; // longitud = capacidad
			datos = new int [Math.max(v.length*INCREMENTO, MINIMO)]; // capacidad = v.length
			for (int i = 0; i<length(); i++)
				datos[i] = v[i];
		}
	}
	
	public boolean isEmpty(){
		return length() == 0;
	}
	
	public int get(int p){
		if(p < longitud && p >= 0)
			return datos[p];
		else{
			// generar un error
			System.err.println("Posicion no valida");
			return -1;
		}
	}
	
	public void muestra(){
		System.out.println("\nVectorDinamicoEnteros");
		System.out.printf("Longitud: %d", length());
		System.out.printf(" Capacidad: %d", capacity());
		System.out.print("\nDatos: ");
		for(int i = 0; i<length(); i++)
			System.out.printf(" %d", datos[i]);
		System.out.println();
	}
	
	public int posicion(int x) { // posicion de la primera aparicion de x, -1 si no esta
		int i=0;
		while (i<length()){
			if (get(i) == x) return i;
			i++;
		}
		return -1;
	}
	
	public boolean member(int x) {
		return posicion(x) != -1;
	}
	
	//Modificadores
	public void set(int p, int x){
		if (p < length() && p >= 0)
			datos[p] = x;
		else
			System.err.println("Posicion no valida");
	}

	public void add(int x) { // a�ade al final
        insert(length(),x);
	}

	
	public void insert(int p, int x){ 
		if (length() == capacity()){ // si esta lleno el vector
			// redimensionar al doble
			int [] temp = new int[capacity()*INCREMENTO];

			for (int i = 0; i<p; i++) // copiamos los valores previos a la posici�n i
				temp[i] = datos[i];
			
			temp[p] = x; //  se fija el nuevo valor insertado

			for (int i = p+1; i<=longitud; i++) //desplazamos solo los valores realmente ocupados
				temp[i] = datos[i-1];

			datos = temp;
		} else {
			for (int i = longitud; i > p;i--) //desplazamos solo los valores realmente ocupados (desde el final al inicio)
				datos[i] = datos[i-1];

			datos[p] = x; 
	
		}
		// longitud
		longitud++;
	}
	
	
	public void push(int x){
		insert(0,x);
	}
		
	public void erase(){
		datos = new int [MINIMO]; // la capacidad como minimo MINIMO
		longitud = 0;
	}
	
	
	public void remove(int p) { 
		// elimina el int de la posicion p y desplaza los sgtes. a la izda.
		// si la longitud baja a la 1/C1 parte de la capacidad se redimensiona a longitud * INCREMENTO
		if ( capacity() == MINIMO || length() > capacity() / C1){
			for (int i = p; i<length(); i++ )
				datos[i] = datos[i+1];		
		} else {
			// hay que redimensionar
			int [] temp = new int[Math.max(MINIMO,length()*INCREMENTO)];
			for (int i = 0; i<p; i++)
				temp[i] = datos[i];
			for (int i = p; i < length()-1; i++)
				temp[i] = datos[i+1];
			datos = temp;
		}
		longitud = longitud - 1;
	}
	
	public int pop(){
		if (isEmpty()){
			System.err.println("\nVector vacio!!");
			return -1;
		} else {
			int x = datos[0];
			remove(0);
			return x;
		}
	}
	
}
