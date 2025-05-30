// Fig. 9.8: BasePlusCommissionEmployee.java
// private superclass members cannot be accessed in a subclass.

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary; // base salary per week

	// six-argument constructor
	public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double salary) {
		// explicit call to superclass CommissionEmployee constructor
		// super( first, last, ssn, sales, rate );
		super();
		this.setFirstName(first);
		this.setLastName(last);
		this.setSocialSecurityNumber(ssn);
		this.setCommissionRate(rate);
		this.setGrossSales(sales);
		setBaseSalary(salary); // validate and store base salary
	} // end six-argument BasePlusCommissionEmployee constructor

	// set base salary
	public void setBaseSalary(double salary) {
		baseSalary = (salary < 0.0) ? 0.0 : salary;
	} // end method setBaseSalary

	// return base salary
	public double getBaseSalary() {
		return baseSalary;
	} // end method getBaseSalary

	// calculate earnings
	@Override // indicates that this method overrides a superclass method
	public double earnings() {
		// not allowed: commissionRate and grossSales private in superclass
		return getBaseSalary() + super.earnings();
	} // end method earnings

	// return String representation of BasePlusCommissionEmployee
	@Override // indicates that this method overrides a superclass method
	public String toString() {
		// not allowed: attempts to access private superclass members
		/*
		 * return String.format( "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f",
		 * "base-salaried commission employee", firstName, lastName,
		 * "social security number", socialSecurityNumber, "gross sales", grossSales,
		 * "commission rate", commissionRate, "base salary", baseSalary );
		 */
		return String.format("%s %n%s: %f%n", super.toString(), "base salary", baseSalary);
	} // end method toString
} // end class BasePlusCommissionEmployee

