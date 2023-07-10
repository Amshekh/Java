package shopping;
import java.rmi.*;

public interface Cart extends Remote{
	boolean addItem(String item) throws RemoteException;
	double getPayment() throws RemoteException;
}

/*
 This is a interface which extends java.rmi.Remote interface.
*/