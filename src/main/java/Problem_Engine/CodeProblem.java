package Problem_Engine;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeProblem {
    private long id;
    private OffsetDateTime createdAt;
    private String problem;
    private String[] answer;

    public CodeProblem(long id, OffsetDateTime createdAt, String problem, String answer) {
        this.id = id;
        this.createdAt = createdAt;
        this.problem = problem;
        this.answer = answer.split(":");
    }

    public long getId() {
        return id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public String getProblem() {
        return problem;
    }

    public String[] getAnswer() {
        return answer;
    }
    public int getNumberOfAnswer(){
        return answer.length;
    }

    public boolean compareAnswers(String[] givenAnswers){
        return Arrays.equals(answer, givenAnswers);
    }

    public String[] getDifferentElements(String[] givenAnswer) {
        List<String> differentElements = new ArrayList<>();

        for (String element : givenAnswer) {
            if (!containsElement(answer, element)) {
                differentElements.add(element);
            }
        }

        for (String element : answer) {
            if (!containsElement(givenAnswer, element)) {
                differentElements.add(element);
            }
        }

        return differentElements.toArray(new String[0]);
    }

    private static boolean containsElement(String[] arr, String element) {
        for (String str : arr) {
            if (str.equals(element)) {
                return true;
            }
        }
        return false;
    }

}
