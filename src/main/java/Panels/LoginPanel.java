package Panels;
import Database.DB;
import Handlers.PanelHandler;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;

/**
 * Login Panel class which creates the panel for the user login
 *
 * @author Stefan Lutsch
 */
public class LoginPanel extends WorkingPanel {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton createAccountButton;

    public LoginPanel() {
        setLayout(new GridBagLayout()); // sets the layout of the panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // adds some padding around the elements

        // creates the labels, text fields, and button
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        submitButton = new JButton("Submit");
        createAccountButton = new JButton("New? Create An Account");

        // adds the components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(submitButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(createAccountButton, gbc);

        // adds an ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(DB.login(usernameField.getText(), String.valueOf(passwordField.getPassword()))){
                    PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.MainMenu);
                    JOptionPane.showMessageDialog(LoginPanel.this, "Success");
                }else{
                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid Credentials");
                    passwordField.setText("");
                }
            }
        });
        // adds an ActionListener to the createAccount button
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.CreateAccount);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }


}

