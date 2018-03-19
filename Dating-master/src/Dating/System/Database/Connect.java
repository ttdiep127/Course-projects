/**
 * 
 */
package Dating.System.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 2017/11/23
 * 
 * @author HaiRBk
 *
 */
public class Connect {

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        String name_db = "root";
        String pass_db="";
        String url_db="jdbc:mysql://localhost:3306/dating?useUnicode=true&characterEncoding=UTF-8";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url_db,name_db,pass_db);
        return connection;
    }
    public static void main(String agrs[]) throws ClassNotFoundException, SQLException {
        Connection c = Connect.getConnection();
        System.out.println("ok nhé bạn");
    }
}
