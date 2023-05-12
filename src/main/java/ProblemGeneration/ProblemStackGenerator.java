package ProblemGeneration;

import java.io.IOException;
import java.util.Stack;

public class ProblemStackGenerator implements ProblemGetter {

    Stack<CodeProblem> codeProblemStack = new Stack<>();


    public Problem getProblem(int type){
        if (type ==1 ){
            return getCodeProblem();
        }
        return new CodeProblem("Theres has been an Error", "Error");
    }


    public CodeProblem getCodeProblem(){
        if(codeProblemStack.empty()){
            initializeStack();
        }
        if(codeProblemStack.size() < 4){
            refillStack();
        }
        return codeProblemStack.pop();
    }

    public void initializeStack(){
        try {
            codeProblemStack = FileProblemGenerator.getProblemsFromFile();
        } catch (IOException e) {
            System.out.println("There was an error while trying to recieve CodeProblems");
            throw new RuntimeException(e);
        }
    }

    public void refillStack(){
        //ToDo: Implement a method to refill a stack when it is empty
    }
}
