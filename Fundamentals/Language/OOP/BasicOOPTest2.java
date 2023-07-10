import payroll.Employee;

class BasicOOPTest2{

	private static double getIncomeTax(Employee emp){
		double i = emp.getNetIncome();
		return i > 10000 ? 0.15 * (i - 10000) : 0;
	}

	public static void main(String[] args){
		Employee jack = new Employee();
		jack.setHours(186);
		jack.setRate(53);
		System.out.printf(
			"Jack's ID is %d, Income is %.2f and Tax is %.2f%n", 
			jack.getId(), jack.getNetIncome(), getIncomeTax(jack));
		Employee jill = new Employee(175, 65);
		System.out.printf(
			"Jill's ID is %d, Income is %.2f and Tax is %.2f%n", 
			jill.getId(), jill.getNetIncome(), getIncomeTax(jill));
		System.out.printf("Number of employees: %d%n", 
			Employee.countEmployees());
	}
}







