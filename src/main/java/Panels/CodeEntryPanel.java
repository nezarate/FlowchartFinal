package Panels;
import javax.swing.*;

public class CodeEntryPanel extends JPanel {
    public CodeEntryPanel() {
        //FlowLayout fl = new FlowLayout();
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(box);

        JLabel title = new JLabel("Code entry area:");
        add(title);

        int amt = 3;
        for (int i = 1; i <= amt; i++) {
            JLabel num = new JLabel(i + ".");
            add(num);
            JTextField codeEnter = new JTextField(15);
            codeEnter.setFont(CodePanel.fontCode);
            add(codeEnter);
        }
        JButton submit = new JButton("Submit");
        add(submit);
    }
}
