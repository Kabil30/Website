import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class newclass {
		String dbUrl="jdbc:mysql://localhost:3307/food";
	    String dbUname="root";
	    String dbPassword="";
	    String dbDriver="com.mysql.cj.jdbc.Driver";
	  String name,pass,email,phn_no;
	  newclass(String name,String pass,String email,String phn_no){
		  this.name=name;    
		  this.pass=pass;
		  this.email=email;
		  this.phn_no=phn_no;
	  }
	void store() {
		    Connection con = null;
		    try {
		        Class.forName(dbDriver);
		        con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);

		        // First SQL Query
		        String sql = "INSERT INTO customer_details (name, password, email, phn_no) VALUES ('" + name + "','" + pass + "','" + email + "','" + phn_no + "')";
		        Statement s = con.createStatement();
		        s.execute(sql);
		        con.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}


}