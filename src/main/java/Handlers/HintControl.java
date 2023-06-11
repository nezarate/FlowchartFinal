package Handlers;

import Panels.TutorPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class HintControl extends ControlHandler {
    private TutorPanel tutorPanel;
    public HintControl(TutorPanel tutorPanel){
        super();
        this.tutorPanel = tutorPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {
        // Update Duck Image
        if(tutorPanel.getDuckPatience() != 0){
            tutorPanel.setPatience(tutorPanel.getDuckPatience() - 1);
        }
        tutorPanel.updateDuck();
        // Update Hint Panel
        tutorPanel.setText(tutorPanel.getHints()[tutorPanel.getDuckPatience()]);
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}
