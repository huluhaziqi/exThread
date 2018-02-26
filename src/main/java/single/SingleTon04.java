package single;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleTon04 {
    public enum MySingleTon{
        connectionFacotry;
        private Connection connection;

        private MySingleTon() {
            System.out.println("创建");
            String url = "jdbc:sqlserver://localhost:8080;databaseName=lin";
            String username = "root";
            String password = "root";
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            try {
                Class.forName(driverName);
                connection = DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Connection getConnection() {
            return connection;
        }
    }
    public static Connection getConnection(){
        return MySingleTon.connectionFacotry.getConnection();
    }

}
