package Problem_Engine;

import Database.CodeProblems;
import Database.DB;
import java.time.OffsetDateTime;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.json.JSONException;
import org.json.JSONObject;

public class DatabaseProblemInserter {

    private static final DSLContext dsl = DSL.using(DB.configure());

    public static void insertCodeProblem( String problemText, String solutionText) {
        // Define the table fields explicitly
        Field<JSON> problem = DSL.field("problem", SQLDataType.JSON);
        Field<String> answer = DSL.field("answer", SQLDataType.VARCHAR);

        // Insert a record into the CodeProblems table
        dsl.insertInto(CodeProblems.CODE_PROBLEMS_TABLE)
            .set(problem, DSL.val("{ \"title\": \""+problemText+"\" }").cast(JSON.class))
            .set(answer, solutionText)
            .execute();
    }

    public static CodeProblem retrieveCodeProblems( int desiredId) {
        // Retrieve all records from the CodeProblems table
        Result<Record> result = dsl.select()
            .from(CodeProblems.CODE_PROBLEMS_TABLE)
            .fetch();

        Record record = result.get(desiredId-1);
        Long id = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("id", Long.class));
        OffsetDateTime createdAt = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("created_at", OffsetDateTime.class));
        JSON problem = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("problem", JSON.class));
        String answer = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("answer", String.class));
        String title = null;

// Parsing the JSON string
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(problem.toString());
            title = jsonObject.getString("title");
        } catch (JSONException e) {
            title = problem.data();
        }

        // Extracting the title value
            System.out.println("ID: " + id);
            System.out.println("Created At: " + createdAt);
            System.out.println("Problem: " + title);
            System.out.println("Answer: " + answer);
            System.out.println();

            return new CodeProblem(id,createdAt,title,answer);
        /*
        // Print the retrieved records
        for (org.jooq.Record record : result) {
            Long id = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("id", Long.class));
            OffsetDateTime createdAt = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("created_at", OffsetDateTime.class));
            JSON problem = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("problem", JSON.class));
            String answer = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("answer", String.class));

            if (id ==2){
                System.out.println("ID: " + id);
                System.out.println("Created At: " + createdAt);
                System.out.println("Problem: " + problem);
                System.out.println("Answer: " + answer);
                System.out.println();
            }

        }*/
    }

    private static void displayAllCodeProblems() {
        // Retrieve all records from the CodeProblems table
        Result<Record> result = dsl.select()
            .from(CodeProblems.CODE_PROBLEMS_TABLE)
            .fetch();

        // Print the retrieved records
        for (org.jooq.Record record : result) {
            Long id = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("id", Long.class));
            OffsetDateTime createdAt = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("created_at", OffsetDateTime.class));
            JSON problem = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("problem", JSON.class));
            String answer = record.get(CodeProblems.CODE_PROBLEMS_TABLE.field("answer", String.class));
            // Parsing the JSON string
            JSONObject jsonObject = null;
            String title;
            try {
                jsonObject = new JSONObject(problem.toString());
                title = jsonObject.getString("title");
            } catch (JSONException e) {
                title = problem.data();
            }


                System.out.println("ID: " + id);
                System.out.println("Created At: " + createdAt);
                System.out.println("Problem: " + title);
                System.out.println("Answer: " + answer);
                System.out.println();


        }
    }

    public static int getResultSize(){
        Result<Record> result = dsl.select()
            .from(CodeProblems.CODE_PROBLEMS_TABLE)
            .fetch();
        return result.size();
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
