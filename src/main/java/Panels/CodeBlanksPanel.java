package Panels;
import ProblemGeneration.ProblemStackGenerator;
import javax.swing.*;
public class CodeBlanksPanel extends JPanel {

    public CodeBlanksPanel() {

        BoxLayout fl = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(fl);

        JLabel codeTitle = new JLabel("Code:");
        add(codeTitle);

        // TODO: get code from database
        ProblemStackGenerator pbg = ProblemStackGenerator.getInstance();
        //JTextArea givenCode = new JTextArea("if (x < 10) {\n   1. ____\n   2. ____\n   3. ____\n}");
        JTextArea givenCode = new JTextArea(pbg.getCurrentProblemQuestion());

        givenCode.setEditable(false);
        givenCode.setFont(CodePanel.fontCode);

        add(givenCode);
    }
}