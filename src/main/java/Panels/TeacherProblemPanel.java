package Panels;
import Handlers.DiagramControl;
import Handlers.PanelHandler;
import Handlers.Repository;
import org.jooq.impl.QOM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class TeacherProblemPanel extends WorkingPanel {

    private JPanel leftPanel;
    private ArrayList<RoundedTextField> textList;
    private JTextPane outputArea;
    private RoundedButton submitButton;
    private RoundedButton returnButton;
    private WorkingPanel rightPanel;
    public TeacherProblemPanel() {
        setBackground(PanelConstants.CUSTOM_WHITE);
        GridLayout grid = new GridLayout(0, 2);
        setLayout(grid);
        leftPanel = new JPanel(); // Code Problem generated
        rightPanel = new Workspace(); // FlowChart Problem generated

        // configure rightPanel
        Repository.getInstance().addObserver(rightPanel);
        DiagramControl c = new DiagramControl();
        rightPanel.addMouseListener(c);
        rightPanel.addMouseMotionListener(c);

        // configure leftPanel

        // Text Area for writing Problem
        outputArea = new JTextPane();
        outputArea.setEditable(true);
        outputArea.setContentType("text/html");
        outputArea.setBackground(getBackground());
        outputArea.setBorder(null);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI(PanelConstants.CUSTOM_BLACK, PanelConstants.CUSTOM_WHITE));

        // Text Area for the answers
        JPanel blanksPanel = new JPanel();
        textList = new ArrayList<RoundedTextField>();
        int numBoxes = -1;
        while(numBoxes == -1){
            int tryNum;
            try {
                tryNum = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Number of Blanks in the Code Problem?"));
                numBoxes = tryNum;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Insert a number please");
            }
        }
        blanksPanel.setLayout(new GridLayout(numBoxes,0));
        for(int i = 0; i < numBoxes; i++){
            RoundedTextField temp = new RoundedTextField(100);
            blanksPanel.add(temp);
            textList.add(temp);
        }

        // panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(0,2));
        submitButton = new RoundedButton("Submit",25);
        returnButton = new RoundedButton("Return",25);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String questionText = outputArea.getText();
                String answerText = "";
                for(RoundedTextField textField: textList){
                    answerText += textField.getText() + "\n";
                }

                System.out.println(questionText);
                System.out.print(answerText);
            }
        });
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Repository.getInstance().clear();
                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.TeacherView);
            }
        });

        buttonPanel.add(returnButton);
        buttonPanel.add(submitButton);

        JPanel bottomLeftPanel = new JPanel(new BorderLayout());
        bottomLeftPanel.add(blanksPanel,BorderLayout.CENTER);
        bottomLeftPanel.add(buttonPanel,BorderLayout.SOUTH);

        leftPanel.setLayout(new GridLayout(2,0));
        leftPanel.add(scrollPane);
        leftPanel.add(bottomLeftPanel);

        add(leftPanel);
        add(rightPanel);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
