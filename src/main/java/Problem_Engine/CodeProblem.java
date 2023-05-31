package Problem_Engine;

import java.time.OffsetDateTime;
import java.util.Arrays;

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
}
