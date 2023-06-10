package Database;

import java.time.OffsetDateTime;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class CodeProblems {
    private static final Name CODE_PROBLEMS = DSL.name("CodeProblems");

    public static final TableImpl<Record> CODE_PROBLEMS_TABLE = new TableImpl<>(CODE_PROBLEMS) {
        public final org.jooq.TableField<Record, Long> ID = createField("id", SQLDataType.BIGINT);
        public final org.jooq.TableField<Record, OffsetDateTime> CREATED_AT =
                createField("created_at", SQLDataType.TIMESTAMPWITHTIMEZONE);
        public final TableField<Record, String> PROBLEM = createField("problem", SQLDataType.VARCHAR);
        public final TableField<Record, String> ANSWER = createField("answer", SQLDataType.VARCHAR);
    };

    private CodeProblems() {
        // Private constructor to prevent instantiation
    }
}
