
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Perrostest2_2 {

	public static void main(String[] args) {
		String nombreFicheroEntrada = "censoPerrosPeligrosos.txt";
		String nombreFicheroSalida = "2pruebas.txt";
		VectorDinamicoStrings v = ordenaRaza(nombreFicheroEntrada);
		razasEnFichero(v, nombreFicheroEntrada, nombreFicheroSalida);
		diagrama(nombreFicheroSalida, "Diagrama.txt");
	}


	private static void diagrama(String nombreFicheroSalida, String string) {
		String raza = "";
		int cantidad = 0;
		int centenas = 0;
		Scanner in = null;
		Formatter out = null;
		try {
			in = new Scanner(new FileInputStream(nombreFicheroSalida));
			out = new Formatter(string);
			while (in.hasNext()) {
				raza = in.next();
				cantidad = in.nextInt();
				centenas = cantidad / 100;
				out.format("%s:", raza);
				if (centenas > 0) {
					for (int i = 0; i < centenas; i++) {
						out.format("C");
					}
					for (int i = 0; i < cantidad % 100; i++) {
						out.format("*");
					}
				} else {
					for (int i = 0; i < cantidad; i++) {
						out.format("*");
					}
				}
				out.format("(" + cantidad + ")\n");
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

	private static void razasEnFichero(VectorDinamicoStrings v, String nombreFicheroEntrada,
			String nombreFicheroSalida) {
		Scanner in = null;
		Formatter out = null;
		int[] cantidad = new int[v.length()];
		String[] vRaza = new String[v.length()];
		for (int i = 0; i < vRaza.length; i++) {
			vRaza[i] = v.get(i);
		}
		String raza = " ";
		int cantidad1 = 0;
		boolean found;
		int i;
		try {
			in = new Scanner(new FileInputStream(nombreFicheroEntrada));
			out = new Formatter(nombreFicheroSalida);
			while (in.hasNext()) {
				found = false;
				i = 0;
				raza = in.next();
				in.next();
				in.next();
				in.next();
				cantidad1 = in.nextInt();
				while (!found && i < v.length()) {
					if (vRaza[i].equals(v.get(i))) {
						cantidad[i] += cantidad1;
						found = true;
					} else {
						i++;
					}
				}
				for (int j = 0; j < vRaza.length; j++) {
					out.format("%s:\t%d\n", v.get(j), cantidad[j]);
				}
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

	private static VectorDinamicoStrings ordenaRaza(String nombreFicheroEntrada) {
		VectorDinamicoStrings v = new VectorDinamicoStrings();
		Scanner in = null;
		String raza = "";
		try {
			in = new Scanner(new FileInputStream(nombreFicheroEntrada));
			while (in.hasNext()) {
				raza = in.next();
				in.nextLine();
				int i = 0;
				while (i < v.length() && raza.compareTo(v.get(i)) > 0) {
					i++;
				}
				if (i == v.length() || raza.compareTo(v.get(i)) < 0) {
					v.insert(i, raza);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (in != null)
				in.close();
		}
		return v;
	}

}
