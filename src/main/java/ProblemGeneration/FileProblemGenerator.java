package ProblemGeneration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Stack;

public class FileProblemGenerator {

   public static Stack<CodeProblem> getProblemsFromFile() throws IOException {
       Stack<CodeProblem> codeProblems = new Stack<>();

       Path exampleProblemsPath = Path.of("src/main/java/resources/ExampleCodeProblems.txt");
       String exampleProblems = Files.readString(exampleProblemsPath);
       String[] singleProblems = exampleProblems.split("-Divider-");
       for (String singleProblem : singleProblems) {
           int problemStartIndex = singleProblem.indexOf("public class");
           int problemEndIndex = singleProblem.lastIndexOf("}");
           String problem = singleProblem.substring(problemStartIndex, problemEndIndex + 1);
           singleProblem = singleProblem.substring(problemEndIndex+1);
           singleProblem =singleProblem.replace("Solution:","");

           // Extract the solutions
           String[] solutions = singleProblem.split("\\d+\\.\\s+");

           for (int j = 0; j < solutions.length; j++) {
               solutions[j] = solutions[j].trim();
           }

           codeProblems.push(new CodeProblem(problem, solutions));
       }

        return codeProblems;


   }


}
