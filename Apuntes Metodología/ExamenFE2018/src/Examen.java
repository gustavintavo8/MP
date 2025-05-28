import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Examen {

	public static void main(String[] args) throws IOException, RuntimeException, Exception {
		Scanner t = new Scanner(System.in);
		String f1 = "BasurasPA10_13.txt";
		String f2 = "BasurasPA14.txt";
		String finale = "BasurasPA14FINALE.txt";
		crearFichero(f1, f2, finale);
		System.out.println(
				"Se ha creado el fichero de datos " + finale + " a partir de los ficheros " + f1 + " y " + f2 + "\n");
		System.out.println(
				"Seguidamente se procederá a mostrar por pantalla los datos ampliados del municipio que Ud. elija.\n");
		System.out.print("Introduzca el nombre del fichero de datos:");
		String file_one = t.next();
		System.out.print("Introduzca el nombre del municipio:");
		String municipio = t.next();

	}

	public static void crearFichero(String f1, String f2, String finale) throws Exception,IOException,RuntimeException{
		Scanner one = null;
		Scanner two = null;
		Formatter out = null;
		try {
			one = new Scanner(new FileInputStream(f1));
			two = new Scanner(new FileInputStream(f2));
			out = new Formatter(finale);
			out.format("%-20s%25s%25s%25s%25s\n", "<Nombre_Municipio>", "<Número_toneladas 2010>", "<Número_toneladas 2011>",
					"<Número_toneladas 2012>", "<Número_toneladas 2013>", "<Número_toneladas 2014>");
			String municipio;
			double c1, c2, c3, c4, c5;
			while (one.hasNext()) {
				municipio = one.next();
				c1 = one.nextDouble();
				c2 = one.nextDouble();
				c3 = one.nextDouble();
				c4 = one.nextDouble();
				c5 = two.nextDouble();
				if(c1<0 ||c2<0 ||c3<0 ||c4<0 ||c5<0) {//Se comprueba si se leyó un número negativo y se actúa consecuentemente
					throw new Exception("Encontrado número de toneladas negativo para el municipio: "+municipio);//Irá al main
				}
				out.format("%s %.2f %.2f %.2f %.2f %.2f\n", municipio,c1,c2,c3,c4,c5);
			}

		} catch (FileNotFoundException e1) {
			throw e1;
		} catch (IOException e) {
			throw e;
		} finally {
			if (one != null)
				one.close();
			if (two != null)
				two.close();
			if (out != null)
				out.close();
		}
	}

}
