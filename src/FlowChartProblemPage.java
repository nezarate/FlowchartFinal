import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * This FlowChartProblemPage class represents the JFrame with all elements of a coding problem page on it
 * @author Jacob Balikov, Giovanni Librizzi, Jin Wu, Amogh Prajapat, Stefan Lutsch
 */
public class FlowChartProblemPage extends JFrame{
    public FlowChartProblemPage(){
        // Initializing all JPanels
        JPanel tutorPanel = new JPanel();
        JPanel chatPanel = new JPanel();
        JPanel typePanel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel codePanel = new JPanel();
        JPanel submitPanel = new JPanel();
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
        GridLayout leftLayout = new GridLayout(3, 1);
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
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("resources/ducky.png"));
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        duckTutor.setIcon(imageIcon);
        tutorPanel.add(duckTutor);
        // Tutor Panel Hints
        JLabel hints = new JLabel("  Hints Shown Here");
        tutorPanel.add(hints);

        // Chat Panel
        JLabel chatOut = new JLabel("  ChatGPT Output Here");
        chatPanel.add(chatOut);

        // Type Panel
        JLabel chatIn = new JLabel("  ChatGPT Input Here");
        typePanel.add(chatIn);

        // Code Panel
        JLabel codeIn = new JLabel("  Code Problem Here");
        codePanel.add(codeIn);

        // Submit Panel
        JLabel codeOut = new JLabel("  Code Problem Submit Here");
        submitPanel.add(codeOut);

        // Diagram Panel
        JLabel flowchartOut = new JLabel("  Flowchart Area Here ");
        diagramPanel.add(flowchartOut);

        // Adding sub panels to main panels
        leftPanel.add(tutorPanel);
        leftPanel.add(chatPanel);
        leftPanel.add(typePanel);

        midPanel.add(codePanel);
        midPanel.add(submitPanel);

        // Adding main 3 panels to Page
        this.add(leftPanel);
        this.add(midPanel);
        this.add(diagramPanel);

    }

    // Used to test this Page
//    public static void main(String args[]){
//        FlowChartProblemPage main = new FlowChartProblemPage();
//        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        main.setSize(800, 650);
//        main.setVisible(true);
//    }


}
