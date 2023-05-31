package Database;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.conf.Settings;
import org.jooq.impl.SQLDataType;

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

    public static Boolean createAccount(String usernameText, String passwordText, boolean student) {
        // Obtain the jOOQ DSLContext using your configured DB class
        DSLContext dsl = DSL.using(DB.configure());

        // Define the table fields explicitly
        Field<String> username = DSL.field("username", SQLDataType.VARCHAR);
        Field<String> password = DSL.field("password", SQLDataType.VARCHAR);
        Field<String> role = DSL.field("role", SQLDataType.VARCHAR);
        String roleText;
        if(student){
            roleText = "Student";
        }else{
            roleText = "Teacher";
        }

        try {
            // Insert a record into the CodeProblems table
            dsl.insertInto(Users.USERS_TABLE)
                    .set(username, usernameText)
                    .set(password, passwordText)
                    .set(role, roleText)
                    .execute();
        } catch (Exception e) {
            // Handle unique constraint violation (duplicate username)
            System.out.println("Username is already taken. Please choose a different username.");
            return false;
        }
        return true;
    }

    public static Boolean login(String usernameText, String passwordText) {
        // Obtain the jOOQ DSLContext using your configured DB class
        DSLContext dsl = DSL.using(DB.configure());

        Field<String> username = DSL.field("username", SQLDataType.VARCHAR);
        Field<String> password = DSL.field("password", SQLDataType.VARCHAR);

        try {
            // Query the users table for the given username and password
            Result<org.jooq.Record> result = dsl.select()
                    .from(Users.USERS_TABLE)
                    .where(username.eq(usernameText))
                    .and(password.eq(passwordText))
                    .fetch();

            if (result.isNotEmpty()) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Invalid credentials. Please try again.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occurred while authenticating the user.");
            return false;
        }
        return true;
    }
}

