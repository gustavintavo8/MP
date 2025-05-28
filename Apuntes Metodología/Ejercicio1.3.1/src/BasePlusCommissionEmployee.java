//Por composicion

public class BasePlusCommissionEmployee {

	private double baseSalary; // base salary per week
	private CommissionEmployee commissionEmployee;

	public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double baseSalary) {
		commissionEmployee = new CommissionEmployee(first, last, ssn, sales, rate);
		this.setBaseSalary(baseSalary);
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setFirstname(String name) {
		commissionEmployee.setFirstName(name);
	}
	
	public String getFirstname() {
		return commissionEmployee.getFirstName();
	}
	
	public void setLastName(String last) {
		commissionEmployee.setLastName(last);
	}


	public String getLastName() {
		return commissionEmployee.getLastName();
	}

	
	public void setSocialSecurityNumber(String ssn) {
		commissionEmployee.setSocialSecurityNumber(ssn); // should validate
	} 


	public String getSocialSecurityNumber() {
		return commissionEmployee.getSocialSecurityNumber();
	}

	// set gross sales amount
	public void setGrossSales(double sales) {
		commissionEmployee.setGrossSales(sales);
	} // end method setGrossSales

	// return gross sales amount
	public double getGrossSales() {
		return commissionEmployee.getGrossSales();
	} // end method getGrossSales

	// set commission rate
	public void setCommissionRate(double rate) {
		commissionEmployee.setCommissionRate(rate);
	} // end method setCommissionRate

	// return commission rate
	public double getCommissionRate() {
		return commissionEmployee.getCommissionRate();
	} // end method getCommissionRate

	// calculate earnings
	public double earnings() {
		return commissionEmployee.earnings() + this.getBaseSalary();
	} // end method earnings
	
	@Override
	public String toString() {
		return String.format("BasePlusCommissionEmployee: Base Salary= %f\n + %s", this.getBaseSalary(), this.commissionEmployee.toString());
	}

} // end class BasePlusCommissionEmployee
