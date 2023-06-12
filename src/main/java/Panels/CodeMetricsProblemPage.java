package Panels;
import Handlers.*;
import Shapes.ConnectingLine;
import Shapes.Flowchart;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;

/**
 * This Panels.FlowChartProblemPage class represents the JPanel with all elements of a coding problem page on it
 * @author Jacob Balikov, Giovanni Librizzi, Jin Wu, Amogh Prajapat, Stefan Lutsch
 */
public class CodeMetricsProblemPage extends WorkingPanel {
    WorkingPanel diagramPanel;
    HintControl hintControl;
    ChatGPTControl chatGPTControl;
    public CodeMetricsProblemPage(){
        // Initializing all JPanels
        TutorPanel tutorPanel = new TutorPanel();
        ChatGPTResponsePanel chatPanel = new ChatGPTResponsePanel();
        JPanel leftPanel = new JPanel();
        JPanel codePanel = new CodeBlanksPanel();
        JPanel rightPanel = new JPanel();
        JPanel metricAnswerPanel = new MetricAnswerPanel();
        JPanel submitBackPanel = new JPanel();

        //Repository.getInstance().addObserver(diagramPanel);
        DiagramControl c = new DiagramControl();

        // Setting up borders for JPanels
        Border blackBorder = BorderFactory.createLineBorder(PanelConstants.CUSTOM_BLACK);
        tutorPanel.setBorder(blackBorder);
        chatPanel.setBorder(blackBorder);
        leftPanel.setBorder(blackBorder);
        codePanel.setBorder(blackBorder);

        // Setting up gridlayouts for all 3 sections (and tutor section)
        GridLayout leftLayout = new GridLayout(2, 1);
        BorderLayout rightLayout = new BorderLayout();
        GridLayout mainLayout = new GridLayout(1, 3);

        // Applying gridlayouts to JPanels
        this.setLayout(mainLayout);
        leftPanel.setLayout(leftLayout);
        rightPanel.setLayout(rightLayout);

        // Adding sub panels to main panels
        leftPanel.add(tutorPanel);
        leftPanel.add(chatPanel);
        rightPanel.add(metricAnswerPanel, BorderLayout.CENTER);
        rightPanel.add(submitBackPanel, BorderLayout.SOUTH);

        // Adding main 3 panels to Page
        Repository.getInstance().clear();
        Repository.getInstance().add(SaveManager.getSaveManager().load("test"));
        this.add(leftPanel);
        this.add(codePanel);
        this.add(rightPanel);

        JButton submit = new RoundedButton("Submit",25);
        submitBackPanel.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submitted");
//                Flowchart fl = Repository.getInstance().getFlowchart();
//                Flowchart flExpected = SaveManager.getSaveManager().load("test");
//
//                List<ConnectingLine> issueAmt = fl.compare(flExpected);
//
//                if (issueAmt.size() > 0) {
//                    tutorPanel.setText("Found " + issueAmt.size() + " cases where a connection \nwasn't matched with the expected flowchart");
//                } else {
//                    tutorPanel.setText("No issues found!");
//                }

            }
        });

        JButton back = new RoundedButton("Back",25);
        submitBackPanel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println(e.getActionCommand());
                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.MainMenu);
            }
        });

        // Control Handler for Tutor Panel
        this.hintControl = new HintControl(tutorPanel);
        tutorPanel.setControlHandler(this.hintControl);

        // Control Handler for ChatGPT
        this.chatGPTControl = new ChatGPTControl(chatPanel);
        chatPanel.setControlHandler(this.chatGPTControl);

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}