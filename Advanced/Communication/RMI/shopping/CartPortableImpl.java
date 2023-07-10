package shopping;
import java.rmi.*;
import java.util.*;

public class CartPortableImpl
extends javax.rmi.PortableRemoteObject
implements Cart{
	
	private double payment;

	public CartPortableImpl() throws RemoteException{}

	public boolean addItem(String item){
		int i = Arrays.binarySearch(Store.items, item);
		if(i >= 0){
			payment += 1.05 * Store.prices[i];
			return true;
		}
		return false;
	}

	public double getPayment() throws RemoteException{
		unexportObject(this);								// Check point 1.
		return payment;
	}
}

/* Comments about this programme :-

What is the use of Portable-RMI :-
	It is Object-Management-Group's open protocol designed for CORBA
	It is supported in different programming language.
	Multiple Remote object of given process can use a single socket open by ORB for receiving invocation request.
	It's programing model is complicated.
	Doesnot support distributed garbage collecter.

PortableRemoteObject :-
	Server implementation objects may either inherit from javax.rmi.PortableRemoteObject or they may implement a remote 
	interface and then use the exportObject method to register themselves as a server object. The toStub method takes a server 
	implementation and returns a stub that can be used to access that server object. The connect method makes a Remote object 
	ready for remote communication. The unexportObject method is used to deregister a server object, allowing it to become 
	available for garbage collection. The narrow method takes an object reference or abstract interface type and attempts to 
	narrow it to conform to the given interface. If the operation is successful the result will be an object of the specified type, 
	otherwise an exception will be thrown. 

POINTS :-
	1. It is used for break the reference so Garbage collector will collect this object. because our work has done, now we are
	    returning the payment.
*/