package Handlers;
import Shapes.*;
import Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ControlHandler - detects actions being performed
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class DiagramControl implements MouseListener, MouseMotionListener {
    int shapeExists = -1;
    int draggingShapeExists = -1;
    int unRemovableShapeExists = -1;

    public DiagramControl() {

    }



    private int shapeSelected(MouseEvent e){
        int shapeIndex = -1;
        for (int i = 0; i < Repository.getInstance().shapesSize(); i++){
            if(Repository.getInstance().getShape(i).checkClick(e.getX(), e.getY())){
                //System.out.println("BRUH" + Handlers.Repository.getInstance().getShape(i).getX());
                shapeIndex = i;
            }
        }
        //System.out.println("SHAPE Selcted"+ shapeIndex);
        return shapeIndex;
    }
    private int unRemovableShapeSelected(MouseEvent e){
        int shapeIndex = -1;
        for (int i = 0; i < Repository.getInstance().getUnremovableShape().size(); i++){
            if(Repository.getInstance().getUnremovableShape(i).checkClick(e.getX(), e.getY())){
                //System.out.println("BRUH" + Handlers.Repository.getInstance().getShape(i).getX());
                shapeIndex = i;
            }
        }
        //System.out.println("SHAPE Selcted"+ shapeIndex);
        return shapeIndex;
    }

    /**
     * Checks the current available actions to the user after they click and executes accordingly
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int selectedShape = shapeSelected(e);
        int unRemovableSelectedShape = unRemovableShapeSelected(e);
        Repository repo = Repository.getInstance();

        if(unRemovableSelectedShape != -1){
            if(shapeExists != -1){
                String connection = JOptionPane.showInputDialog("Enter Connection:");
                Repository.getInstance().add(new ConnectingLine(repo.getShape(shapeExists), repo.getUnremovableShape(unRemovableSelectedShape), connection));
                shapeExists = -1;
            } else {
                // begin or end selected
                unRemovableShapeExists = unRemovableSelectedShape;
            }
            return;
        }

        if(selectedShape >= 0){
            if(shapeExists != -1){
                if(shapeExists == selectedShape){
                    // ask for a new label - same shape collected
                    String newLabel = JOptionPane.showInputDialog("New Description:");
                    repo.getShape(shapeExists).setLabel(newLabel);
                    repo.moved();
                } else{
                    // make a connection - different shapes selected
                    String connection = JOptionPane.showInputDialog("Enter Connection:");
                    Repository.getInstance().add(new ConnectingLine(repo.getShape(shapeExists), repo.getShape(selectedShape), connection));
                }
                shapeExists = -1;
            } else if(unRemovableShapeExists != -1){
                // make a connection between an unremovable object
                String connection = JOptionPane.showInputDialog("Enter Connection:");
                Repository.getInstance().add(new ConnectingLine(repo.getUnremovableShape(unRemovableShapeExists), repo.getShape(selectedShape), connection));
                unRemovableShapeExists = -1;
            } else{
                // selecting a shape
                shapeExists = selectedShape;
                unRemovableShapeExists = -1;
            }
        } else{
            // no shape selected
            String label = JOptionPane.showInputDialog("Enter Description:");
            int x = e.getX();
            int y = e.getY();
            System.out.println("Draw " + Repository.getInstance().getShapeSelection() + " at " + x + ", " + y);
            switch (Repository.getInstance().getShapeSelection()) {
                case "RectangleToolMethod":
                    Repository.getInstance().add(new RectangleToolMethod(x, y, label));
                    break;
                case "RectangleStandard":
                    Repository.getInstance().add(new RectangleStandard(x, y, label));
                    break;
                case "Parallelogram":
                    Repository.getInstance().add(new Parallelogram(x, y, label));
                    break;
                case "RectangleToolVariable":
                    Repository.getInstance().add(new RectangleToolVariable(x, y, label));
                    break;
                case "Diamond":
                    Repository.getInstance().add(new Diamond(x, y, label));
                    break;
            }
        }
    }

    /**
     * Selects a shape that will be dragged if applicable
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        draggingShapeExists = shapeSelected(e);

    }

    /**
     * Releases a dragged shape
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        draggingShapeExists = -1;
    }

    /**
     * Live update a dragged shape if applicable
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (draggingShapeExists != -1 ) {
            Shape shape = Repository.getInstance().getShape(draggingShapeExists);
            shape.relocate(e.getX(), e.getY());
            Repository.getInstance().moved();
            //System.out.println(Repository.getInstance().getShape(draggingShapeExists).getX());
        }

        else{
            //System.out.println("YO");
            return;
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}

