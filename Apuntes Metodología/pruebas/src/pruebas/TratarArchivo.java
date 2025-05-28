package pruebas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TratarArchivo {

	// crea el archivo en disco, recibe como parámetro la lista de estudiantes
	public static void crearArchivo(Resguardo res) {
		FileWriter flwriter = null;
		try {
			// crea el flujo para escribir en el archivo
			Date fecha = new Date();

			// SimpleDateFormat dt = new SimpleDateFormat();
			// String name = dt.format(d);
			flwriter = new FileWriter("resguardoDonacion.txt");

			BufferedWriter bfwriter = new BufferedWriter(flwriter);

			bfwriter.write("\tBanco Moderdonia.\n" + "A día: " + fecha + "\nEl/La Sr/a:" + res.getNombre()
					+ res.getApellidos() + "\nHa donado en esta fecha la cantidad de:\n" + res.getCantidadAbonada()
					+ " €.\nEn " + res.getCp() 
					+ ". Número de Tarjeta: " + res.getnTarjeta()
					+ "\nGracias por su colaboración");

			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
