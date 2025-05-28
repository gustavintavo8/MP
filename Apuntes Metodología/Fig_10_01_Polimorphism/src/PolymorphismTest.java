import java.util.Iterator;

public class PolymorphismTest {
	public static void main(String[] args) {
		// assign superclass reference to superclass variable
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);

		// assign subclass reference to subclass variable
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
				"333-33-3333", 5000, .04, 300);

		// invoke toString on superclass object using superclass variable
		//System.out.printf("%s %s:\n\n%s\n\n", "Call CommissionEmployee's toString with superclass reference ",
		//		"to superclass object", commissionEmployee.toString());

		// invoke toString on subclass object using subclass variable
		//System.out.printf("%s %s:\n\n%s\n\n", "Call BasePlusCommissionEmployee's toString with subclass",
		//	"reference to subclass object", basePlusCommissionEmployee.toString());

		// POLIMORFISM: invoke toString on subclass object using superclass variable
		CommissionEmployee commissionEmployee2 = basePlusCommissionEmployee;
		//System.out.printf("%s %s:\n\n%s\n", "Call BasePlusCommissionEmployee's toString with superclass",
		//		"reference to subclass object", commissionEmployee2.toString());

		CommissionEmployee[] vector = { commissionEmployee, basePlusCommissionEmployee,
				new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 1000),
				new BasePlusCommissionEmployee("Miguel", "Rguez", "333-33-3333", 4000, .05, 1500),
				new BasePlusCommissionEmployee("Samuel", "Rguez", "333-33-3333", 1000, .05, 3500),
				new BasePlusCommissionEmployee("Gonzalo", "Torre", "333-33-3333", 2000, .04, 2500),
				new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06),
				new CommissionEmployee("Miguel", "Rguez", "222-22-2222", 12121, .07),
				new CommissionEmployee("Samuel", "Rguez", "222-22-2222", 15400, .05),
				new CommissionEmployee("Peter", "Jones", "222-22-2222", 18000, .04), };
		//mostrarVectorCompleto(vector);
		ordenarVector(vector);
		mostrarVectorCompleto(vector);

	} // end main
	
	private static void mostrarVectorCompleto(CommissionEmployee[] vector) {
		for (CommissionEmployee e: vector) {
			System.out.println(e.toString());
		}
		
	}
	private static void ordenarVector(CommissionEmployee[] v3) {
		CommissionEmployee tmp;
		for (int x = 0 ; x < v3.length ; x++) {
			for (int y = x + 1; y < v3.length ; y++) {
				if (  v3[x].earnings() < v3[y].earnings()) {
					tmp = v3[y];
					v3[y] = v3[x];
					v3[x] = tmp;
				}
			}
		}
		
	}

	
} // end class PolymorphismTest
