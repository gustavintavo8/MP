// Fig. 9.5: CommissionEmployeeTest.java
// CommissionEmployee class test program.

public class CommissionEmployeeTest {
	public static void main(String[] args) {
		// instantiate CommissionEmployee object
		CommissionEmployee employee[] = new CommissionEmployee[4];
		employee[0] = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);
		employee[1] = new CommissionEmployee("Miguel", "Rguez", "222-22-2222", 12121, .07);
		employee[2] = new CommissionEmployee("Samuel", "Rguez", "222-22-2222", 15400, .05);
		employee[3] = new CommissionEmployee("Peter", "Jones", "222-22-2222", 18000, .04);

		CommissionEmployee employeeMoreSalary = employee[0];
		for (int i = 1; i < employee.length; i++) {
			if (employeeMoreSalary.earnings() < employee[i].earnings())
				employeeMoreSalary = employee[i];
		}
		System.out.println("MAYOR");
		System.out.println("Name:" + employeeMoreSalary.getFirstName() + 
				"Last Name: " + employeeMoreSalary.getLastName());
		System.out.println("Earnings: " + employeeMoreSalary.earnings());
		
		CommissionEmployee tmp= null;
		for (int i = 0 ; i < (employee.length - 1) ; i++) {
			for (int j = i + 1; j < employee.length ; j++) {
				if (employee[i].earnings() > employee[j].earnings()) {
					tmp = employee[i];
					employee[i] = employee[j];
					employee[j] = tmp;
				}
				
			} 
		}
		imprimirVectorCommision(employee);
	
	} // end main
	
	private static void imprimirVectorCommision (CommissionEmployee v[]) {
		for (int i = 0; i < v.length; i++) {
			System.out.println((i+1) +"º Nombre: "+ v[i].getFirstName() 
					+ ". Ganancias: " + v[i].earnings());
		}
	}
} // end class CommissionEmployeeTest
