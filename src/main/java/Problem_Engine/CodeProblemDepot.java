package Problem_Engine;

import java.util.ArrayList;

public class CodeProblemDepot {
    private static CodeProblemDepot codeProblemDepot;
    private ArrayList<CodeProblem> codeProblems = new ArrayList<>();
    private int counter = 0;

    private CodeProblemDepot() {
        // Private constructor to prevent instantiation from outside the class
        for (int i = 0; i < DatabaseProblemInserter.getResultSize();
             i++) {
            codeProblems.add(DatabaseProblemInserter.retrieveCodeProblems(i));
        }
    }

    public static CodeProblemDepot getInstance() {
        if (codeProblemDepot == null) {
            synchronized (CodeProblemDepot.class) {
                if (codeProblemDepot == null) {
                    codeProblemDepot = new CodeProblemDepot();
                }
            }
        }
        return codeProblemDepot;
    }

    // Other methods and variables of the class
    public CodeProblem getCurrentProblem() {
        if (counter >= codeProblems.size()) {
            counter = 0;
        }
        return codeProblems.get(counter);
    }

    public CodeProblem getNextProblem() {
        counter++;
        return getCurrentProblem();
    }
}
