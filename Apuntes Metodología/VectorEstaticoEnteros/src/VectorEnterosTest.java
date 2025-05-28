// Programa de prueba del la clase VectorEnteros

public class VectorEnterosTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos un vector a partir de un array estatico
		int [] v = {1,2,3,4,5};
		//int [] v = null;
		VectorEnteros vE1 = new VectorEnteros(v);
		vE1.muestra();
		
		//vDE[2]=26; Esto nos gustar�a
		vE1.set(2, 26);
		vE1.muestra();
		
		vE1.set(1, vE1.get(2)+10);
		vE1.muestra();
		
		// mostrando via toString()
		System.out.println(vE1);
		
		
		// Ahora algunos algoritmos interesantes (Implementados con metodos estaticos de la clase ...Test)

		VectorEnteros vE2 = new VectorEnteros(new int[] {7,3,6,5,26,36,4});
		System.out.println("Vector2:" + vE2);
		
		// 1.- Comprobar si un valor est� presente en el vector
		System.out.print("El elemento 5 ");
		if (member(vE2,5)) 
			System.out.print("s�");
		else
			System.out.print("no");
		System.out.println(" pertenece al vector");
		
		System.out.println("El elemento 8 "+ (member(vE2,8)?"s�":"no") + " pertenece al vector");
		
		// 2.- Obtener la posici�n en el vector de la primera aparici�n de un valor dado ( o -1 si no existe dicho valor)
		System.out.println("Posici�n de 6 en el vector: " + posicion(vE2, 6));
		System.out.println("Posici�n de 12 en el vector: " + posicion(vE2, 12));
		
		// 3.- Obtener el m�ximo elemento del vector
		int max = buscaMaximo(vE2);
		System.out.println("El m�ximo es: " + max);
		
		// 4.- Ordenar los elementos del vector en orden creciente 
		ordenaVector(vE2);
		System.out.println("Despu�s de ordenar:" + vE2);

		
				
		// 5.- Comprobar si todos los elementos de un VDE estan contenidos en otro VDE
		
		//boolean h = estaContenido(vE1,vE2);
		
		//System.out.println(h);
		
		
		// 6.- Comprobar si un vector esta ordenado
		
		//boolean h1 = estaOrdenado(vDE);
			
		// 7.- Comprobar si un VDE ordenado contiene a un entero x (busqueda dicotomica) y en caso afirmativo que devuelva una posicon
		//      en la que aparece x
		
		//int pos = busquedaDicotomica(23,vDE);
		//System.out.println(pos);
		
		// 8.- Dados dos VDEs, indicar si los valores del primero aparecen en el segundo en el mismo orden y de forma 
		//      consecutiva a partir de alguna posicion del segundo. En caso afirmativo, retornar la posicion de la primera
		//      aparaicion
		
		//int pos1 = esSubVector(vDE1,vDE2);
		
		// . . . 
	}

	// Implementacion de los metodos . . .

	/**
	 * Verifica si un elemento est� presente en el vector
	 * @param v vector de enteros	
	 * @param x valor a buscar
	 * @return cierto si encuentra el valor y falso en otro caso
	 */
	public static boolean member(VectorEnteros v, int x) {
		return false;

	}

	/**
	 * Localiza la primera ocurrencia de un elemento en el vector
	 * @param v vector de enteros	
	 * @param x valor a localizar
	 * @return la posici�n de la primera aparici�n del valor a buscar, o -1 si no est�
	 */
	public static int posicion(VectorEnteros v, int x) {
		return 0; 

	}

	
	/**
	 * Busca el m�ximo elemento de un vector no nulo de enteros 
	 * @param v vector de enteros
	 * @return el valor maximo 
	 */
	private static int buscaMaximo(VectorEnteros v) {
		return 0;
	}

	/**
	 * ordena los elementos de un vector de enteros en orden creciente
	 * @param v vector a ordenar
	 */
	private static void ordenaVector(VectorEnteros v) {

	}
	

	
	
	//. . . . .

}
