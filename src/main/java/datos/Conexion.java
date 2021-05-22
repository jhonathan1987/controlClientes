package datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String url = "jdbc:mysql://localhost:3306/control_cliente?useSSL=false&useTimeZone=true&serverTimezoneUTC&allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String password = "";
    private static BasicDataSource ds = null;

    public static DataSource getDataSocurce() {
        if (ds == null) {
            ds = new BasicDataSource();
            ds.setUrl(url);
            ds.setUsername(user);
            ds.setPassword(password);
            ds.setInitialSize(50);
        }

        return ds;

    }

    public static Connection getConnection() throws SQLException {
        return getDataSocurce().getConnection();

    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void close(PreparedStatement pst) {
        try {
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void close(Connection cn) {
        try {
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
