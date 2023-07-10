import payroll.*;

class BasicOOPTest4{

	private static double getAverageIncome(Employee[] group){
		double total = 0;
		for(Employee emp : group){
			total += emp.getNetIncome();
		}
		return total / group.length;
	}

	private static double getTotalSales(Employee[] group){
		double total = 0;
		for(Employee emp : group){
			//if(emp.getId() == 103 || emp.getId() == 105){
			if(emp instanceof SalesPerson){
				SalesPerson slp = (SalesPerson) emp;
				total += slp.getSales();
			}
		}
		return total;
	}

	public static void main(String[] args){
		Employee[] dept = {
			new Employee(186, 52),
			new Employee(175, 65),
			new SalesPerson(185, 55, 60000),
			new Employee(190, 250),
			new SalesPerson(170, 60, 40000)
		};
		System.out.printf("Average income: %.2f%n", 
			getAverageIncome(dept));
		System.out.printf("Total sales: %.2f%n", 
			getTotalSales(dept));
	}
}







