// Fig. 9.7: BasePlusCommissionEmployeeTest.java
// BasePlusCommissionEmployee test program.

public class BasePlusCommissionEmployeeTest {
	public static void main(String[] args) {
		// instantiate BasePlusCommissionEmployee object
		BasePlusCommissionEmployee employee[] = new BasePlusCommissionEmployee[4];
		employee[0] = new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 1000);
		employee[1] = new BasePlusCommissionEmployee("Miguel", "Rguez", "333-33-3333", 4000, .05, 1500);
		employee[2] = new BasePlusCommissionEmployee("Samuel", "Rguez", "333-33-3333", 1000, .05, 3500);
		employee[3] = new BasePlusCommissionEmployee("Gonzalo", "Torre", "333-33-3333", 2000, .04, 2500);
		
		System.out.printf("More Earnings go to:\n %s", (moreEarnings(employee)).toString());
		
		imprimirBPCE(employee);
		System.out.println("Después de ordenar ->");
		ordenarBPCE(employee);
		imprimirBPCE(employee);
		
	} // end main
	
	private static BasePlusCommissionEmployee moreEarnings(BasePlusCommissionEmployee v[]) {
		BasePlusCommissionEmployee tmp= v [0];
		for (int i = 1; i < v.length; i++) {
			if (tmp.earnings() < v[i].earnings()) 
				tmp = v[i];
		}
		return tmp;
	}
	
	private static void imprimirBPCE(BasePlusCommissionEmployee v[]) {
		for (int i = 0; i < v.length; i++) {
			System.out.println("\n" + v[i].getFirstName() 
					+ ": " + v[i].earnings());
		}
	}
	
	private static void ordenarBPCE(BasePlusCommissionEmployee v[]) {
		BasePlusCommissionEmployee tmp;
		for (int i = 0; i < (v.length - 1); i++) {
			for (int j = i + 1; j < v.length; j++) {
				if(v[i].earnings() > v[j].earnings()) {
					tmp = v[i];
					v[i] = v[j];
					v[j] = tmp;
				}
			}
		}
	}
} // end class BasePlusCommissionEmployeeTest

