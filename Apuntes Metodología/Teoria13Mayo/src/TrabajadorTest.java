
public class TrabajadorTest {

	public static void main(String[] args) {
		
		TrabajadorFijo t1 = new TrabajadorFijo("Pepe Fijo","33456527M", 2000.0, 450.0);
		TrabajadorFijo t2 = new TrabajadorFijo("Ana Fijo","09876527J", 3000.0, 1500.0);
		TrabajadorFijoTiempoParcial t3 = 
				new TrabajadorFijoTiempoParcial("Luis Fijo Parcial","1984563S", 1000.0, 150.0, 0.65);
		TrabajadorFijoTiempoParcial t4 = 
				new TrabajadorFijoTiempoParcial("Maria Fijo Parcial","8965437R", 1500.0, 250.0, 0.55);
		TrabajadorPorHoras t5 = new TrabajadorPorHoras("Antonio Por Horas","09876527J", 18.0);
		TrabajadorPorHoras t6 = new TrabajadorPorHoras("Jose Por Horas","8976549K", 12.0);
		TrabajadorPorHorasConIncentivo t7 = 
				new TrabajadorPorHorasConIncentivo("Juan Por Horas Incentivo","9983543J", 15.0, 500.0);
		TrabajadorPorHorasConIncentivo t8 = 
				new TrabajadorPorHorasConIncentivo("Marta Por Horas Incentivo","5434329M", 11.0, 700.0);
		
		Trabajador [] vT = {t1, t2, t3, t4, t5, t6, t7, t8};
		// Otros casos de prueba:
		//Trabajador [] vT = {t2, t1, t3, t4, t5, t6, t7, t8};
		//Trabajador [] vT = {t1, t2, t3, t4, t5, t6, t8, t7};
		//Trabajador [] vT = {t1, t8};
		//Trabajador [] vT = {t8};
		//Trabajador [] vT = {t5, t4};
		//Trabajador [] vT = {};
		//Trabajador [] vT = null;
		
		muestraTodos(vT);
		
		System.out.format("Indice Precariedad Empresa: %.2f\n", indiceDePrecariedadEmpresa(vT));
		
		System.out.format("Numero Trabajadores Precarios con Incentivo: %d\n", trabajadoresPrecariosConIncentivo(vT));
		
		System.out.format("Numero Salarios Minimos Relativos: %d\n", salariosMinimosRelativos(vT));

	}
	
	// Muestra todos los trabajadores del vector
	public static void muestraTodos(Trabajador [] vT){
		System.out.println("\nLista de trabajadores de la Empresa: \n");
		if (vT == null) return;
		for (Trabajador t: vT)
			System.out.println(t.toString());
	}

	// Calculo del indice de precariedad de la empresa
	public static double indiceDePrecariedadEmpresa(Trabajador [] vT){
		if (vT == null) return 0.0;
		double indice = 0.0;
		for (Trabajador t: vT)
			if (t instanceof Precario) indice += ((Precario)t).indiceDePrecariedad();
		return (vT.length == 0 ? 0.0 : indice / vT.length);
	}
	
	// Numero de trabajadores precarios con incentivo
	public static int trabajadoresPrecariosConIncentivo(Trabajador [] vT){
		if (vT == null) return 0;
		int n = 0;
		for (Trabajador t: vT)
			if (t instanceof Precario && t instanceof Incentivo) n++;
		return n;
	}
	
	// Numero de salarios minimos relativos en el vector vT
	public static int salariosMinimosRelativos(Trabajador [] vT){
		if (vT == null) return 0;
		double x1 = 0.0, x2 = 0.0, x3 = 0.0;
		int nMin = 0;
		// Implementacion con un automata de 4 estados
		int estado = 0;
		// Cada componente t del vector vT representa un impulso
		for (Trabajador t: vT){
			switch (estado) {
			case 0: estado = 1; 
					x3 = t.salario(); 
					break;
			case 1: estado = 2;
					x2 = x3; 
					x3 = t.salario(); 
					if (x2 < x3) nMin++;
					break;
			case 2: estado = 3;
			case 3: x1 = x2;
					x2 = x3; 
					x3 = t.salario();
					if (x2 < x1 && x2 < x3) nMin++;			
			}
		}
		// Si el estado final es 1, 2 o 3, hay que terminar de contar
		switch (estado) {
		case 1: nMin++; // solo hay uno y es minimo
				break;
		case 2: // si hay 2 y el ultimo es menor que el primero
		case 3: // hay mas de dos y el ultimo es menor que el anterior
				if (x2 > x3) nMin++;			
		}
		return nMin;
	}
}
