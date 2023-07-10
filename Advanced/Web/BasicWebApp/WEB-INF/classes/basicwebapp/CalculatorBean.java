package basicwebapp;

public class CalculatorBean implements java.io.Serializable{
	
	private double firstValue = 0;			// Here we are creating a variable which will be used from JSP.
	private double secondValue = 0;
	private String command = "Add";

	public double getFirstValue(){
		return firstValue;
	}

	public void setFirstValue(double value){
		firstValue = value;
	}

	public double getSecondValue(){
		return secondValue;
	}

	public void setSecondValue(double value){
		secondValue = value;
	}

	public String getCommand(){
		return command;
	}

	public void setCommand(String value){
		command = value;
	}

	public double getResult(){
		switch(command.charAt(0)){			// Check point 1.
			case 'A': return firstValue + secondValue;
			case 'S': return firstValue - secondValue;
			case 'M': return firstValue * secondValue;
			case 'D': return firstValue / secondValue;
		}
		return 0;
	}
}

/* Comments about this programme :-

Requirnments for Bean :-
	that class (Bean class) should be serialized.
	Class must support zero-parameter constructor.
	It must expose properties using method which follow standard get/set naming convention.

Implement the getter setter method for given variable. If variable is bool type so define a method with "Is" so compiler will automatically
call that method, we will used only variable name.

POINTS :-
	1. Here we are using character with switch case because java does not support string in switch  case.
*/