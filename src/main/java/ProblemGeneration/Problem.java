package ProblemGeneration;

import java.util.Arrays;

public abstract class  Problem {
    private String question;
    private String[] answers;
    // optional String hint;


    public Problem(String question, String... answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    private void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswers() {
        return Arrays.toString(answers);
    }

    private void setAnswers(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "CodeProblem:\n" +
            "question='" + question +
            "||| answers=" + Arrays.toString(answers);
    }

}
