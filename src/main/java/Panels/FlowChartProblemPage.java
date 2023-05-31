package Panels;
import Handlers.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * This Panels.FlowChartProblemPage class represents the JPanel with all elements of a coding problem page on it
 * @author Jacob Balikov, Giovanni Librizzi, Jin Wu, Amogh Prajapat, Stefan Lutsch
 */
public class FlowChartProblemPage extends WorkingPanel {
    WorkingPanel diagramPanel;
    HintControl hintControl;
    ChatGPTControl chatGPTControl;
    public FlowChartProblemPage(){
        // Initializing all JPanels
        TutorPanel tutorPanel = new TutorPanel();
        ChatGPTResponsePanel chatPanel = new ChatGPTResponsePanel();
        JPanel typePanel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel codePanel = new CodeBlanksPanel();
        JPanel submitPanel = new CodeEntryPanel();
        diagramPanel = new Workspace();

        //Repository.getInstance().addObserver(diagramPanel);
        DiagramControl c = new DiagramControl();
        //diagramPanel.addMouseListener(c);
        //diagramPanel.addMouseMotionListener(c);
        //PanelHandler.getInstance().InitWorkspace(diagramPanel);


        // Setting up borders for JPanels
        Border blackBorder = BorderFactory.createLineBorder(PanelConstants.CUSTOM_BLACK);
        tutorPanel.setBorder(blackBorder);
        chatPanel.setBorder(blackBorder);
        typePanel.setBorder(blackBorder);
        leftPanel.setBorder(blackBorder);
        midPanel.setBorder(blackBorder);
        codePanel.setBorder(blackBorder);
        submitPanel.setBorder(blackBorder);
        diagramPanel.setBorder(blackBorder);


        // Setting up gridlayouts for all 3 sections (and tutor section)
        GridLayout leftLayout = new GridLayout(2, 1);
        GridLayout midLayout = new GridLayout(2, 1);
        GridLayout mainLayout = new GridLayout(1, 3);

        // Applying gridlayouts to JPanels
        this.setLayout(mainLayout);
        leftPanel.setLayout(leftLayout);
        midPanel.setLayout(midLayout);

        // Setting up sub panels

        // Code Panel
        JLabel codeIn = new JLabel("  Code Problem Here");
        //codePanel.add(codeIn);

        // Submit Panel
        JLabel codeOut = new JLabel("  Code Problem Submit Here");
        //submitPanel.add(codeOut);

        // Diagram Panel
        JLabel flowchartOut = new JLabel("  Flowchart Area Here ");
        //diagramPanel.add(flowchartOut);

        // Adding sub panels to main panels
        leftPanel.add(tutorPanel);
        leftPanel.add(chatPanel);

        midPanel.add(codePanel);
        midPanel.add(submitPanel);

        // Adding main 3 panels to Page
        Repository.getInstance().clear();
        SaveManager.getSaveManager().load("test");
        this.add(leftPanel);
        this.add(midPanel);
        this.add(diagramPanel);
        JButton back = new RoundedButton("Back",25);
        submitPanel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println(e.getActionCommand());

                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.MainMenu);
                //switchPanel();


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

    public Point getDiagramLocation() {
        return diagramPanel.getLocation();
    }



}

