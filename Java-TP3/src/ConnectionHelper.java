import java.sql.*;

/***
 * 
 * @author tatsiana shkoda
 * Ce class est pour faire la connection avec le BDD MySQL
 *
 */
public class ConnectionHelper {
	private String url="jdbc:mysql://mysql.iro.umontreal.ca/shkodata_test";

	   private String username = UserData.login;
	   private String password = UserData.passwd;
	   private String driver = "com.mysql.jdbc.Driver";

	   public ConnectionHelper() {

	   }

	   public void setDriver()
	      throws ClassNotFoundException    {
	      Class.forName(driver);
	   }

	   public void setUrl(String aUrl) {
	      url = aUrl;
	   }

	   public void setUsername(String aUsername) {
	      username = aUsername;
	   }

	    public void setPassword(String aPassword) {
	      password = aPassword;
	   }

	    /* Obtention de connection avec une base de donnees MySql */
	   public Connection getConnection()  throws SQLException  {
	         return DriverManager.getConnection(url, username , password);
	   }

}
