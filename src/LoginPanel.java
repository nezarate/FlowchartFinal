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

        // adds an ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.MainMenu);
                //switchPanel();
            }
        });
    }

    // the method to be called when the submit button is clicked
    private void switchPanel() {
        // add your code here
        usernameField.setText("");
        passwordField.setText("");

        // display an alert
        JOptionPane.showMessageDialog(this, "Logins has been successful", "Login",
            JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public void update(Observable o, Object arg) {

    }


}

