package shopping;
import java.rmi.*;

public class CartFactoryImpl 
extends java.rmi.server.UnicastRemoteObject
implements CartFactory{
	
	public CartFactoryImpl() throws RemoteException{}					// check point 1.

	public Cart create() throws RemoteException{						// check point 2.
		return new CartImpl();		
	}
}

/* Comments about this programme  :-

*** Something Important ***
	Our CartImpl object is stateful object so every client should get the seperate object so what we are doing -
	We are creating the CartFactory and registering it's stub in RMI-Registry so Client will be looking up for CartFactory's stub
	on that remote stub we will call the create() method of CartFactory. so we will get the stub(remote object) of Cart.

	Inside client-app we will get CartFactory's stub and by the stub we will get Cart's stub.

POINTS :-
	1. This is a constructor. Which call the constuctor of super class and super class's constructor will export this Remote object
	2. This is a function we are difing a method which will create the object of CartImpl, because CartImpl's object will be stateful
	     object so every client must get the separate object.
*/