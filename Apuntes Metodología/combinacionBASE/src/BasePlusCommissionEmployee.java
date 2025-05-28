// Fig. 9.6: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class represents an employee that receives
// a base salary in addition to commission.

public class BasePlusCommissionEmployee extends CommissionEmployee {

	private double baseSalary; // base salary per week

	// six-argument constructor
	public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double salary) {
		// implicit call to Object constructor occurs here
		super(first, last, ssn, sales, rate);
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
	public double earnings() {
		return baseSalary + (this.getCommissionRate() * this.getGrossSales());
	} // end method earnings

	@Override // indicates that this method overrides a superclass method
	public String toString() {
		return String.format("%s %n%s: %f%n", super.toString(), "base salary", baseSalary);
	} // end method toString

} // end class BasePlusCommissionEmployee
