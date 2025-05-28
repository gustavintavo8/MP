import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class PerrosPeligrososTest2 {

	public static void main(String[] args) {
		String nombreFicheroEntrada = "censoPerrosPeligrosos.txt";
		String nombreFicheroSalida = "4_1pruebas.txt";
		VectorDinamicoStrings v = ordenaRaza(nombreFicheroEntrada);
		imprime1(v, nombreFicheroEntrada);
		razasEnFichero(v, nombreFicheroEntrada, nombreFicheroSalida);
		diagrama(nombreFicheroSalida, "Diagrama.txt");
	}

	public static VectorDinamicoStrings ordenaRaza(String nameFichero) {
		VectorDinamicoStrings v = new VectorDinamicoStrings();
		Scanner in = null;
		String Tamano = " ";
		String barrio = " ";
		int cantidad = 0;
		int cp = 0;
		try {
			in = new Scanner(new FileInputStream(nameFichero));
			String raza = " ";
			while (in.hasNext()) {
				raza = in.next();
				Tamano = in.next();
				cp = in.nextInt();
				barrio = in.next();
				cantidad = in.nextInt();
				v.add(raza);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (in != null)
				in.close();
		}
		// se ordena
		for (int i = 0; i < v.length() - 1; i++) {
			for (int j = i + 1; j < v.length(); j++) {
				if (v.get(i).compareTo(v.get(j)) > 0) {
					String tmp = " ";
					tmp = v.get(i);
					v.set(i, v.get(j));
					v.set(j, tmp);
				}
			}
		}
		// elimina duplicados
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < v.length() - 1; i++) {
				if (v.get(i).equals(v.get(i + 1))) {
					v.remove(i + 1);
				}
			}
		}

		return v;
	}

	public static void razasEnFichero(VectorDinamicoStrings v, String perros, String salida) {
		int lv = v.length();
		int cantidad[] = new int[lv];
		String raza[] = new String[lv];

		for (int i = 0; i < lv; i++) {
			cantidad[i] = 0;
			raza[i] = v.get(i);
		}
		String nameraza = " ";
		String Tamano = " ";
		String barrio = " ";
		int total = 0;
		int cp = 0;
		int posicion = 0;
		boolean found = false;

		Scanner in = null;
		try {
			in = new Scanner(new FileInputStream(perros));
			while (in.hasNext()) {
				posicion = 0;
				found = false;
				nameraza = in.next();
				Tamano = in.next();
				cp = in.nextInt();
				barrio = in.next();
				total = in.nextInt();
				while (posicion < lv && !found) {
					if (raza[posicion].equals(nameraza))
						found = true;
					else
						posicion++;
				}
				cantidad[posicion] = cantidad[posicion] + total;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}

		// System.out.println("Segunda parte");
		Formatter out = null;
		try {
			out = new Formatter(salida);
			int i = 0;
			while (i < lv) {
				out.format("%s:\t%d\n", raza[i], cantidad[i]);
				// System.out.println(raza[i] + ": " +cantidad[i]);
				i++;
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
		}
		System.out.println("\n\n \t\t2nd successful process");

	}

	public static void imprime1(VectorDinamicoStrings v, String name) {
		System.out.println("\n\n\n#########################################\n\t\tLISTA RAZAS");
		for (int i = 0; i < v.length(); i++) {
			System.out.println(i + 1 + "_:" + v.get(i));
		}
		System.out.println("\n#########################################");
	}
	public  static void diagrama1(String nombreFicheroEntrada,String nombreFicheroSalida) {
//		declarmos las varibles fichero
		Scanner in = null;
		Formatter dos=null;
		
		try {
			String raza;
			int cantidad,centenas,unidades;
			
			// creamos los objetos fichero y por tanto abrimos los ficheros
			in = new Scanner(new FileInputStream(nombreFicheroEntrada));
			dos = new Formatter(nombreFicheroSalida);
			
			while(in.hasNext()) { // mientras haya datos por leer
				raza=in.next(); // leemos la raza
				cantidad=in.nextInt(); // leemos la cantidad
				// calculamos centenas y resto de la cantidad
				centenas=cantidad/100;
				unidades=cantidad%100;

				// escribimos la raza y el diagrama de sus unidades
				dos.format("%-32s ",raza);
				for(int j=0;j<centenas;j++)
					dos.format("C");
				for(int j=0;j<unidades;j++) 
						dos.format("*");
				dos.format("(%d)\n",cantidad);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// cerramos los ficheros
			if(in!=null)
				in.close();
			if(dos!=null)
				dos.close();
		}
	}

	public static void diagrama(String nombreFicheroEntrada, String nombreFicheroSalida) {
		Scanner in = null;
		Formatter out = null;
		String nameraza = " ";
		int cantidad = 0;
		int cc = 0; // centenas
		int n = 0;
		try {
			in = new Scanner(new FileInputStream(nombreFicheroEntrada));
			out = new Formatter(nombreFicheroSalida);
			while (in.hasNext()) {
				cc = 0;
				nameraza = in.next();
				cantidad = in.nextInt();
				if (cantidad >= 100) {
					cc = cantidad / 100;
				}
				out.format("%-40s", nameraza);

				for (int i = 0; i < cc; i++) {
					out.format("C");
				}
				// System.out.println(nameraza + "->" + cantidad);
				n = cantidad - cc * 100;
				for (int i = 0; i < n; i++) {
					out.format("*");
				}
				out.format("(%d)\n", cantidad);

			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
		System.out.println("\n\n \t\t3th successful process");
	}
	
	public static  void razasEnFichero1	(VectorDinamicoStrings vRazas, String nombreFicheroEntrada,String nombreFicheroSalida) {
		// definimos las variables fichero
		Scanner in = null;
		Formatter dos = null;
		try {	

			String razaLeida,razaVector;
			int cantidad;
			int[] numeroEjemplares= new int[vRazas.length()];//Vector que acumulará el número de ejemplares por raza, estarán 
			// en el mismo orden que el vector de entrada.

			// se crea y abre el fichero de entrada
			in = new Scanner(new FileInputStream(nombreFicheroEntrada));
			

			while(in.hasNext()){
				// Leemos los tokens de la siguiente línea
				razaLeida=in.next();  // Se lee el primer token, la raza
				for(int j=0;j<3;j++)//Salta los tres siguientes  de tokens
					in.next();
				cantidad = in.nextInt();//Se lee como entero el útimo token de la línea

				int i = 0;
				while((i < vRazas.length()) && !vRazas.get(i).equals(razaLeida))
					i++;

				if (i < vRazas.length())
					numeroEjemplares[i] += cantidad;
				else 
					throw new Exception("La raza "+razaLeida+" no está en el vector de razas");
			}
			
			// se crea y abre el fichero de salida
			dos = new Formatter(nombreFicheroSalida);
			for(int i=0;i<vRazas.length();i++) 
				dos.format("%s\t%d\n",vRazas.get(i),numeroEjemplares[i]); //Se fomatea y graba cada caso de raza y número de ejemplares	
		}
		catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println("Error detectado: " + e.getMessage());
		}
		finally {
			// cerramos los ficheros
			if(in!=null)
				in.close();
			if(dos!=null)
				dos.close();
		}
	}	
}
