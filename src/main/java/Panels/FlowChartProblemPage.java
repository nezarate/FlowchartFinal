package Panels;
import Handlers.PanelHandler;
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
    public FlowChartProblemPage(){
        // Initializing all JPanels
        JPanel tutorPanel = new JPanel();
        JPanel chatPanel = new ChatGPTResponsePanel();
        JPanel typePanel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel codePanel = new CodeBlanksPanel();
        JPanel submitPanel = new CodeEntryPanel();
        JPanel diagramPanel = new JPanel();


        // Setting up borders for JPanels
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
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
        GridLayout tutorLayout = new GridLayout(2, 1);

        // Applying gridlayouts to JPanels
        this.setLayout(mainLayout);
        leftPanel.setLayout(leftLayout);
        midPanel.setLayout(midLayout);
        tutorPanel.setLayout(tutorLayout);

        // Setting up sub panels

        // Tutor Panel
        JLabel duckTutor = new JLabel();
        ImageIcon imageIcon = new javax.swing.ImageIcon("resources/ducky.png");
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        duckTutor.setIcon(imageIcon);
        tutorPanel.add(duckTutor);
        // Tutor Panel Hints
        JLabel hints = new JLabel("  Hints Shown Here");
        tutorPanel.add(hints);

        // Code Panel
        JLabel codeIn = new JLabel("  Code Problem Here");
        //codePanel.add(codeIn);

        // Submit Panel
        JLabel codeOut = new JLabel("  Code Problem Submit Here");
        //submitPanel.add(codeOut);

        // Diagram Panel
        JLabel flowchartOut = new JLabel("  Flowchart Area Here ");
        diagramPanel.add(flowchartOut);

        // Adding sub panels to main panels
        leftPanel.add(tutorPanel);
        leftPanel.add(chatPanel);

        midPanel.add(codePanel);
        midPanel.add(submitPanel);

        // Adding main 3 panels to Page
        this.add(leftPanel);
        this.add(midPanel);
        this.add(diagramPanel);
        JButton back = new JButton("Back");
        submitPanel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.MainMenu);
                //switchPanel();
            }
        });

    }

    @Override
    public void update(Observable o, Object arg) {

    }




}

