/**
 * 
 */
package com.bbdd;

/**
 * @author carlo
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * A Java MySQL DELETE example.
 * Demonstrates the use of a SQL DELETE statement against a
 * MySQL database, called from a Java program, using a
 * Java PreparedStatement.
 * 
 * Created by Alvin Alexander, http://devdaily.com
 */
public class JavaMysqlDeleteExample {

	public static void ejecutarBorrar(String columna, String valor)
	  {ConexionBBDD miConexion = new ConexionBBDD();
	    try
	    {
	      // create the mysql database connection
	    
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/test";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "0123456789");
	      miConexion.conectar();
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "delete from users where " + columna + "= '"+ valor+"';";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setInt(1, 3);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }

	  }
	
}
