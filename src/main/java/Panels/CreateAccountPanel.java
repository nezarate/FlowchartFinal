package Panels;

import Database.DB;
import Handlers.PanelHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class CreateAccountPanel extends WorkingPanel{
    private JLabel usernameLabel, passwordLabel, headerLabel, roleLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton, loginButton;
    private JRadioButton teacherButton, studentButton;
    private Boolean student = true;

    public CreateAccountPanel() {
        setLayout(new GridBagLayout()); // sets the layout of the panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // adds some padding around the elements

        // creates the labels, text fields, and button
        headerLabel = new JLabel("Create Your Account");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        roleLabel = new JLabel("Role:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        submitButton = new JButton("Submit");
        loginButton = new JButton("Back To Login");
        teacherButton = new JRadioButton("Teacher");
        studentButton = new JRadioButton("Student");
        studentButton.setSelected(true);
        ButtonGroup roleButtons = new ButtonGroup();
        roleButtons.add(teacherButton);
        roleButtons.add(studentButton);

        // adds the components to the panel
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(headerLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(usernameLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add(usernameField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(roleLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        add(studentButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        add(teacherButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        add(submitButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        add(loginButton, gbc);

        // adds an ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(DB.createAccount(usernameField.getText(), String.valueOf(passwordField.getPassword()), student)){
                    PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.Login);
                    JOptionPane.showMessageDialog(CreateAccountPanel.this, "Success");
                }else{
                    JOptionPane.showMessageDialog(CreateAccountPanel.this, "Username Taken");
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.Login);
            }
        });
        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Student role selected");
                student = true;
            }
        });
        teacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Teacher role selected");
                student = false;
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
