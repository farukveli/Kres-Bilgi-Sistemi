import java.sql.Connection;
import java.sql.*;

public class Connect {
    private Connection connection;
    public Connection connection (String dbname, String user, String pass) {
        Connection con = null;
        try {

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);

            if(con != null)
                System.out.println("Connected!");
            else
                System.out.println("Not Connected!");
        }

        catch (Exception e) {
            System.out.println(e);
        }
        connection = con;
        return con;
    }
    public Connection getConnection() {
        return connection;
    }
}
