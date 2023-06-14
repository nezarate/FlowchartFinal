package Database;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.Name;
import org.jooq.impl.TableImpl;
import org.jooq.impl.SQLDataType;
import org.jooq.Record;
import java.time.OffsetDateTime;

public class Users {
    private static final Name USERS = DSL.name("Users");

    public static final TableImpl<Record> USERS_TABLE = new TableImpl<>(USERS) {
        public final org.jooq.TableField<Record, Long> ID = createField("id", SQLDataType.BIGINT);
        public final org.jooq.TableField<Record, OffsetDateTime> CREATED_AT =
                createField("created_at", SQLDataType.TIMESTAMPWITHTIMEZONE);
        public final TableField<Record, String> USERNAME = createField("username", SQLDataType.VARCHAR);
        public final TableField<Record, String> PASSWORD_MIXED = createField("password_mixed", SQLDataType.VARCHAR);
        public final TableField<Record, String> ROLE = createField("role", SQLDataType.VARCHAR);
        public final TableField<Record, Integer> CURRENT_PROBLEM_FLOWCHART = createField("current_problem_flowchart", SQLDataType.INTEGER);
        public final TableField<Record, Integer> CURRENT_PROBLEM_CODE = createField("current_problem_code", SQLDataType.INTEGER);
    };

    private Users() {
        // Private constructor to prevent instantiation
    }
}
