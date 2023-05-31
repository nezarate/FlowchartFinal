package Panels;

import Handlers.PanelHandler;
import Problem_Engine.CodeProblemDepot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CodeEntryPanel extends JPanel {

    private JButton nextButton; // New button for "Next"

    public CodeEntryPanel() {
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(box);

        JLabel title = new JLabel("Code entry area:");
        add(title);

        CodeProblemDepot codeProblemDepot = CodeProblemDepot.getInstance();

        int amt = codeProblemDepot.getCurrentProblem().getNumberOfAnswer();
        List<JTextField> textFieldList = new ArrayList<>();

        for (int i = 1; i <= amt; i++) {
            JLabel num = new JLabel(i + ".");
            add(num);
            JTextField codeEnter = new JTextField(15);
            codeEnter.setFont(CodePanel.fontCode);
            add(codeEnter);
            textFieldList.add(codeEnter);
        }

        JButton submit = new JButton("Submit");
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the submit button is pressed
                // Add your logic here
                System.out.println("Submit button pressed!");

                // Retrieve the entered text from the text fields and add them to a String array
                String[] enteredTextArray = new String[textFieldList.size()];
                for (int i = 0; i < textFieldList.size(); i++) {
                    JTextField textField = textFieldList.get(i);
                    String enteredText = textField.getText();
                    enteredTextArray[i] = enteredText;
                }

                if (codeProblemDepot.getCurrentProblem().compareAnswers(enteredTextArray)) {
                    for (JTextField textField : textFieldList) {
                        textField.setBackground(Color.GREEN);
                    }
                    // Show the "Next" button
                    nextButton.setVisible(true);
                } else {
                    for (JTextField textField : textFieldList) {
                        textField.setBackground(Color.RED);
                    }
                }
            }
        });

        // Create the "Next" button and hide it initially
        nextButton = new JButton("Next");
        nextButton.setVisible(false);
        add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the "Next" button is pressed
                // Add your logic here
                codeProblemDepot.getNextProblem();
                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.FlowChartProblem);
            }
        });
    }
}
