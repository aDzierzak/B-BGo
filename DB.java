import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//update data in a database
public class DB {

	String url = "jdbc:mysql://localhost/bbgo";
	String user = "root";
	String password = "root";

	public static void insert() {
		try {
			// Register the Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a connection to the database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbgo", "root", "root");
			// Create a statement
			Statement stmt = conn.createStatement();
			// Execute a Query
			String sql = "insert into emp (empno, ename, job, deptno) values (1111, 'JONES', 'MARKETING', 40)";
			stmt.executeUpdate(sql);
			// Process the results set
			System.out.println("data inserted");

			// clean up the environment
			// rs.close();
			stmt.close();
			conn.close();
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void delete() {
		try {
			// Register the Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a connection to the database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbgo", "root", "root");
			// Create a statement
			Statement stmt = conn.createStatement();
			// Execute a Query
			String sql = "delete from emp where deptno = 40";
			int numRows = stmt.executeUpdate(sql);
			// Process the results set
			System.out.println("Number of Rows Affected " + numRows);
			System.out.println("data deleted");

			// clean up the environment
			// rs.close();
			stmt.close();
			conn.close();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void update() {
		try {
			// Register the Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a connection to the database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbgo", "root", "root");
			// Create a statement
			Statement stmt = conn.createStatement();
			// Execute a Query
			String sql = "update emp set sal = 1250.00 where empno = 7369";
			stmt.executeUpdate(sql);
			// Process the results set
			System.out.println("data updated");

			// clean up the environment
			// rs.close();
			stmt.close();
			conn.close();
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void retrieve() {

		try {
			// Register the Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a connection to the database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbgo", "root", "root");
			// Create a statement
			PreparedStatement stmt = conn.prepareStatement("select * from emp where sal > ? and deptno = ?");

			// set the parameters
			stmt.setDouble(1, 1000);
			stmt.setInt(2, 30);

			// Execute a Query
			ResultSet rs = stmt.executeQuery();
			// display the results set
			while (rs.next()) {
				// Retrieve by column name
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Double sal = rs.getDouble("sal");
				int deptno = rs.getInt("deptno");

				// Display values
				System.out.print("ID: " + empno);
				System.out.print(", Name: " + ename);
				System.out.println(", Job: " + job);
				System.out.println(", Sal: " + sal);
				System.out.println(", Dept: " + deptno);
			}

			// clean up the environment
			rs.close();
			stmt.close();
			conn.close();
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}
}
