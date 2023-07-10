package edu.met.adsd.banking;

public interface Profitable{

	/**
 	Adds interest to this account.
	@param period Duration for which interest is to be added.
	@return The added interest.
 	*/	
	double addInterest(int period);

	float MIN_RATE = 5.5f;
}



