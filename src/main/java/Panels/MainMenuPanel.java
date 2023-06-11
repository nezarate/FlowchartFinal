package Panels;
import Handlers.PanelHandler;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * This Panels.MainMenuPanel class represents the JPanel with two navigation buttons that bring
 * you to either the Panels.FlowChartProblemPage or the CodingProblemPage
 * @author Jacob Balikov, Giovanni Librizzi, Jin Wu, Amogh Prajapat, Stefan Lutsch
 */
public class MainMenuPanel extends WorkingPanel {
    public MainMenuPanel(){
        // Initializing all JPanels
        int i = 3;
        int j = 3;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i,j));
        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
                JPanel tempPanel = new JPanel();
                tempPanel.setBackground(PanelConstants.CUSTOM_WHITE);
                panelHolder[m][n] = tempPanel;
                add(panelHolder[m][n]);
            }
        }

        // Setting up borders for JPanels
//        Border blackBorder = BorderFactory.createLineBorder(Color.black);
//        panelHolder[1][1].setBorder(blackBorder);
//        setBorder(blackBorder);

        // Setting up sub panels

        // panelHolder[0][0]
        Color color = PanelConstants.CUSTOM_GREY;
        JLabel productNameLabel = new JLabel("<html><u>BasicCodeGenius</u></html>");
        productNameLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        productNameLabel.setForeground(color);
        JLabel productDescriptionLabel = new JLabel("Your Friendly Coding Tutor");
        productDescriptionLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        productDescriptionLabel.setForeground(color);
        panelHolder[0][0].add(productNameLabel);
        panelHolder[0][0].add(productDescriptionLabel);

        // panelHolder[0][1]
        panelHolder[0][1].setLayout(new GridLayout(2, 2));
        panelHolder[0][1].add(new JLabel());
        panelHolder[0][1].add(new JLabel());
        JLabel duckTutor = new JLabel();
        ImageIcon imageIcon = new javax.swing.ImageIcon("resources/ducky.png");
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        duckTutor.setIcon(imageIcon);
        panelHolder[0][1].add(duckTutor);
        JLabel selectOptionLabel = new JLabel("<html>Please Select<br/>an Option</html>");
        selectOptionLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        selectOptionLabel.setForeground(color);
        panelHolder[0][1].add(selectOptionLabel);

        // panelHolder[1][1]
        panelHolder[1][1].setLayout(new GridLayout(3, 1));
        JButton flowProbButton = new RoundedButton("Work On FlowChart Problem",25);
        JButton codeProbButton = new RoundedButton("Work On Coding Problem",25);
        JButton codeMetricButton = new RoundedButton("Work On Code Metric Problem", 25);
        panelHolder[1][1].add(flowProbButton);
        panelHolder[1][1].add(codeProbButton);
        panelHolder[1][1].add(codeMetricButton);

        // panelHolder[2][2]
        panelHolder[2][2].setLayout(new BorderLayout());
        JButton logoutButton = new RoundedButton("Logout", 25);
        panelHolder[2][2].add(logoutButton, BorderLayout.SOUTH);

        codeProbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.FlowChartProblem);
            }
        });

        flowProbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.CodeProblem);
            }
        });

        codeMetricButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.CodeMetricProblem);
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.Login);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }


}
