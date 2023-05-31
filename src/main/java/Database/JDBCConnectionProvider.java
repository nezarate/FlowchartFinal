package Database;
import org.jooq.ConnectionProvider;
import org.jooq.exception.DataAccessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionProvider implements ConnectionProvider {
    private static final String DATABASE_URL =
            "jdbc:postgresql://db.lxpybooslbumnrbrdlhv.supabase.co:5432/postgres?user=postgres&password=bE7Sopk3nQZjCOwC";

    @Override
    public Connection acquire() {
        try {
            return DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            throw new DataAccessException("Error acquiring database connection", e);
        }
    }

    @Override
    public void release(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataAccessException("Error releasing database connection", e);
        }
    }
}
