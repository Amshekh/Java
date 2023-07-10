package finance;

@ReducingBalance
public class PersonalLoan implements LoanPolicy{

	@MaxDuration(4)
	public float interestRate(double p, int n){
		return (p <= 50000) ? 10.5f : 11.5f;
	}
	
	public float interestRateForEmployees(double p, int m){
		return 9.0f;
	}
}












