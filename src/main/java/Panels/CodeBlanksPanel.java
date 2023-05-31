package Panels;
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
        JTextArea givenCode = new JTextArea("if (x < 10) {\n   1. ____\n   2. ____\n   3. ____\n}");
        givenCode.setEditable(false);
        givenCode.setFont(CodePanel.fontCode);

        add(givenCode);
    }
}