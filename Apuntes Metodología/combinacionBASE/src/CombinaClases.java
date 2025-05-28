
public class CombinaClases {

	public static void main(String[] args) {

		CommissionEmployee[] v1 = { new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06),
				new CommissionEmployee("Miguel", "Rguez", "222-22-2222", 12121, .07),
				new CommissionEmployee("Samuel", "Rguez", "222-22-2222", 15400, .05),
				new CommissionEmployee("Peter", "Jones", "222-22-2222", 18000, .04), };

		BasePlusCommissionEmployee v2[] = {
				new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 1000),
				new BasePlusCommissionEmployee("Miguel", "Rguez", "333-33-3333", 4000, .05, 1500),
				new BasePlusCommissionEmployee("Samuel", "Rguez", "333-33-3333", 1000, .05, 3500),
				new BasePlusCommissionEmployee("Gonzalo", "Torre", "333-33-3333", 2000, .04, 2500), };

		CommissionEmployee[] v3 = new CommissionEmployee[v1.length + v2.length];
		introducir(v1, v2, v3);
		muestra(v3);
		ordenar(v3);
		muestra(v3);
		

	}

	private static void muestra(CommissionEmployee[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.println(v[i].toString());
			System.out.println(i + 1); // Control de trabajadores
		}
	}

	private static void introducir(CommissionEmployee[] v1, BasePlusCommissionEmployee[] v2, CommissionEmployee[] v3) {
		for (int i = 0; i < v1.length; i++) {
			v3[i] = v1[i];
		}
		for (int j = v1.length; j < v3.length; j++) {
			for (int k = 0; k < v2.length; k++) {
				v3[j] = v2[k];
			}
		}
	}

	private static void ordenar(CommissionEmployee[] v3) {
		CommissionEmployee tmp;
		for (int x = 0; x < v3.length; x++) {
			for (int y = x + 1; y < v3.length; y++) {
				if (v3[x].earnings() > v3[y].earnings()) {
					tmp = v3[y];
					v3[y] = v3[x];
					v3[x] = tmp;
				}
			}
		}
	}

	private static void muestraCPCE(BasePlusCommissionEmployee[] v1) {
		for (int i = 0; i < v1.length; i++) {
			System.out.println("\n" + v1[i]);
		}
	}

	private static void muestraCE(CommissionEmployee[] v1) {
		for (int i = 0; i < v1.length; i++) {
			System.out.println("\n" + v1[i]);
		}

	}
}
