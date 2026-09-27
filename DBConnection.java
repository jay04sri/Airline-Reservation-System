import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/airline_db",
                    "root",
                    "YOUR_MYSQL_PASSWORD");

            return con;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}
