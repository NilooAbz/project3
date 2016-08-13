package utilty;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DotinSchool2 on 8/2/2016.
 */

public class JDBCConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/customermanagement?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static Object lock = new Object();
    static final String USER = "root";
    static final String PASS = "root";

    private static Connection connection = null;

    private  JDBCConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("خطای اتصال به پایگاه داده");
        }
    }

    public static Connection getJDBCConnection() {
        synchronized (lock)
        {
            if(connection == null){
                new JDBCConnection();
            }
            return connection;
        }
    }
}
