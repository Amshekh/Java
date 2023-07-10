package shopping;
import java.rmi.*;
import java.util.*;

public class PriceManagerImpl 
extends java.rmi.server.UnicastRemoteObject 
implements PriceManager{
	
	public PriceManagerImpl() throws RemoteException{						// check point 1.
		super(); // exports this object
	}

	public double getUnitPrice(String item){							// check point 2.
		int i = Arrays.binarySearch(Store.items, item);
		if(i < 0)
			throw new IllegalArgumentException("No such item");
		return 1.05 * Store.prices[i];
	}

	public float getBulkDiscount(int quantity){
		return quantity < 6 ? 0 : 5;
	}
}

class Store{
	
	static String[] items = {"apple", "mango", "orange", 
		"peach", "pear"};
	static double[] prices = {22.75, 35.25, 4.50, 3.75, 5.25};
}

//***********************************************************************************************************

/* comments about this programme :-

The class of Remote object must implements atleats one interface which extends "java.rmi.Remote"  (markup) interface.

UnicastRemoteObject :-
	Used for exporting a remote object with JRMP and obtaining a stub that communicates to the remote object. 

*** Something important ***

If we are implementing the two interface here, one extends from java.rmi.Remote interface and second does not extends  from 
java.rmi.Remote interface so remote object cannot call the method of that interface which is not extending from Remote interface. 
We have to implement the method of that interface in remote object's class but remote object class cannot call those method

*** This remote object is a stateless object because it dont have any non-static field. so this object can be used by multiple client.

POINTS :-
	1. Here we are declaring the constructor and throws a RemoteException because may be some problem. and
		Here we are calling superclass's zero parameter constuctor. so that will Creates and 
		exports a new UnicastRemoteObject object using an anonymous port.

		NOTE :- It will call zero parameter constructor of base class bydefault, but for show the use we are calling explicitly.
		               No need for call explicitly.

	2. Here we are implementing the method of PriceManager interface.
*/