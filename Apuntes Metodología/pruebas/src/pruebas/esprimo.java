package pruebas;

public class esprimo {

	public static void main(String[]args) {
		float n = 29473;
		for (int i = 2; i < n; i++) {
			//System.out.println("Prueba con: 29473/" + i);
			if(n%i==0) {
				System.out.println("YEAH");
			}
			else {
				System.out.println("");
			}
		}
	}
}
