package shopping;
import java.rmi.*;

public interface PriceManager extends Remote{
	double getUnitPrice(String item) throws RemoteException;
	float getBulkDiscount(int quantity) throws RemoteException;
}

/*
 This is a interface which extends java.rmi.Remote interface.
Every method must throw RemoteException.
*/