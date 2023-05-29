package Panels;

import Handlers.ControlHandler;

import javax.swing.*;
import java.awt.*;

public class TutorPanel extends JPanel {
    private JLabel duck;
    private JLabel hintLabel;
    private JButton button;
    private int duckPatience = 10;

    public TutorPanel(){
        GridLayout tutorLayout = new GridLayout(2, 1);
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
        hintPanel.setLayout(hintLayout);
        this.hintLabel = new JLabel("  Hints Shown Here");
        hintPanel.add(hintLabel, BorderLayout.CENTER);
        this.button = new JButton("Get Hint");
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

    public void updateDuck(){
        if(this.duckPatience > 8){
            setDuckImage("resources/ducky.png");
        }
        else if(this.duckPatience >= 6){
            setDuckImage("resources/annoyed_ducky.png");
        }
        else if(this.duckPatience >= 4){
            setDuckImage("resources/mad_ducky.png");
        }
        else{
            setDuckImage("resources/thumbs_down_ducky.png");
        }
    }
}
