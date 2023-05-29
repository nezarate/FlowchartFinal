package Handlers;

import Panels.ChatGPTResponsePanel;
import Panels.TutorPanel;

import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class ChatGPTControl extends ControlHandler {
    private ChatGPTResponsePanel responsePanel;
    public ChatGPTControl(ChatGPTResponsePanel responsePanel){
        super();
        this.responsePanel = responsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String input = responsePanel.getInputField().getText();
        String output = "Sorry, something went wrong";
        try {
            output = responsePanel.getChatGPTResponse(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        StyledDocument doc = responsePanel.getOutputArea().getStyledDocument();
        Style styleRed = responsePanel.getOutputArea().addStyle("Red", null);
        StyleConstants.setForeground(styleRed, Color.RED);
        Style styleBlue = responsePanel.getOutputArea().addStyle("Blue", null);
        StyleConstants.setForeground(styleRed, Color.BLUE);
        try {
            doc.insertString(doc.getLength(), "You: " + input + "\n", styleRed);
            doc.insertString(doc.getLength(), "ChatGPT: " + output + "\n", styleBlue);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
        responsePanel.getInputField().setText("");
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
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