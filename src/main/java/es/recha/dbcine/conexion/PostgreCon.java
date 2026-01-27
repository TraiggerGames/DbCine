package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreCon {
    public static String DB ="dbcine";
    static String SERVER_URL = "jdbc:postgresql://litten.myqnapcloud.com:5432/"+DB;
    static final String SERVER_USER = "perridan";
    static final String SERVER_PASSWD = "perridan";
    public static Connection postgreCon;

    public static Connection conectionPosgree() {
        try {
            Connection postgreCon = DriverManager.getConnection(SERVER_URL, SERVER_USER, SERVER_PASSWD);
            return postgreCon;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        try {
            postgreCon.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostgreCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostgreCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConnection() {
        try {
            Connection con = postgreCon;
            if(con == null){
                con= conectionPosgree();
            }
            return con;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}


