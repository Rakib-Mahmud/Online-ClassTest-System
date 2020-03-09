import javax.swing.*;

import java.sql.*;

public class Database {
	Connection con=null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection con=DriverManager.getConnection("jdbc:sqlite:F:\\CODES\\Java\\GUIproject\\src\\hello.sqlite");
			//JOptionPane.showMessageDialog(null,"Connected to Database Successfully...");
			return con;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}
