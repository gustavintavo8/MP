import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class PerrosPeligrososTest1 {

	public static void main(String[] args){
		Scanner in = null;
		Formatter out = null;
		String nombreFicheroEntrada = "censoPerrosPeligrosos.txt";
		String nombreFicheroSalida = "Salida.txt";
		int peq = 0, med = 0, grand = 0;
		String Tamano = " ";
		String barrio = " ";
		int cantidad = 0;
		int cp = 0;
		int linea=0;

		try {
			in = new Scanner(new FileInputStream(nombreFicheroEntrada));
			out = new Formatter(nombreFicheroSalida);
			// 33espaciospara la raza, 10 para el tamaño, 7 para el cp-código postal-, 25
			// para el barrioy3
			out.format("%-33s%-10s%-7s%-25s%-3s\n", "RAZA", "TAMAÑO", "CP", "BARRIO", "CANTIDAD");
			while (in.hasNext()) {
				out.format("%-33s", in.next()); // raza
				Tamano = in.next();
				cp = in.nextInt();
				barrio = in.next();
				cantidad = in.nextInt();
				out.format("%-10s%-7d%-25s%-3d\n", Tamano, cp, barrio, cantidad);
				linea++;
				if(cp > 33999 || cp <= 32999)
					try {
						throw new ExcepcionCP("Error");
					} catch (ExcepcionCP e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally {
						System.out.println("En la linea número: " + linea +
								" hay un error en el código postal");
					}

				if (Tamano.equals("Pequeño"))
					peq += cantidad;
				if (Tamano.equals("Mediano"))
					med += cantidad;
				if (Tamano.equals("Grande"))
					grand += cantidad;
			}
			out.format("En el fichero hay %d pequeños, %d medianos y %d grandes", peq, med, grand);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
		System.out.println("Proceso finalizado");
	}
}
