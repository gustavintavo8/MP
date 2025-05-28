import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LecturaFicherosDeTextoTest {

	public static void main(String[] args) {
		Scanner in = null;
		String nombreFichero = "censoPerrosPeligrosos.txt";
		try {
			in = new Scanner(new FileInputStream(nombreFichero));

			while(in.hasNext()){
				// 1 - Ejecuta tal cual está el programa
				// 2 - Comenta la siguiente línea y descomenta una única línea de las siguientes en cada nueva ejecución
				System.out.println(in.nextLine());
				//System.out.println(in.next());
				//System.out.println(in.next() + '\t' + in.next()  + '\t' + in.nextInt()  + '\t' + in.next()  + '\t' + in.nextInt());
				//System.out.println(in.next() + ' ' + in.next()  + ' ' + in.nextInt()  + ' ' + in.next()  + ' ' + in.nextInt());
			}
			
		} catch(IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (in!=null) in.close();
		}

	}
}
