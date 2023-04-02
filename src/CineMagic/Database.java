package CineMagic;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cinemagic", "root", "");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}