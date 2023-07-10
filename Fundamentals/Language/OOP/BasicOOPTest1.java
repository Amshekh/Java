class BasicOOPTest1{

	public static void main(String[] args){
		payroll.Employee jack = new payroll.Employee();
		jack.setHours(186);
		jack.setRate(53);
		System.out.printf("Jack's ID is %d and Income is %.2f%n", 
			jack.getId(), jack.getNetIncome());
		payroll.Employee jill = new payroll.Employee(175, 65);
		System.out.printf("Jill's ID is %d and Income is %.2f%n", 
			jill.getId(), jill.getNetIncome());
	}
}

