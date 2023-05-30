package Database;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

import java.time.OffsetDateTime;

public class DatabaseTest {
    public static void main(String[] args) {
        // Obtain the jOOQ DSLContext using your configured DB class
        DSLContext dsl = DSL.using(DB.configure());

        // Perform testing operations
        insertCodeProblem(dsl);
        retrieveCodeProblems(dsl);
    }

    private static void insertCodeProblem(DSLContext dsl) {
        // Define the table fields explicitly
        Field<JSON> problem = DSL.field("problem", SQLDataType.JSON);
        Field<String> answer = DSL.field("answer", SQLDataType.VARCHAR);

        // Insert a record into the CodeProblems table
        dsl.insertInto(CodeProblems.CODE_PROBLEMS_TABLE)
                .set(problem, DSL.val("{ \"title\": \"Problem 1\" }").cast(JSON.class))
                .set(answer, "Solution 1")
                .execute();
    }

    private static void retrieveCodeProblems(DSLContext dsl) {
        // Retrieve all records from the CodeProblems table
        Result<org.jooq.Record> result = dsl.select()
                .from(CodeProblems.CODE_PROBLEMS_TABLE)
                .fetch();

        // Print the retrieved records
        for (org.jooq.Record record : result) {
            Long id = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("id", Long.class));
            OffsetDateTime createdAt = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("created_at", OffsetDateTime.class));
            JSON problem = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("problem", JSON.class));
            String answer = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("answer", String.class));

            System.out.println("ID: " + id);
            System.out.println("Created At: " + createdAt);
            System.out.println("Problem: " + problem);
            System.out.println("Answer: " + answer);
            System.out.println();
        }
    }
}
