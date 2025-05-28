/**
 * Prácticas de Metodología de la Programación. Jeroquest - Un ejemplo de
 * Programación orientada a objetos. Programa principal
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @version 1
 *
 */

public class JeroquestTest {

	public static void main(String[] args) {

		Barbaro heroes[] = new Barbaro[10];
		Momia monsters[] = new Momia[10];
		Enano enano[] = new Enano[10];
		int RONDAS = 50;

		/*
		 * Ari Asbjorn Asgeir
		 * Ramesses II, Yuya, Masaharta
		 */
		for (int i = 0; i < 10; i++) {
			heroes[i] = new Barbaro("Dalla_" + i);
			monsters[i] = new Momia("Nodjmet_" + i);
			enano[i] = new Enano("Thorin_"+ i);
		}
		// partida1(heroes, monsters, RONDAS);
		partida2(heroes, monsters, RONDAS);

	}

	private static void partida2(Barbaro vectorBarbaros[], Momia vectorMomias[], int RONDAS) {
		int impactos; // Variable tmp
		Momia momiaAtack; // Varaible tmp
		Barbaro barbaroAtack;
		int longVector = vectorMomias.length;

		for (int i = 0; i < RONDAS && momiasVivas(vectorMomias) && barbarosVivas(vectorBarbaros); i++) {
			System.out.println("ROUND NUMBER:" + (i + 1));

			for (int j = 0; j < longVector; j++) {
				momiaAtack = momiaMViva(vectorMomias);
				if (vectorBarbaros[j].estaVivo() && momiaAtack.estaVivo()) {
					impactos = vectorBarbaros[j].atacar();
					momiaAtack.defender(impactos);
				}
				barbaroAtack = barbaroMViva(vectorBarbaros);
				if (barbaroAtack.estaVivo() && vectorMomias[j].estaVivo()) {
					impactos = vectorMomias[j].atacar();
					barbaroAtack.defender(impactos);
				}
			}

		}

	}
	
	private static void partida1(Barbaro b[], Momia m[], int RONDAS) {
		int impactos; // Variable tmp
		int whoAtack; // Varaible tmp
		int longVector = m.length;

		for (int i = 0; i < RONDAS && momiasVivas(m) && barbarosVivas(b); i++) {
			System.out.println("ROUND NUMBER:" + (i + 1));

			for (int j = 0; j < longVector; j++) {
				whoAtack = Dado.tira(longVector) -1;
				if (b[j].estaVivo() && m[whoAtack].estaVivo()) {
					impactos = b[j].atacar();
					m[whoAtack].defender(impactos);
				}
				whoAtack = Dado.tira(longVector)-1;
				if (b[whoAtack].estaVivo() && m[j].estaVivo()) {
					impactos = m[j].atacar();
					b[whoAtack].defender(impactos);
				}
			}

		}

	}

	private static Momia momiaMViva(Momia momias[]) {
		Momia tmp = momias[0];
		for (int i = 1; i < momias.length ; i++) {
			if (tmp.getCuerpo() < momias[i].getCuerpo())
				tmp = momias[i];
		}
		return tmp;
	}

	private static Barbaro barbaroMViva(Barbaro barbaros[]) {
		Barbaro tmp = barbaros[0];
		for (int i = 1; i < barbaros.length; i++) {
			if (tmp.getCuerpo() < barbaros[i].getCuerpo())
				tmp = barbaros[i];
		}
		return tmp;

	}

	private static boolean momiasVivas(Momia m[]) {
		for (int i = 0; i < m.length; i++) {
			if (m[i].estaVivo())
				return true;
		}
		return false;
	}

	private static boolean barbarosVivas(Barbaro b[]) {
		for (int i = 0; i < b.length; i++) {
			if (b[i].estaVivo())
				return true;
		}
		return false;
	}

}
