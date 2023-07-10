import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class SwingMVCTest{

	static class MainFrame extends JFrame{
		
		private JTextField input = new JTextField();
		private JTable view = new JTable();
		private JScrollPane pane = new JScrollPane(view);

		public MainFrame(){
			super("Customer Orders");
			setSize(400, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setUndecorated(true);
			rootPane.setWindowDecorationStyle(JRootPane.FRAME);
			add(input, BorderLayout.NORTH);
			add(pane, BorderLayout.CENTER);
			ActionListener controller = new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					String customerId = input.getText();
					TableModel model = new OrderTableModel(
						customerId);
					pane.setVisible(false);
					view.setModel(model);
					pane.setVisible(true);
				}
			};
			input.addActionListener(controller);
		}
	}

	static class OrderEntry{

		int orderNo, productNo, quantity;
		java.sql.Date orderDate;
		double amount;

		public OrderEntry(ResultSet rs) throws SQLException{
			orderNo = rs.getInt("ord_no");	
			orderDate = rs.getDate("ord_date");
			productNo = rs.getInt("pno");
			quantity = rs.getInt("qty");
			amount = rs.getDouble("amt");
		}
	}

	static class OrderTableModel extends AbstractTableModel{
		
		private ArrayList<OrderEntry> orders = 
			new ArrayList<OrderEntry>();

		public OrderTableModel(String customerId){
			try{
				Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost/xe", 
					"scott", "tiger");
				try{
					PreparedStatement pstmt = con.prepareCall(
						"select ord_no, ord_date, pno, qty, amt"
						+ " from ord_view where cust_id=?");
					pstmt.setString(1, customerId);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next())
						orders.add(new OrderEntry(rs));
					rs.close();
					pstmt.close();
				}finally{
					con.close();
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}

		@Override
		public int getColumnCount(){
			return 5;
		}

		@Override
		public String getColumnName(int i){
			String[] names = {"Order No", "Order Date", 
				"Product No", "Quantity", "Amount"};
			return names[i];
		}
		
		@Override
		public Class<?> getColumnClass(int i){
			Class<?>[] classes = {Integer.class, 
				java.sql.Date.class, Integer.class, Integer.class,
				Double.class};
			return classes[i];
		}

		@Override
		public int getRowCount(){
			return orders.size();
		}

		@Override
		public Object getValueAt(int i, int j){
			OrderEntry entry = orders.get(i);
			switch(j){
				case 0: return entry.orderNo;
				case 1: return entry.orderDate;
				case 2: return entry.productNo;
				case 3: return entry.quantity;
				case 4: return entry.amount;
			}
			return null;
		}
	}

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}


















