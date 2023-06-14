package Panels;

import Handlers.ControlHandler;
import java.awt.*;
import javax.swing.*;

public class TutorPanel extends JPanel {
    private JLabel duck;
    private JLabel hintLabel;
    private JButton button;
    private int duckPatience = 8;

    final String[] hints = new String[]{
            "   I am disappointed",
            "   Consider a different career path",
            "   Did you ask ChatGPT to write this?",
            "   Try harder",
            "   Have you changed anything since last time?",
            "   Maybe hit the books again?",
            "   Not Quite!",
            "   Almost There!"
    };

    public TutorPanel(){
        setBackground(PanelConstants.CUSTOM_WHITE);
        GridLayout tutorLayout = new GridLayout(2, 2);
        this.setLayout(tutorLayout);
        // Ducky
        ImageIcon imageIcon = new javax.swing.ImageIcon("resources/ducky.png");
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        this.duck = new JLabel();
        duck.setIcon(imageIcon);
        this.add(duck);
        // Hints
        BorderLayout hintLayout = new BorderLayout();
        JPanel hintPanel = new JPanel();
        hintPanel.setBackground(PanelConstants.CUSTOM_WHITE);
        hintPanel.setLayout(hintLayout);
        this.hintLabel = new JLabel("  Click for a motivation!");
        hintLabel.setForeground(PanelConstants.CUSTOM_BLACK);
        hintLabel.setFont(new Font("Dialog", Font.BOLD, 12));

        hintPanel.add(hintLabel, BorderLayout.CENTER);
        this.button = new RoundedButton("Get Motivation",25);
        hintPanel.add(this.button, BorderLayout.LINE_END);
        this.add(hintPanel);
    }

    public void setPatience(int num){
        this.duckPatience = num;
    }

    public int getDuckPatience(){
        return this.duckPatience;
    }

    public void setControlHandler(ControlHandler handler){
        this.button.addMouseListener(handler);
    }

    public void setDuckImage(String filename){
        ImageIcon imageIcon = new javax.swing.ImageIcon(filename);
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        duck.setIcon(imageIcon);
    }

    public String[] getHints(){
        return this.hints;
    }

    public void setText(String text){
        this.hintLabel.setText(text);
    }

    public void updateDuck(){
        if(this.duckPatience > 5){
            setDuckImage("resources/ducky.png");
        }
        else if(this.duckPatience >= 3){
            setDuckImage("resources/annoyed_ducky.png");
        }
        else if(this.duckPatience >= 1){
            setDuckImage("resources/mad_ducky.png");
        }
        else{
            setDuckImage("resources/thumbs_down_ducky.png");
        }
    }
}
