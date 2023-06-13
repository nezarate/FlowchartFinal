package Problem_Engine;

import Shapes.Flowchart;
import Handlers.SaveManager;
import java.time.OffsetDateTime;

public class FlowchartProblem {
    private long id;
    private OffsetDateTime createdAt;
    private String problem;
    //private String[] answerJson;
    private String answerJson;
    private Flowchart answer;

    public FlowchartProblem(long id, OffsetDateTime createdAt, String problem, String answerJson) {
        this.id = id;
        this.createdAt = createdAt;
        this.problem = problem;
        answer = SaveManager.getSaveManager().loadJson(answerJson);
        this.answerJson = answerJson;
        //this.answerJson = answerJson.split(":");
    }

    public Flowchart getAnswer() {
        return answer;
    }
    public String getProblem() { return problem; }
    public String getAnswerJson() {return answerJson;}

}
