// Programa de prueba del la clase VectorEnteros

public class VectorEnterosTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos un vector a partir de un array estatico
		int[] v = { 1, 2, 3, 4, 5 };
	
		// int [] v = null;
		VectorEnteros vE1 = new VectorEnteros(v);
		vE1.muestra();

		// vDE[2]=26; Esto nos gustar’a
		vE1.set(2, 26);
		vE1.muestra();

		vE1.set(1, vE1.get(2) + 10);
		vE1.muestra();

		// mostrando via toString()
		System.out.println(vE1);

		// Ahora algunos algoritmos interesantes (Implementados con metodos estaticos de
		// la clase ...Test)

		VectorEnteros vE2 = new VectorEnteros(new int[] { 7, 3, 6, 5, 26, 36, 4 });
		System.out.println("Vector2:" + vE2);

		// 1.- Comprobar si un valor está presente en el vector
		System.out.print("El elemento 5 ");
		if (member(vE2, 5))
			System.out.print("sí");
		else
			System.out.print("no");
		System.out.println(" pertenece al vector");

		System.out.println("El elemento 8 " + (member(vE2, 8) ? "sí" : "no") + " pertenece al vector");

		// 2.- Obtener la posición en el vector de la primera aparición de un valor dado
		// ( o -1 si no existe dicho valor)
		System.out.println("Posición de 6 en el vector: " + posicion(vE2, 6));
		System.out.println("Posición de 12 en el vector: " + posicion(vE2, 12));

		// 3.- Obtener el máximo elemento del vector
		int max = buscaMaximo(vE2);
		System.out.println("El máximo es: " + max);

		// 4.- Ordenar los elementos del vector en orden creciente
		ordenaVector(vE2);
		System.out.println("Después de ordenar:" + vE2);

		// 5.- Comprobar si todos los elementos de un VDE estan contenidos en otro VDE
		System.out.println("vE1 contenido en vE2?");
		VectorEnteros vE3 = new VectorEnteros(new int[] { 7, 3, 6, 5, 26, 36, 4 });
		VectorEnteros vE4 = new VectorEnteros(new int[] { 7, 3, 6, 5, 26, 36, 4 });
		boolean h = estaContenido(vE3, vE4);

		System.out.println(h);

		// 6.- Comprobar si un vector esta ordenado

		boolean h1 = estaOrdenado(vE3);

		// 7.- Comprobar si un VDE ordenado contiene a un entero x (busqueda dicotomica)
		// y en caso afirmativo que devuelva una posicon
		// en la que aparece x

		int pos = busquedaDicotomica(23,vE3);
		System.out.println(pos);

		// 8.- Dados dos VDEs, indicar si los valores del primero aparecen en el segundo
		// en el mismo orden y de forma
		// consecutiva a partir de alguna posicion del segundo. En caso afirmativo,
		// retornar la posicion de la primera
		// aparaicion
		vE1.muestra();
		int pos1 = esSubVector(vE1,vE2);

		// . . .
	}


	// Implementacion de los metodos . . .
	
	
	private static int esSubVector(VectorEnteros v1, VectorEnteros v2) {
		if (v1.length() > v2.length()) return -1;
		int pos = posicion(v2, v1.get(0));
		if (pos == -1) return -1;
		else {
			for (int i = 0; i < v1.length(); i++) {
				if(v1.get(i) != v2.get(pos + i)) return -1;
			}
		}
		
		return pos;
	}
	/* 
	 * Encuentra la posicion de un numero en un vector
	 * @param i valor a buscar
	 * @param vE3 vector de enteros
	 */
	private static int busquedaDicotomica(int i, VectorEnteros vE3) {
		ordenaVector(vE3);
		return posicion(vE3, i);
	}
	
	/*
	 * @param v vector de enteros
	 */
	private static boolean estaOrdenado(VectorEnteros v) {
		for (int i = 1; i < v.length(); i++) {
			if (v.get(i-1) > v.get(i)) return false;
		}
		return true;
	}
	/*
	 * Verifica si un VDE esta en otro VDE
	 * @param vE1 vector de enteros
	 * @param vE2 vector de enteros
	 * y en el mismo orden
	 */
	private static boolean estaContenido(VectorEnteros vE1, VectorEnteros vE2) {
		int t1 = vE1.length();
		int t2 = vE2.length();
		if(t2 >= t1) {//comprobamos que el segundo vector pueda contener al primero
			int x = 0;
			for (int i = 0; i < t2; i++) {
				if(x == t1) return true; //si se han encontrado todos los elementos se retorna true
				if(vE1.get(x) == vE2.get(i)) //Si los elementos coinciden x++ desplanzandonos en el vE1
					x++;
				else // sino volvemos al inicio de vE1
					x = 0;
			}
			return x == t1;
		}
		else 
			return false;

	}
	/**
	 * Verifica si un elemento está presente en el vector
	 * @param v vector de enteros
	 * @param x valor a buscar
	 * @return cierto si encuentra el valor y falso en otro caso
	 */
	public static boolean member(VectorEnteros v, int x) {
		if (v.length() == 0) return false;
		for (int i = 0; i < v.length(); i++) {
			if (v.get(i) == x)
				return true;
		}
		return false;

	}

	/**
	 * Localiza la primera ocurrencia de un elemento en el vector
	 * @param v vector de enteros
	 * @param x valor a localizar
	 * @return la posición de la primera aparición del valor a buscar, o -1 si no
	 *         está
	 */
	public static int posicion(VectorEnteros v, int x) {
		int i = 0;
		for (i = 0; i < v.length(); i++) {
			if (v.get(i) == x)
				return i;
		}
		return -1;
	}

	/**
	 * Busca el máximo elemento de un vector no nulo de enteros
	 * @param v vector de enteros
	 * @return el valor maximo
	 */
	private static int buscaMaximo(VectorEnteros v) {
		int max = v.get(0);
		for (int i = 1; i < v.length(); i++) {
			if (max < v.get(i))
				max = v.get(i);
		}
		return max;
	}

	/**
	 * ordena los elementos de un vector de enteros en orden creciente
	 * @param v vector a ordenar
	 */
	private static void ordenaVector(VectorEnteros v) {
		int tmp = 0;
		for (int i = 0; i < (v.length() - 1); i++) {
			for (int j = (i + 1); j < v.length(); j++) {
				if (v.get(i) > v.get(j)) {
					tmp = v.get(i);
					v.set(i, v.get(j));
					v.set(j, tmp);
				}
			}
		}
	}
}
