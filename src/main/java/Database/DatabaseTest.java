package Database;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.meta.derby.sys.Sys;

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
        Field<String> problem = DSL.field("problem", SQLDataType.VARCHAR);
        Field<String> answer = DSL.field("answer", SQLDataType.VARCHAR);
        Field<String> hint = DSL.field("hint", SQLDataType.VARCHAR);
        Field<String> flowchart = DSL.field("flowchart", SQLDataType.VARCHAR);
        Field<Integer> loc = DSL.field("loc", SQLDataType.INTEGER);
        Field<Integer> eloc = DSL.field("eloc", SQLDataType.INTEGER);
        Field<Integer> lloc = DSL.field("lloc", SQLDataType.INTEGER);
        Field<Integer> cc = DSL.field("cc", SQLDataType.INTEGER);

        // Insert a record into the CodeProblems table
        dsl.insertInto(CodeProblems.CODE_PROBLEMS_TABLE)
                .set(problem, "{ \"title\": \"Problem 1\" }")
                .set(answer, "Solution 1")
                .set(hint, "Hint 1")
                .set(flowchart, "Flowchart 1")
                .set(loc, 50)
                .set(eloc, 25)
                .set(lloc, 20)
                .set(cc, 7)
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
            String problem = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("problem", String.class));
            String answer = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("answer", String.class));
            String hint = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("hint", String.class));
            String flowchart = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("flowchart", String.class));
            Integer loc = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("loc", Integer.class));
            Integer eloc = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("eloc", Integer.class));
            Integer lloc = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("lloc", Integer.class));
            Integer cc = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("cc", Integer.class));

            System.out.println("ID: " + id);
            System.out.println("Created At: " + createdAt);
            System.out.println("Problem: " + problem);
            System.out.println("Answer: " + answer);
            System.out.println("Hint: " + hint);
            System.out.println("Flowchart: " + flowchart);
            System.out.println("LOC: " + loc);
            System.out.println("eLOC: " + eloc);
            System.out.println("lLOC: " + lloc);
            System.out.println("CC: " + cc);

            System.out.println();
        }
    }
}
