import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Perrostest1_2 {
	public static void main(String[] args) throws ExcepcionCP {
		Scanner t = null;
		Formatter out = null;
		String nameInFile = "censoPerrosPeligrosos.txt";
		String nameOutFile = "Salida2.txt";
		String raza = " ";
		String size = " ";
		int cp = 0;
		String barrio = " ";
		int number = 0;
		int small = 0;
		int mediano = 0;
		int big = 0;
		try {
			t = new Scanner(new FileInputStream(nameInFile));
			out = new Formatter(nameOutFile);
			out.format("%-33s%-10s%-7s%-25s%-3s\n", "RAZA", "TAMAÑO", "CP", "BARRIO", "Nº");
			while (t.hasNext()) {
				raza = t.next();
				size = t.next();
				cp = t.nextInt();
				barrio = t.next();
				number = t.nextInt();
				out.format("%-33s%-10s%-7d%-25s%-3d\n", raza, size, cp, barrio, number);
				if(cp/1000 != 33) throw new ExcepcionCP("Erroe");
				if (size.equals("Pequeño"))
					small += number;
				if (size.equals("Mediano"))
					mediano += number;
				if (size.equals("Grande"))
					big += number;
			}
			out.format("Perros pequeños: %d, medianos: %d y grandes: %d", small, mediano, big);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (t != null)
				t.close();
			if (out != null)
				out.close();
		}
		System.out.println("Termino");

	}

}
