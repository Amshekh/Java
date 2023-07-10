package sales;

public class OrderInfo implements java.io.Serializable{

	public String customerId;

	public int productNo;

	public int quantity;
	
}

/* 
We are creating this class because of we will send the data (CustomerId, productNo, quatilty) for place the order.
In OrderManager class. and this class apply Serializable interface. (it same as contract means for place order we have to pass this 
information only). It's all data-type declared as public so we can access from outside.
*/