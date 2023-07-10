package finance;

@ReducingBalance public class HomeLoan implements LoanPolicy{

	@MaxDuration(value=12)
	public float interestRate(double p, int n){
		return (n <= 5) ? 9.5f : 10.0f;
	}
}












