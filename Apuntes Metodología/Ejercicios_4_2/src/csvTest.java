import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class csvTest {
	static final String NOMBRE_FICHERO_IN1 = "EmpresasGijón.csv";// Entrada1
	static final String NOMBRE_FICHERO_OUT1 = "EmpresasGijón.txt";// Salida1
	static final String NOMBRE_FICHERO_IN2 = "EmpresasGijón.txt";// Entrada1
	static final String NOMBRE_FICHERO_OUT2 = "EmpresasGijónbis.csv";// Salida1

	public static void main(String[] args) {
		try {
			leeCSV(NOMBRE_FICHERO_IN1, NOMBRE_FICHERO_OUT1);
			System.out.println("Completada la primera parte del trabajo");

			escribeCSV1(NOMBRE_FICHERO_IN2, NOMBRE_FICHERO_OUT2);
			System.out.println("Completada la segunda parte del trabajo");
		} catch (Exception e) {
			System.out.println();
		} finally {
			System.out.println("finiquitao");
		}
	}

	public static void escribeCSV(String nombreFicheroIn, String nombreFicheroOut) {
		final String NEXT_LINE = "\n";
		final String DELIMITER = ";";
		// COMPLETAR
		Scanner in = null;
		// Formatter out = null;
		FileWriter fw = null;
		int i = 0;
		try {
			in = new Scanner(new FileInputStream(nombreFicheroIn));
			// out = new Formatter(nombreFicheroOut);
			fw = new FileWriter(nombreFicheroOut);
			while (in.hasNext()) {
				String s = in.nextLine();
				String s2 = trataEspacios(s.substring(0, 14 - 1));
				String s3 = trataEspacios(s.substring(14, 28 - 1));
				String s4 = trataEspacios(s.substring(28, 37 - 1));
				String s5 = trataEspacios(s.substring(37, 79 - 1));
				String s6 = trataEspacios(s.substring(79));
				// String n = s.substring(14, 28-1);
				// System.out.println(n);

				if (i == 0) {
					i++;
				} // no imprimir la primera linea del txt}

				else {
					fw.append(s2).append(DELIMITER);
					fw.append(s3).append(DELIMITER);
					fw.append(s4).append(DELIMITER);
					fw.append(s5).append(DELIMITER);
					fw.append(s6);
					fw.append(NEXT_LINE);
				}
			}
			fw.flush();
			fw.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null)
				in.close();
		}

	}

	public static void leeCSV(String nombreFicheroIn, String nombreFicheroOut) throws IOException {// COMPLETAR

		BufferedReader in = null;
		Formatter out = null;
		String cvsSplitBy = ",";
		String line = " ";
		String datos[] = new String[5];

		try {
			in = new BufferedReader(new FileReader(nombreFicheroIn));
			out = new Formatter(nombreFicheroOut);

			out.format("%-14d%13d%9d%42d%9d\n", 14, 13, 9, 42, 9);
			// in.useDelimiter(",|/r/n");
			while ((line = in.readLine()) != null) {
				datos = line.split(cvsSplitBy);
				out.format("%-14s%13s%9s%42s%9s\n", datos[0], datos[1], datos[2], datos[3], datos[4]);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}

	}

	public static void leeCSV1(String nombreFicheroIn, String nombreFicheroOut) throws IOException {
		Scanner in = null;
		Formatter out = null;
		try {
			in = new Scanner(new FileInputStream(nombreFicheroIn));
			out = new Formatter(nombreFicheroOut);
			in.useDelimiter(",|\r\n");
			out.format("%-14s%13s%9s%42s%8s\n", 14, 13, 9, 42, 9);
			String s1, s2, s3, s4, s5;
			while (in.hasNext()) {
				s1 = in.next();
				s2 = in.next();
				s3 = in.next();
				s4 = in.next();
				s5 = in.next();
				out.format("%-14s%13s%9s%42s%9s\n", s1, s2, s3, s4, s5);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

	public static void escribeCSV1(String nombreFicheroIn, String nombreFicheroOut) throws FileNotFoundException{
		// declaramos las variables fichero
		Scanner in = null;
		Formatter dos = null;
		try {	
			// creamos los objetos fichero, y por tanto se abren...
			in = new Scanner(new FileInputStream(nombreFicheroIn)); // ... para leer desde in
			dos = new Formatter(nombreFicheroOut); // ... para escribir en dos

			// Lee los tamaños de las 5 columnas que están en la primera línea
			int n1,n2,n3,n4,n5;
			n1=in.nextInt(); 
			n2=in.nextInt();
			n3=in.nextInt();
			n4=in.nextInt();
			n5=in.nextInt();
			// System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+n5);
			in.nextLine();//Salta de línea( el anterior nexInt leyó el último entero en la línea y quedó delante del \n)

			// Y después las líneas con los datos 
			String linea,s1,s2,s3,s4,s5;	
			while(in.hasNextLine()){
				// leemos una línea completa
				linea=in.nextLine();
				// troceamos los tokens por el ancho conocido y tratamos los espacios en blanco que contengan 
				s1=linea.substring(0,n1);
				s1=trataEspacios(s1); 
				
				s2=linea.substring(n1,n1+n2);
				s2=trataEspacios(s2); 

				s3=linea.substring(n1+n2,n1+n2+n3);
				s3=trataEspacios(s3); 

				s4=linea.substring(n1+n2+n3,n1+n2+n3+n4);
				s4=trataEspacios(s4); 

				s5=linea.substring(n1+n2+n3+n4,n1+n2+n3+n4+n5); 
				s5=trataEspacios(s5);								

				// volcamos la información al fichero de salida separada por ";" 
				dos.format("%s;%s;%s;%s;%s\n",s1,s2,s3,s4,s5);		
			}
		} catch (FileNotFoundException e) {
			// se captura la excepción, se muestra el mensaje 
			System.err.println("Excepción en escribeCSV(): " + e.getMessage());
			// y se vuelve a lanzar la excepción (que capturará el main() )
			throw e;
		}
		finally {
			if (dos != null)
				dos.close();
			if(in!=null)
				in.close();
		}
	}

	/**
	 * Elimina los espacios en blanco de un string. Los que son consecutivos e
	 * intermedios a caracteres no blancos los sustituye por un '_'. El algoritmo
	 * está programado utilizando la técnica basada en autómatas
	 * 
	 * @param un string s con espacios en blanco
	 * @return otro string en el que se eliminan los espacios anteriores y
	 *         posteriores y se sustituyen los internos por un '_'
	 */
	public static String trataEspacios(String s) {
		String salida = "";
		int estado = 0;
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			switch (estado) {
			case 0:
				if (c != ' ') {
					salida = salida + c;
					estado = 1;
				}
				break;
			case 1:
				if (c != ' ')
					salida = salida + c;
				else
					estado = 2;
				break;
			case 2:
				if (c != ' ') {
					salida = salida + '_' + c;
					estado = 1;
				}
			}
		}
		return salida;

	}

	// Otra opción que va bien en este caso dado que solo hay un blanco
	// entre dos palabras consecutivas
	// String trataEspacios(String s) {
	// return s.trim().replace(' ', '_');
	// }

}
