package shopping;
import java.rmi.*;
import java.util.*;

public class CartImpl extends java.rmi.server.UnicastRemoteObject
implements Cart{
	
	private double payment;

	public CartImpl() throws RemoteException{}					// check point 1.

	public boolean addItem(String item){
		int i = Arrays.binarySearch(Store.items, item);
		if(i >= 0){
			payment += 1.05 * Store.prices[i];
			return true;
		}
		return false;
	}

	public double getPayment(){
		return payment;
	}
}

/* comments about this programme :-

NOTE :- Refers the comments of 'PriceManager' so you will get idea for this also.

The class of Remote object must implements atleats one interface which extends "java.rmi.Remote"  (markup) interface.

*** Something Important ***
	This object is a stateful object because it has a non-static field so we have to create a seperate object for per client
	we cannot use single object for all client. so we are using the CartFactory.

POINTS :-
	1. Here we are not calling the base class's constructor explicitly, compiler will call implicitly.
	
*/