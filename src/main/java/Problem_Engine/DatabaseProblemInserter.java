package Problem_Engine;

import Database.CodeProblems;
import Database.DB;
import java.time.OffsetDateTime;

import Database.FlowchartProblems;
import Handlers.SaveManager;
import Shapes.Flowchart;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class DatabaseProblemInserter {

    private static final DSLContext dsl = DSL.using(DB.configure());

    public static void insertCodeProblem(String problemText, String solutionText) {
        // Define the table fields explicitly
        Field<String> problem = DSL.field("problem", SQLDataType.VARCHAR);
        Field<String> answer = DSL.field("answer", SQLDataType.VARCHAR);

        // Insert a record into the CodeProblems table
        dsl.insertInto(CodeProblems.CODE_PROBLEMS_TABLE)
            .set(problem, problemText)
            .set(answer, solutionText)
            .execute();
    }

    public static void insertFlowchartProblem(String problemText, String flowchartJson) {
        Field<String> problem = DSL.field("problem", SQLDataType.VARCHAR);
        Field<String> answer = DSL.field("answer", SQLDataType.VARCHAR);

        dsl.insertInto(FlowchartProblems.FLOWCHART_PROBLEMS_TABLE)
                .set(problem, problemText)
                .set(answer, flowchartJson)
                .execute();
    }

    public static CodeProblem retrieveCodeProblems(int desiredId) {
        // Retrieve all records from the CodeProblems table
        Result<Record> result = dsl.select()
            .from(CodeProblems.CODE_PROBLEMS_TABLE)
            .fetch();

        Record record = result.get(desiredId);
        Long id = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("id", Long.class));
        OffsetDateTime createdAt =
            record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("created_at", OffsetDateTime.class));
        String problem =
            record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("problem", String.class));
        String answer = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("answer", String.class));

        return new CodeProblem(id, createdAt, problem, answer);


    }

    public static FlowchartProblem retrieveFlowchartProblems(int desiredId) {
        Result<Record> result = dsl.select()
                .from(FlowchartProblems.FLOWCHART_PROBLEMS_TABLE)
                .fetch();

        Record record = result.get(desiredId);
        Long id = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("id", Long.class));
        OffsetDateTime createdAt =
                record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("created_at", OffsetDateTime.class));
        String problem =
                record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("problem", String.class));
        String answer = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("answer", String.class));

        return new FlowchartProblem(id, createdAt, problem, answer);
    }

    private static void displayAllCodeProblems() {
        // Retrieve all records from the CodeProblems table
        Result<Record> result = dsl.select()
            .from(CodeProblems.CODE_PROBLEMS_TABLE)
            .fetch();

        // Print the retrieved records
        for (org.jooq.Record record : result) {
            Long id = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("id", Long.class));
            OffsetDateTime createdAt = record.get(
                CodeProblems.CODE_PROBLEMS_TABLE.field("created_at", OffsetDateTime.class));
            String problem =
                record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("problem", String.class));
            String answer =
                record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("answer", String.class));


            System.out.println("ID: " + id);
            System.out.println("Created At: " + createdAt);
            System.out.println("Problem: " + problem);
            System.out.println("Answer: " + answer);
            System.out.println();


        }
    }

    public static int getResultSize(TableImpl<Record> table) {
        Result<Record> result = dsl.select()
            .from(table)
            .fetch();
        return result.size();
    }

    public static long getSmallestId() {
        Result<Record> result = dsl.select()
            .from(CodeProblems.CODE_PROBLEMS_TABLE)
            .fetch();

        return result.get(0).get(CodeProblems.CODE_PROBLEMS_TABLE.field("id", Long.class));
    }


    public static void main(String[] args) {
        DB.deleteFlowchartProblems();
        String f1 = "[{\"type\":\"Parallelogram\",\"x1\":136,\"y1\":257,\"label\":\"\\\"Hello world!\\\"\"}]~~~[]";
        insertFlowchartProblem("System.out.println(\"Hello world!\")", f1);

        insertFlowchartProblem("p2", "[{\"type\":\"RectangleStandard\",\"x1\":114,\"y1\":100,\"label\":\"2\"},{\"type\":\"RectangleStandard\",\"x1\":113,\"y1\":249,\"label\":\"3\"}]~~~[{\"label\":\"\",\"id1\":0,\"id2\":1}]");
        insertFlowchartProblem("p3", "[{\"type\":\"Parallelogram\",\"x1\":95,\"y1\":166,\"label\":\"1\"},{\"type\":\"Parallelogram\",\"x1\":159,\"y1\":306,\"label\":\"3\"}]~~~[{\"label\":\"p3\",\"id1\":0,\"id2\":1}]");


        FlowchartProblem p1 = retrieveFlowchartProblems(0);
        System.out.println(p1.getAnswerJson());

    }

   /* public static void main(String[] args) {
        displayAllCodeProblems();
        System.out.println(retrieveCodeProblems(0));
    }
    /*
    public static void main(String[] args) {
        //Insert statements of the first Problems inserted in the database

     */
        /*
        insertCodeProblem(dsl,"public class ArraySum {" +
            "public static void main(String[] args) {" +
            "int[] numbers = {2, 4, 6, 8, 10};" +
            "    int sum = ......;" +
            "for (int i=0; i < numbers.length; i++) {" +
            "......;"+
            "}"+
            "" +
            "    System.out.println(Sum of the numbers is  + sum);" +
            "}" +
            "}","0:sum+=number");

        insertCodeProblem(dsl,"public class NumberSum {" +
            "public static void main(String[] args) {" +
            "int num1 = 25;" +
            "int num2 = 37;"+
            " int sum = ......;" +
            "" +
            "    System.out.println(Sum:  + sum);" +
            "}" +
            "}","num1+num2");





        insertCodeProblem(dsl,"public class ArraySum {" +
            "    public static int calculateSum(int[] arr) {" +
            "        int sum = 0;" +
            "        for (int i = 0; i < .......; i++) {" +
            "            sum += arr[i];" +
            "        }" +
            "        return .......;" +
            "    }" +
            "" +
            "    public static void main(String[] args) {" +
            "        int[] array = {1, 2, 3, 4, 5};" +
            "        int result = calculateSum(array);" +
            "        System.out.println(Sum of array elements:  + result);" +
            "    }" +
            "}","arr.length():sum" );
        insertCodeProblem(dsl,"public class RandomNumber {" +
            "    public static void main(String[] args) {" +
            "//Create a random number between 0 and 100 using Math.random" +
            "        int randomNumber = ......" +
            "        " +
            "        System.out.println(Random Number:  + randomNumber);" +
            "    }" +
            "}","(int) (Math.random() * 100)");
        insertCodeProblem(dsl,"public class ArraySum {" +
            "    public static void main(String[] args) {" +
            "        int[] numbers = {2, 4, 6, 8, 10};" +
            "" +
            "//Get the sum using the Arrays.stream() Api"+
            "        int sum = ......" +
            "        int average = ......" +
            "" +
            "        System.out.println(Sum:  + sum);" +
            "        System.out.println(Average:  + average);" +
            "    }" +
            "}","Arrays.stream(numbers).sum():sum/numbers.length");
        insertCodeProblem(dsl, "public class StringConcatenation {" +
            "    public static void main(String[] args) {" +
            "        String firstName = John;" +
            "        String lastName = Doe;" +
            "" +
            "        String fullName = ......" +
            "        String greeting = ......" +
            "" +
            "        System.out.println(Full Name: + fullName);" +
            "        System.out.println(Greeting:  + greeting);" +
            "    }" +
            "}","firstName + + lastName:Hello, + fullName + !");
        insertCodeProblem(dsl,"public class NumberComparison {" +
            "    public static void main(String[] args) {" +
            "        int num1 = 15;" +
            "        int num2 = 20;" +
            "" +
            "        boolean isNum1GreaterThanNum2 = ......" +
            "        boolean isNum1EqualToNum2 = ......" +
            "" +
            "        System.out.println(Is Num1 greater than Num2?  + isNum1GreaterThanNum2);" +
            "        System.out.println(Is Num1 equal to Num2?  + isNum1EqualToNum2);" +
            "    }" +
            "}","num1>num2:num1==num2");

         */
    /*
        displayAllCodeProblems();
    }
    */
}
