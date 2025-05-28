
public class ExamenJunio2018_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listo Pepe = new Listo("Pepe");
		Tonto Juan = new Tonto("Juan");
		Malo Luis = new Malo("Luis");
		
		// Los vemos
		System.out.println(Pepe.toString() + "\n" + Juan.toString() + "\n" + Luis.toString());
		
		Personaje [] vP = {Pepe, Juan, Luis};
		
		juegaPartida(vP,1000); // 3 rondas
		
		// Los vemos
		System.out.println("\n" + Pepe.toString() + "\n" + Juan.toString() + "\n" + Luis.toString());
	}
	
	private static void juegaPartida(Personaje[] vP, int nr) {
		// TODO Auto-generated method stub
		int i = 1;
		while ((i<nr) && sePuedeSeguir(vP)) {
			//Nueva ronda, la i
			for (int j =0; j<vP.length; j++) {
				vP[j].actuar(vP);
			}
			i++;
		}
	}
	
	private static boolean sePuedeSeguir(Personaje[] vP) {
		// Se puede seguir si se cumplen las propiedades:
		// 1.- Los enfadados son menos de la mitad
		// 2.- Quedan al menos 2 personajes con puntos
		// 3.- Queda algun malo vivo (con puntos)
		boolean quedaMalo = false;
		int quedanConPuntos = 0; 
		int enfadados = 0;
		for (Personaje p: vP) {
			if (p instanceof Enfadado && ((Enfadado)p).estaEnfadado()) enfadados++;
			if (p.getPuntos()>0) {
				quedanConPuntos++;
				quedaMalo = quedaMalo || p instanceof Malo;
			}
		}
		return (quedaMalo && quedanConPuntos > 2) && enfadados < vP.length/2;	
	}

}
