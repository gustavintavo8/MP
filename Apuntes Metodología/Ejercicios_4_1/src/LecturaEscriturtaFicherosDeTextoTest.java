import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class LecturaEscriturtaFicherosDeTextoTest {

	public static void main(String[] args) {
		Scanner in = null;
		Formatter out = null;
		String nombreFicheroEntrada = "censoPerrosPeligrosos.txt";
		String nombreFicheroSalida = "Salida2.txt";
		try {
			in = new Scanner(new FileInputStream(nombreFicheroEntrada));
			out = new Formatter(nombreFicheroSalida);

			while(in.hasNext()){
				//out.format(in.nextLine() + '\n');
				//out.format("%s\n", in.nextLine());
				//out.format("%s\t%s\t%d\t%s\t%d\n", in.next(), in.next(), in.nextInt(), in.next(), in.nextInt());
				out.format("%40s%20s%20d%30s%20d\n", in.next(), in.next(), in.nextInt(), in.next(), in.nextInt());
				//out.format("%-40s%-20s%-20d%-30s%-20d\n", in.next(), in.next(), in.nextInt(), in.next(), in.nextInt());	
			}
			
		} catch(IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (in!=null) in.close();
			if (out !=null) out.close();
		}

	}
}
