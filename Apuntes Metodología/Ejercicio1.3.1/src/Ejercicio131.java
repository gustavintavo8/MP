
public class Ejercicio131 {

	public static void main(String[] args) {

		CommissionEmployee[] vCE = { new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06),
				new CommissionEmployee("Miguel", "Rguez", "222-22-2222", 12121, .07),
				new CommissionEmployee("Samuel", "Rguez", "222-22-2222", 15400, .05),
				new CommissionEmployee("Peter", "Jones", "222-22-2222", 18000, .04), };

		BasePlusCommissionEmployee vBPCE[] = {
				new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 1000),
				new BasePlusCommissionEmployee("Miguel", "Rguez", "333-33-3333", 4000, .05, 1500),
				new BasePlusCommissionEmployee("Samuel", "Rguez", "333-33-3333", 1000, .05, 3500),
				new BasePlusCommissionEmployee("Gonzalo", "Torre", "333-33-3333", 2000, .04, 2500), };

		BasePlusCommissionEmployee[] v3 = new BasePlusCommissionEmployee[vCE.length + vBPCE.length];
		
		muestraCE(vCE);
		muestraBPCE(vBPCE);
		ordenarCE(vCE);
		ordenarBPCE(vBPCE);
		//introducir(vCE, vBPCE, v3);
		muestraordena(vCE,vBPCE);
		//ordenarBPCE(vBPCE);
		//muestraBPCE(vBPCE);
		

	}
	public static void muestraordena(CommissionEmployee[] v1, BasePlusCommissionEmployee[] v2) {
		ordenarBPCE(v2);
		ordenarCE(v1);
		//recorrer a la vez dos vectores y comparando el que menos gana 
		//mostrar menor undice acstual de v1 y v2 y avanzar en el que muestro
		for (int i = 0; i < v2.length - 1; i++) {
			for (int j = i + 1; j < v2.length; j++) {
				if(v1[i].earnings() < v2[i].earnings()) {System.out.println("MUESTRA" + v1[i].earnings());}
				else {System.out.println("Muestra el otro " + v2[i].earnings());}
			}
		}
	}
	/*
	private static void introducir(CommissionEmployee[] v1, BasePlusCommissionEmployee[] v2, BasePlusCommissionEmployee[] v3) {
		int length = v1.length - 1;
		for (int i = 0; i < v1.length; i++) {
			System.out.println(i);
			v3[i].setFirstname(v1[i].getFirstName());
			System.out.println(i);
			v3[i].setCommissionRate(v1[i].getCommissionRate());
			v3[i].setLastName(v1[i].getLastName());
			v3[i].setGrossSales(v1[i].getGrossSales());	
			v3[i].setSocialSecurityNumber(v1[i].getSocialSecurityNumber());
			v3[i].setBaseSalary(0.00);
		}
		for (int i = 0; i < v3.length; i++) {
			v3[i + length ]=v2[i];
		}
	}
	*/
	private static void ordenarCE(CommissionEmployee[] v3) {
		CommissionEmployee tmp = null;
		for (int x = 0; x < v3.length -1; x++) {
			for (int y = x + 1; y < v3.length; y++) {
				if (v3[x].earnings() > v3[y].earnings()) {
					tmp = v3[y];
					v3[y] = v3[x];
					v3[x] = tmp;
				}
			}
		}
	}
	
	private static void ordenarBPCE(BasePlusCommissionEmployee[] v3) {
		BasePlusCommissionEmployee tmp = null;
		for (int x = 0; x < (v3.length - 1); x++) {
			for (int y = x + 1; y < v3.length; y++) {
				if (v3[x].earnings() > v3[y].earnings()) {
					tmp = v3[y];
					v3[y] = v3[x];
					v3[x] = tmp;
				}
			}
		}
	}

	private static void muestraBPCE(BasePlusCommissionEmployee[] v1) {
		for (int i = 0; i < v1.length; i++) {
			System.out.println("\n" + v1[i].toString());
		}
	}

	private static void muestraCE(CommissionEmployee[] v1) {
		for (int i = 0; i < v1.length; i++) {
			System.out.println("\n" + v1[i].toString());
		}

	}
}
