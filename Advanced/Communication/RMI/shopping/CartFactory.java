package shopping;
import java.rmi.*;

public interface CartFactory extends Remote{
	Cart create() throws RemoteException;
}

/* 
This is a interface and this interface extends java.rmi.Remote interface and we are declaring the create method which will be used for
create the object of Cart.
*/