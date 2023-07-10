package finance;

public class EducationLoan implements LoanPolicy{
	
	@MaxDuration
	public float interestRate(double p, int n){
		return 7.0f;
	}
}












