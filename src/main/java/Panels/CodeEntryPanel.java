package Panels;
import javax.swing.*;
import java.awt.*;

public class CodeEntryPanel extends JPanel {
    public CodeEntryPanel() {
        //FlowLayout fl = new FlowLayout();
        setBackground(PanelConstants.CUSTOM_WHITE);
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(box);

        JLabel title = new JLabel("Code entry area:");
        title.setFont(new Font("Dialog", Font.BOLD, 16));
        title.setForeground(PanelConstants.CUSTOM_GREY);
        add(title);

        int amt = 3;
        for (int i = 1; i <= amt; i++) {
            JLabel num = new JLabel(i + ".");
            add(num);
            JTextField codeEnter = new RoundedTextField(15);
            codeEnter.setFont(CodePanel.fontCode);
            add(codeEnter);
        }
        JButton submit = new RoundedButton("Submit",25);
        add(submit);
    }
}
