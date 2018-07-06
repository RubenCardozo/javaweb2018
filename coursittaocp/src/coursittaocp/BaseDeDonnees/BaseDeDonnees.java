package coursittaocp.BaseDeDonnees;

import java.sql.*;

import java.util.logging.*;

public class BaseDeDonnees {

    public static void main(String[] args) {

        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String login = "app";
System.out.println("******************createStatement*******************");
         try (Connection cnx = DriverManager.getConnection(url, user, login);
                Statement stt = cnx.createStatement();) {
            
            
            DatabaseMetaData mt = cnx.getMetaData();
            if (mt.supportsResultSetType(ResultSet.CONCUR_UPDATABLE) ) {
                System.out.println("UPDATABLE");
            }
            if (mt.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("SENSITIVE");
            }
            
            
            String sql = "SELECT * FROM APP.CUSTOMER";
            ResultSet rs = stt.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("nb cols: " + meta.getColumnCount());
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.println(meta.getColumnName(i) + " is a " + (meta.getColumnType(i) == 12 ? "CHARS" : "autre"));
            }

            while (rs.next()) {
                System.out.println(rs.getObject(1) + " - " + rs.getString("NAME"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        System.out.println("******************prepareStatement*******************");
        String sql = "SELECT * FROM APP.CUSTOMER WHERE ADDRESSLINE2 like ?";
        try (Connection cnx = DriverManager.getConnection(url, user, login);
                PreparedStatement stt = cnx.prepareStatement(sql);) {
            stt.setString(1, "Suite%");
            stt.execute();
            ResultSet rs = stt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getObject(1) + " - " + rs.getString("NAME") + " - " + rs.getString("ADDRESSLINE2"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
