package CompilerLab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Editor extends JFrame {

    private JTextArea codeTextArea;
    private JPanel flowchartPanel;

    public Editor() {
        setTitle("Flowchart Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left section with textarea and submit button
        JPanel leftPanel = new JPanel(new BorderLayout());

        codeTextArea = new JTextArea();
        codeTextArea.setLineWrap(true);
        codeTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(codeTextArea);


        leftPanel.add(scrollPane, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = codeTextArea.getText();
                //Method triggered when the submit Button is pressed
                
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        JLabel leftTitleLabel = new JLabel("Enter your code here");
        leftTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(leftTitleLabel, BorderLayout.NORTH);

        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Right section with empty panel for flowchart result
        JPanel rightPanel = new JPanel(new BorderLayout());

        JLabel rightTitleLabel = new JLabel("Flowchart Result");
        rightTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rightPanel.add(rightTitleLabel, BorderLayout.NORTH);

        flowchartPanel = new JPanel();
        rightPanel.add(flowchartPanel, BorderLayout.CENTER);

        // Add left and right sections to the main frame
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);


        splitPane.setResizeWeight(0.2);
        add(splitPane, BorderLayout.CENTER);


        // Increase the size of the window
        setPreferredSize(new Dimension(800, 600));
        pack();
        setLocationRelativeTo(null);
    }


}
