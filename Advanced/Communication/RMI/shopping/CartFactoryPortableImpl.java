package shopping;
import java.rmi.*;

public class CartFactoryPortableImpl 
extends javax.rmi.PortableRemoteObject
implements CartFactory{
	
	public CartFactoryPortableImpl() throws RemoteException{}

	public Cart create() throws RemoteException{
		return new CartPortableImpl();		
	}
}


// please refer the comments of 'CartFactoryImpl.java'

