package ProblemGeneration;

public interface ProblemGetter {

    Problem getNewProblem(int type);

    String getCurrentProblemQuestion();

    String[] getCurrentProblemAnswers();

}
