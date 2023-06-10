package Panels;
import Problem_Engine.CodeProblem;
import Problem_Engine.CodeProblemDepot;
import javax.swing.*;
import java.awt.*;

public class CodeBlanksPanel extends JPanel {

    public CodeBlanksPanel() {
        setBackground(PanelConstants.CUSTOM_WHITE);
        BoxLayout fl = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(fl);

        JLabel codeTitle = new JLabel("Code:");
        codeTitle.setFont(new Font("Dialog", Font.BOLD, 16));
        codeTitle.setForeground(PanelConstants.CUSTOM_GREY);;
        add(codeTitle);

        // TODO: get code from database
        CodeProblemDepot codeProblemDepot = CodeProblemDepot.getInstance();
        CodeProblem currentProblem = codeProblemDepot.getCurrentProblem();
        JTextArea givenCode = new JTextArea(currentProblem.getProblem());
        givenCode.setEditable(false);
        givenCode.setFont(CodePanel.fontCode);


        add(givenCode);
    }

}