package Database;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.ConnectionProvider;
import org.jooq.conf.Settings;

public class DB {
    public static Configuration configure() {
        // Create a ConnectionProvider to handle the database connection
        ConnectionProvider connectionProvider = new JDBCConnectionProvider();

        // Create a jOOQ Configuration object
        Configuration configuration = new DefaultConfiguration();

        // Configure the connection and dialect
        configuration.set(connectionProvider)
                .set(SQLDialect.POSTGRES);

        // Optionally, configure additional settings
        configuration.set(new Settings().withRenderFormatted(true));

        return configuration;
    }
}

