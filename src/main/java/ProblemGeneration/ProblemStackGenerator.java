package ProblemGeneration;

import java.io.IOException;
import java.util.Stack;

public class ProblemStackGenerator implements ProblemGetter {

    private static ProblemStackGenerator psg_instance = null;
    private Stack<CodeProblem> codeProblemStack = new Stack<>();

    CodeProblem currentProblem;

    private ProblemStackGenerator(){
        initializeStack();
        currentProblem = codeProblemStack.pop();
    }

    public static synchronized ProblemStackGenerator getInstance(){
        if(psg_instance == null){
            psg_instance = new ProblemStackGenerator();
        }

        return psg_instance;
    }

    public Problem getNewProblem(int type) {
        if (type == 1) {
            return getCodeProblem();
        }
        return new CodeProblem("There has been an Error", "Error");
    }

    public String getCurrentProblemQuestion(){
        return currentProblem.getQuestion();
    }

    public String[] getCurrentProblemAnswers(){
        return currentProblem.getAnswers();
    }


    private CodeProblem getCodeProblem() {


        if (codeProblemStack.size() < 8) {
            refillStack();
        }
        currentProblem =codeProblemStack.pop();
        return currentProblem;
    }

    public void initializeStack() {
        try {
            codeProblemStack = FileProblemGenerator.getProblemsFromFile();
        } catch (IOException e) {
            System.out.println("There was an error while trying to recieve CodeProblems");
            throw new RuntimeException(e);
        }
    }

    public void refillStack() {
        try {
            codeProblemStack.push(GPTProblemGenerator.getProblemsFromGPT());
        } catch (Exception e) {
            System.out.println("Error with the GPT Problem Generation");
            System.out.println(codeProblemStack.size() + " CodeProblems left in the stack");
        }
    }
}
