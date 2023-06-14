package Panels;
import javax.swing.*;
import java.awt.*;
public class CodePanel extends JPanel {

    public static Font fontCode = new Font("Consolas", Font.PLAIN, 12);

    public CodePanel() {

        setBackground(PanelConstants.CUSTOM_WHITE);
        GridLayout grid = new GridLayout(2, 0);
        setLayout(grid);



        //add(Box.createRigidArea(new Dimension(20, 20)));
        JPanel codeBlanksPanel = new CodeBlanksPanel();
        add(codeBlanksPanel);

        JPanel codeEntryPanel = new CodeEntryPanel();
        add(codeEntryPanel);





    }
}
