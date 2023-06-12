package Handlers;
import Shapes.Flowchart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ControlHandler - detects actions being performed
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class MenuBarControl implements ActionListener {


    public MenuBarControl() {

    }

    /**
     * Checks actions that can be performed by the users and executes the appropriate action
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handling all MenuOptions
        switch(e.getActionCommand()){
            case "Submit": // TODO: MOVE THIS TO NEW CONTROLHANDLER CLASS!!!! MAKE CONTROLHANDLER ABSTRACT AND MOVE EVERYTHING ELSE TO FLOWCHART CONTROL HANDLER
                PanelHandler.getInstance().switchWorkingPanel(PanelHandler.Panel.FlowChartProblem);
                System.out.println("CHANGE!");
                break;
            case "Clear":
                Repository.getInstance().clear();
                break;
            case "Save file":
                String saveFile = JOptionPane.showInputDialog("Enter File Name:");
                SaveManager.getSaveManager().save(saveFile);
                break;
            case "Load file":
                String loadFile = JOptionPane.showInputDialog("Enter File to Load:");
                //Repository.getInstance().add(SaveManager.getSaveManager().load(loadFile));
                //Flowchart fltest = SaveManager.getSaveManager().load("test");
                Repository.getInstance().clear();

                Repository.getInstance().add(SaveManager.getSaveManager().load(loadFile));
                //fl.compare(fltest);
                break;
            case "Call a Method":
                // Shapes.RectangleToolMethod
                Repository.getInstance().setShapeSelection("RectangleToolMethod");
                break;
            case "Instruction":
                //Shapes.RectangleStandard
                Repository.getInstance().setShapeSelection("RectangleStandard");
                break;
            case "Input or Output":
                // Shapes.Parallelogram
                Repository.getInstance().setShapeSelection("Parallelogram");
                break;
            case "Variable Declaration":
                // Shapes.RectangleToolVariable
                Repository.getInstance().setShapeSelection("RectangleToolVariable");
                break;
            case "Condition":
                // Shapes.Diamond
                Repository.getInstance().setShapeSelection("Diamond");
                break;

            case "About":
                JOptionPane.showMessageDialog(null, "Authors of the project are: Jacob Balikov, Giovanni Librizzi, \nNicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat");
                break;
        }
    }

}

