package Panels;

import Handlers.PanelHandler;
import Problem_Engine.CodeProblemDepot;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class CodeEntryPanel extends JPanel {

    private JButton nextButton; // New button for "Next"
    int hintCounter = 0;

    public CodeEntryPanel() {
        //FlowLayout fl = new FlowLayout();
        setBackground(PanelConstants.CUSTOM_WHITE);
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(box);

        JLabel title = new JLabel("Code entry area:");
        title.setFont(new Font("Dialog", Font.BOLD, 16));
        title.setForeground(PanelConstants.CUSTOM_GREY);
        add(title);

        CodeProblemDepot codeProblemDepot = CodeProblemDepot.getInstance();

        int amt = codeProblemDepot.getCurrentProblem().getNumberOfAnswer();
        List<RoundedTextField> textFieldList = new ArrayList<>();

        for (int i = 1; i <= amt; i++) {
            JLabel num = new JLabel(i + ".");
            add(num);
            RoundedTextField codeEnter = new RoundedTextField(15);
            codeEnter.setFont(CodePanel.fontCode);
            add(codeEnter);
            textFieldList.add(codeEnter);
        }
        JButton submit = new RoundedButton("Submit",25);
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the submit button is pressed

                // Retrieve the entered text from the text fields and add them to a String array
                String[] enteredTextArray = new String[textFieldList.size()];
                for (int i = 0; i < textFieldList.size(); i++) {
                    RoundedTextField textField = textFieldList.get(i);
                    String enteredText = textField.getText().trim();
                    enteredTextArray[i] = enteredText;
                }

                if (codeProblemDepot.getCurrentProblem().compareAnswers(enteredTextArray)) {
                    for (RoundedTextField textField : textFieldList) {
                        textField.setBoxColor(new Color(24,99,14));
                    }
                    // Show the "Next" button
                    nextButton.setVisible(true);
                } else {
                    List<String> wrongAnswers =
                        Arrays.asList(codeProblemDepot.getCurrentProblem().getDifferentElements(enteredTextArray));
                    for (RoundedTextField textField : textFieldList) {
                        if(wrongAnswers.contains(textField.getText())){
                            textField.setBoxColor(new Color(133,9,9));
                        }else{
                            textField.setBoxColor(new Color(24,99,14));
                        }
                    }
                }
            }
        });

        // Create the "Next" button and hide it initially
        nextButton = new RoundedButton("Next",25);
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

        //Create get hint button
        // Create the "Next" button and hide it initially
        RoundedButton hintButton = new RoundedButton("Get hint",25);
        hintButton.setVisible(true);
        add(hintButton);

        // Add action listener to the hint button
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the hint button is clicked
                String[] hints =CodeProblemDepot.getInstance().getCurrentProblem().getHints();

                if (hintCounter < 2){
                    JOptionPane.showMessageDialog(
                        title, hints[hintCounter]);
                    hintCounter++;
                }else{
                    JOptionPane.showMessageDialog(
                        title, hints[hintCounter]);
                    hintCounter =0;
                }

            }
        });
    }
}
