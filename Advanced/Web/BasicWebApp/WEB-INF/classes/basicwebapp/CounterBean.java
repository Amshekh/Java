package basicwebapp;

public class CounterBean implements java.io.Serializable{
	
	private long count;
	private long step;

	public CounterBean(){
		count = 0;
		step = 1;
	}
	
	public long getStep(){
		return step;
	}

	public void setStep(long value){
		step = value;
	}
		
	public synchronized long getNextCount(){
		return count += step;
	}

}

/*
This is a Java-Bean component.

Requirnments for Bean :-
	that class (Bean class) should be serialized.
	Class must support zero-parameter constructor.
	It must expose properties using method which follow standard get/set naming convention.
*/