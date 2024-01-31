import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class newclass2 {
    String dbUrl = "jdbc:mysql://localhost:3307/food";
    String dbUname = "root";
    String dbPassword = "";
    String dbDriver = "com.mysql.cj.jdbc.Driver";
    String item;
    int qty;

    newclass2(String item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    void store() {
        Connection con = null;
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);

            String sqll = "INSERT INTO foood(item, qty) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(sqll)) {
                preparedStatement.setString(1, item);
                preparedStatement.setInt(2, qty);
                preparedStatement.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
