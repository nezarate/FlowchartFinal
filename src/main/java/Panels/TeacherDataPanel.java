package Panels;
import Handlers.PanelHandler;
import Handlers.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class TeacherDataPanel extends WorkingPanel{

    private JTextPane outputArea;
    private RoundedButton queryButton;
    private RoundedButton returnButton;
    private JCheckBox userNameCheck;
    private boolean userChecked;
    private JCheckBox problemCheck;
    private boolean problemChecked;
    private RoundedTextField userNameField;
    private RoundedTextField problemField;
    private WorkingPanel rightPanel;
    public TeacherDataPanel() {
        setBackground(PanelConstants.CUSTOM_WHITE);
        setLayout(new GridLayout(0,2));

        outputArea = new JTextPane();
        outputArea.setEditable(false);
        outputArea.setContentType("text/html");
        outputArea.setBackground(getBackground());
        outputArea.setBorder(null);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI(PanelConstants.CUSTOM_BLACK, PanelConstants.CUSTOM_WHITE));

        JPanel leftPanel = new JPanel(new GridLayout(2,0));
        JPanel leftTop = new JPanel((new GridLayout(0,2)));
        JPanel leftBottom = new JPanel(new BorderLayout());

        ImageIcon imageIcon = new javax.swing.ImageIcon("resources/ducky.png");
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        JLabel duck = new JLabel();
        duck.setIcon(imageIcon);

        JLabel productNameLabel = new JLabel("Data View");
        productNameLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        productNameLabel.setForeground(PanelConstants.CUSTOM_GREY);

        leftTop.add(duck);
        leftTop.add(productNameLabel);

        // panel for checkList
        JPanel checkListPanel = new JPanel(new GridLayout(2,2));
        userNameCheck = new JCheckBox("Query By UserName");
        problemCheck = new JCheckBox("Query By Problem Number");
        userNameField = new RoundedTextField(100);
        problemField = new RoundedTextField(100);
        checkListPanel.add(userNameCheck);
        checkListPanel.add(userNameField);
        checkListPanel.add(problemCheck);
        checkListPanel.add(problemField);

        userNameCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userChecked = userNameCheck.isSelected();
            }
        });
        problemCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                problemChecked = problemCheck.isSelected();
            }
        });

        // panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(0,2));
        queryButton = new RoundedButton("Submit",25, PanelConstants.CUSTOM_GREY, PanelConstants.CUSTOM_WHITE);
        returnButton = new RoundedButton("Return",25, PanelConstants.CUSTOM_GREY, PanelConstants.CUSTOM_WHITE);

        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(userChecked && problemChecked){
                    System.out.println("Querying by both userName and problemChecked");
                    System.out.println("userName: " + userNameField.getText() + ", problem: " + problemField.getText());
                } else {
                    if(userChecked){
                        System.out.println("Querying by both userName");
                        System.out.println("userName: " + userNameField.getText());
                    }
                    if(problemChecked){
                        System.out.println("Querying by problem");
                        System.out.println("problem: " + problemCheck.getText());
                    }
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.TeacherView);
            }
        });

        buttonPanel.add(returnButton);
        buttonPanel.add(queryButton);
        leftBottom.add(buttonPanel, BorderLayout.SOUTH);
        leftBottom.add(checkListPanel,BorderLayout.CENTER);

        leftPanel.add(leftTop);
        leftPanel.add(leftBottom);

        add(leftPanel);
        add(scrollPane);

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
