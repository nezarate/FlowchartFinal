package Panels;

import Database.DB;
import Handlers.DiagramControl;
import Handlers.PanelHandler;
import Handlers.Repository;
import Handlers.SaveManager;
import Problem_Engine.MetricsCalculator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.Border;

public class TeacherProblemPanel extends WorkingPanel {

    Border blackBorder = BorderFactory.createLineBorder(PanelConstants.CUSTOM_BLACK);
    private JPanel leftPanel;
    private ArrayList<RoundedTextField> textList;
    private JTextPane outputArea;
    private RoundedButton submitButton;
    private RoundedButton returnButton;
    private WorkingPanel middlePanel;

    public TeacherProblemPanel() {
        setBackground(PanelConstants.CUSTOM_WHITE);
        GridLayout grid = new GridLayout(0, 3);
        setLayout(grid);
        leftPanel = new JPanel(); // Code Problem generated
        leftPanel.setBorder(blackBorder);
        middlePanel = new Workspace(); // FlowChart Problem generated

        // configure rightPanel
        Repository.getInstance().addObserver(middlePanel);
        DiagramControl c = new DiagramControl();
        middlePanel.addMouseListener(c);
        middlePanel.addMouseMotionListener(c);
        middlePanel.setBorder(blackBorder);

        // configure leftPanel

        // Text Area for writing Problem

        outputArea = new JTextPane();
        outputArea.setEditable(true);
        outputArea.setContentType("text");
        outputArea.setBackground(getBackground());
        outputArea.setBorder(blackBorder);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar()
            .setUI(new CustomScrollBarUI(PanelConstants.CUSTOM_BLACK, PanelConstants.CUSTOM_WHITE));

        // Text Area for the answers
        JPanel blanksPanel = new JPanel();
        textList = new ArrayList<RoundedTextField>();
        int numBoxes = -1;
        while (numBoxes == -1) {
            int tryNum;
            try {
                tryNum = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(
                    "Number of Blanks in the Code Problem?"));
                numBoxes = tryNum;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Insert a number please");
            }
        }
        blanksPanel.setLayout(new GridLayout(numBoxes, 0));
        for (int i = 0; i < numBoxes; i++) {
            RoundedTextField temp = new RoundedTextField(100);
            blanksPanel.add(temp);
            textList.add(temp);
        }

        // panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
        submitButton = new RoundedButton("Submit", 25);
        returnButton = new RoundedButton("Return", 25);


        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Repository.getInstance().clear();
                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.TeacherView);
            }
        });

        buttonPanel.add(returnButton);
        buttonPanel.add(submitButton);

        JPanel bottomLeftPanel = new JPanel(new BorderLayout());
        bottomLeftPanel.add(blanksPanel, BorderLayout.CENTER);
        bottomLeftPanel.add(buttonPanel, BorderLayout.SOUTH);

        leftPanel.setLayout(new GridLayout(2, 0));
        JPanel insertArea = new JPanel(new BorderLayout());
        JLabel textField = new JLabel("Problem");
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBackground(getBackground());
        insertArea.add(textField, BorderLayout.NORTH);
        insertArea.add(scrollPane, BorderLayout.CENTER);
        leftPanel.add(insertArea);
        leftPanel.add(bottomLeftPanel);

        add(leftPanel);
        add(middlePanel);

        //Right Panel
        JPanel rightPanel = new JPanel(new GridLayout(2, 1));
        //Hint Panel
        JPanel hintPanel = new JPanel(new GridLayout(4, 1));
        hintPanel.setBorder(blackBorder);
        JLabel hintLabel = new JLabel("Hint");
        hintLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField hint1 = new RoundedTextField(25);
        JTextField hint2 = new RoundedTextField(25);
        JTextField hint3 = new RoundedTextField(25);
        hintPanel.add(hintLabel);
        hintPanel.add(hint1);
        hintPanel.add(hint2);
        hintPanel.add(hint3);
        rightPanel.add(hintPanel);

        //Code Metrics Panel
        JPanel metricsPanel = new JPanel(new GridLayout(6, 1));
        metricsPanel.setBorder(blackBorder);
        JLabel metricsLabel = new JLabel("Metrics");
        metricsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel loc = new JLabel("LOC:");
        JLabel eLoc = new JLabel("eLOC:");
        JLabel lLOC = new JLabel("lLOC:");
        JLabel cc = new JLabel("CC:");
        RoundedButton calcButton = new RoundedButton("Calculate", 25);
        metricsPanel.add(metricsLabel);
        metricsPanel.add(loc);
        metricsPanel.add(eLoc);
        metricsPanel.add(lLOC);
        metricsPanel.add(cc);
        metricsPanel.add(calcButton);
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(outputArea.getText());
                int[] metrics = MetricsCalculator.calculateMetrics(outputArea.getText());
                loc.setText("LOC: " + metrics[0]);
                eLoc.setText("eLOC: " + metrics[1]);
                lLOC.setText("lLOC: " + metrics[2]);
                cc.setText("CC: " + metrics[3]);
            }
        });

        rightPanel.add(metricsPanel);

        add(rightPanel);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String questionText = outputArea.getText();
                StringBuilder answerText = new StringBuilder();
                for (RoundedTextField textField : textList) {
                    answerText.append(textField.getText()).append(":");
                }
                answerText.deleteCharAt(answerText.length()-1);
                int[] metrics = MetricsCalculator.calculateMetrics(questionText);
                String hintText = hint1.getText()+":"+hint2.getText()+":"+hint3.getText();

                DB.insertCodeProblem(questionText,answerText.toString(),hintText, SaveManager.getSaveManager()
                    .saveAsString(), metrics[0], metrics[1], metrics[2], metrics[3] );
                Repository.getInstance().clear();
                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.TeacherView);
                JOptionPane.showMessageDialog(
                    leftPanel, "Problem saved");
            }

        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
