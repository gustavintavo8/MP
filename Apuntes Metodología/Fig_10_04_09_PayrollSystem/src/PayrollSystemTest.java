import java.io.ObjectInputStream.GetField;

// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.

public class PayrollSystemTest {
	public static void main(String[] args) {
		// create subclass objects
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
				"444-44-4444", 5000, .04, 300);
		/*
		 * System.out.println("Employees processed individually:\n");
		 * 
		 * System.out.printf("%s\n%s: $%,.2f\n\n", salariedEmployee, "earned",
		 * salariedEmployee.earnings()); System.out.printf("%s\n%s: $%,.2f\n\n",
		 * hourlyEmployee, "earned", hourlyEmployee.earnings());
		 * System.out.printf("%s\n%s: $%,.2f\n\n", commissionEmployee, "earned",
		 * commissionEmployee.earnings()); System.out.printf("%s\n%s: $%,.2f\n\n",
		 * basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
		 */
		// create four-element Employee array
		Employee[] employees = new Employee[4];

		// initialize array with Employees
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		/*
		 * System.out.println("Employees processed polymorphically:\n");
		 * 
		 * // POLIMORFISM: generically process each element in array employees for
		 * (Employee currentEmployee : employees) { System.out.println(currentEmployee);
		 * // invokes toString
		 * 
		 * // determine whether element is a BasePlusCommissionEmployee if
		 * (currentEmployee instanceof BasePlusCommissionEmployee) { // downcast
		 * Employee reference to // BasePlusCommissionEmployee reference
		 * BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee)
		 * currentEmployee;
		 * 
		 * employee.setBaseSalary(1.10 * employee.getBaseSalary());
		 * 
		 * System.out.printf("new base salary with 10%% increase is: $%,.2f\n",
		 * employee.getBaseSalary()); } // end if
		 * 
		 * System.out.printf("earned $%,.2f\n\n", currentEmployee.earnings()); } // end
		 * for
		 * 
		 * // get type name of each object in employees array for (int j = 0; j <
		 * employees.length; j++) System.out.printf("Employee %d is a %s\n", j,
		 * employees[j].getClass().getName());
		 */
		muestra(employees);
		System.out.print(masGana(employees));
		ordenar(employees);
		muestra(employees);
		changeCommissionRate(employees, 0.1, 0);
	} // end main

	/**
	 * @param employees un vector de trabajadores
	 * @param inc lo que hay que incrementar commissionRate 
	 * @param aQuien entero que indica a quienes hay que cambiar /
	 * el valor: 0 a todos los que tienen este dato, 1 solo a los /*
	 * de la clase CommissionEmployee,
	 *  2 solo a los de la clase  BasePlusCommissionEmployee
	 */
	public static void changeCommissionRate( Employee[] employees, double inc, int toWhom){

		for (Employee e : employees) {
			if (toWhom == 0 && !(e instanceof HourlyEmployee || e instanceof SalariedEmployee)) {
				((CommissionEmployee) e).setCommissionRate(((CommissionEmployee) e).getCommissionRate() + inc);
			} else if (toWhom == 1 && e instanceof CommissionEmployee) {
				((CommissionEmployee) e).setCommissionRate(((CommissionEmployee) e).getCommissionRate() + inc);
			} else if (toWhom == 2 && e instanceof BasePlusCommissionEmployee) {
				((CommissionEmployee) e).setCommissionRate(((CommissionEmployee) e).getCommissionRate() + inc);
			}
		}
	}

	private static void muestra(Employee[] employees) {
		for (Employee e : employees) {
			System.out.println(e.toString() + "\n");
		}
	}

	private static void ordenar(Employee[] v3) {
		Employee tmp;
		for (int x = 0; x < v3.length; x++) {
			for (int y = x + 1; y < v3.length; y++) {
				if (v3[x].earnings() < v3[y].earnings()) {
					tmp = v3[y];
					v3[y] = v3[x];
					v3[x] = tmp;
				}
			}
		}

	}

	private static double masGana(Employee[] employees) {
		Employee tmp = employees[0];
		for (Employee e : employees) {
			if (tmp.earnings() < e.earnings())
				tmp = e;
		}
		return tmp.earnings();
	}
} // end class PayrollSystemTest
