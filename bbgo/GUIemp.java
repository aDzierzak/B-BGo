package bbgo;


import java.sql.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/** 
 * This class is a GUI front end for a mySQL database. 
 * It assumes an employee database and will display the 
 * database employee details in a JTable and allow the user to 
 * select an item from the JTable and give them details about 
 * the employees department. <p>
 *
 * @author	Simon McLoughlin, LKeyes
 * @see sqlengine
 */


public class GUIemp extends JFrame implements ListSelectionListener{
	
	    //Table for emp details
		JTable empTable = null;
		
		//scroll pane for emptable
		JScrollPane scrollPane;
		
		//Database engine for creating DB connection, making queries
		sqlengine dbEngine = new sqlengine("root", ""); //database engine
		
		/**
		 * Constructor for GUIemp JFrame, calls constructor in 
		 * super class JFrame and calls the {@link #init() init} method
		 * @param title the title of the GUIemp JFrame
		 */
		public GUIemp(String title) {
			super(title);
			init();
		}
		
		/**
		 * Create connection to the DB and call {@link #getEmpDetail() getEmpDetail}.
		 * this call would normally be triggered by a user in a real 
		 * (non-demo) application. 
		 */
		public void init() {
	     dbEngine.connect();
	 	 //testInsert();
	     getEmpDetail();
		}
		
		/**
		 * a test method to illustrate how an insert query can be performed. 
		 * update queries can be performed in a similar way.
		 */
		public void testInsert()
		{
			
			try {
				dbEngine.executeQuery("insert into emp (empno,ename,job,sal,deptno)" +
											"values (1141,'KENNY','SALES',2000,30)");
			}
			catch (SQLException e) {
				System.err.println("SQLException: " + e.getMessage());
			}
			
		}
		
		
		/**
		 * method to retrieve emp details from the database 
		 * and display them in a JTable.
		 */
		public void getEmpDetail() {
			
			//select everything from emp table
			ResultSet rs;
			ResultSetMetaData rsmd = null;
			int colCount=0;
			String [] colNames = null;
			
			//get the column names from the ResultSet metadata
			try {
				rs = dbEngine.executeQuery("select * from emp");
				rsmd = rs.getMetaData();
				colCount = rsmd.getColumnCount();
		        colNames = new String[colCount];
		        for(int i=1;i<=colCount;i++) {
		        	colNames[i-1] = rsmd.getColumnName(i);
		        }
		        
		        //JTables have a view class and a Model class, the view class
				//handles the drawing of the JTable, the Model class handles the properties
				//and the data
				
				//Create a table model (used for controlling a JTable)
				DefaultTableModel model = new DefaultTableModel(colNames,0);
				empTable = new JTable(model);
				
				//Similarly a ListSelectionModel represents the current state of the selection
				//for components (like JTables) 
				DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
				//allow single selection only from empTable
				dlsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				empTable.setSelectionModel(dlsm);
				dlsm.addListSelectionListener(this); //lets use this JFrame as the event handler for
														//when an item is selected
				
				String [] currentRow = new String[colCount];//array to hold the row data
				while(rs.next()) { //move the rs pointer on to the next record (starts before the 1st)
					for(int i=1;i<=colCount;i++) {
						currentRow[i-1] = rs.getString(i);
					}
					model.addRow(currentRow); //add the row to the table through the table model
				}
			}
			catch (SQLException e) {
				System.err.println("SQLException: " + e.getMessage());
			}
			
			scrollPane = new JScrollPane(empTable);//add the table to a scroll pane
			this.getContentPane().add(scrollPane);
		}
		       
		
		/** Event handler for the list selection model
		 * 	This will get the deptno from the selected row
		 * 	in the emp table and pass it to show {@link #showEmpDialog(String) showEmpDialog}
		 * 
		 * 	@param e The ListSelectionEvent details
		 */
		public void valueChanged(ListSelectionEvent e) {
			//table row and column indexes start at zero, hence some -1's
			//note that I could (and probably should) of performed an sql query 
			//to get the column index for manufacturerID, rather than using a priori knowledge
			String deptno = (String) empTable.getValueAt(empTable.getSelectedRow(), empTable.getColumnCount()-1);
			showEmpDialog(deptno);
			
		}
		
		/**
		 * Form and execute a query to get the dept details
		 * for a particular emp. The dept is the one selected
		 * by the user. Display results in a dialog box.
		 * 
		 * @param ID The deptno used in the query
		 */
		
		public void showEmpDialog(String ID) {
			
			ResultSetMetaData rsmd = null;
			int colCount=0;
			String message = "Department Details:\n";
			try {
				ResultSet rs = dbEngine.executeQuery("select * from dept where deptno='"+ID+"'");
				rsmd = rs.getMetaData();
				rs.next();//move result set pointer to first and only row
				colCount = rsmd.getColumnCount();//get number of columns
				//create a emp details message string
		        for(int i=1;i<=colCount;i++) {
		        	message = message + rsmd.getColumnName(i)+": "+rs.getString(i)+"\n"; 
		        }
			}
			catch (SQLException e) {
				System.err.println("SQLException: " + e.getMessage());
			}
			JOptionPane.showMessageDialog(this, message); //show details in a dialog box
		}
		
		/**
		 * The main method to instantiate GUIemp and show it.
		 * 
		 * @param args Command line arguments is any.
		 */
		
		public static void main(String[] args) {

			GUIemp gui = new GUIemp("emp db");
			gui.pack();
			gui.setVisible(true);
		
		}



	
}
