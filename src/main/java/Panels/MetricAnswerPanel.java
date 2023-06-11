package Panels;

import javax.swing.*;
import java.awt.*;

public class MetricAnswerPanel extends JPanel {
    private int loc;
    private int eloc;
    private int lloc;
    private int cc;
    public MetricAnswerPanel(){
        setBackground(PanelConstants.CUSTOM_WHITE);
        GridLayout metricLayout = new GridLayout(4, 1);
        this.setLayout(metricLayout);
        // loc
        JLabel locLabel = new JLabel("Loc: ");
        JTextField locField = new JTextField(10);
        JPanel locPanel = new JPanel();
        locPanel.add(locLabel);
        locPanel.add(locField);
        this.add(locPanel);
        // eloc
        JLabel elocLabel = new JLabel("eLoc: ");
        JTextField elocField = new JTextField(10);
        JPanel elocPanel = new JPanel();
        elocPanel.add(elocLabel);
        elocPanel.add(elocField);
        this.add(elocPanel);
        // lloc
        JLabel llocLabel = new JLabel("lLoc: ");
        JTextField llocField = new JTextField(10);
        JPanel llocPanel = new JPanel();
        llocPanel.add(llocLabel);
        llocPanel.add(llocField);
        this.add(llocPanel);
        // cc
        JLabel ccLabel = new JLabel("cc: ");
        JTextField ccField = new JTextField(10);
        JPanel ccPanel = new JPanel();
        ccPanel.add(ccLabel);
        ccPanel.add(ccField);
        this.add(ccPanel);
    }

}
