import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;

public class ControlHandler implements ActionListener, MouseListener, MouseMotionListener {
    boolean hasSelected = false;
    Rectangle selectedRectangle = null;
    Shape selectedShape = null;

    Shape secondShape = null;


    @Override
    public void actionPerformed(ActionEvent e) {
        // Handling all MenuOptions
        switch(e.getActionCommand()){
            case "Clear":
                Repository.getInstance().clear();
                break;
            case "Save file":
                SaveManager.getSaveManager().save("test");
                System.out.println("Implement Save Method");
                break;
            case "Load file":
                SaveManager.getSaveManager().load("test");
                System.out.println("Implement Load Method");
                break;
            case "Call a Method":
                // RectangleToolMethod
                Repository.getInstance().setShapeSelection("RectangleToolMethod");
                break;
            case "Instruction":
                //RectangleStandard
                Repository.getInstance().setShapeSelection("RectangleStandard");
                break;
            case "Input or Output":
                // Parallelogram
                Repository.getInstance().setShapeSelection("Parallelogram");
                break;
            case "Variable Declaration":
                // RectangleToolVariable
                Repository.getInstance().setShapeSelection("RectangleToolVariable");
                break;
            case "Condition":
                // Diamond
                Repository.getInstance().setShapeSelection("Diamond");
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Repository repo = Repository.getInstance();

        // check to see if shape selected
        // NOTE: SINCE THESE ALL INHERIT FROM SHAPE NOW, 
        Rectangle findRect = repo.checkWithinRectangle(x, y);
        Shape findShape = repo.checkWithinShape(x, y, repo.getShapes());
        Shape findUnremovable = repo.checkWithinShape(x, y, repo.getUnremovableShape());



        if (hasSelected){

            // Object Selected Before - make a line

            // if the selected object is the same - then implement change label

        } else {
            // No Object Selected Before
            if (findUnremovable != null) {
                System.out.println("Unremovable shape selected; begin line creating");
                hasSelected = true;
                selectedShape = findShape;

            } else if (findRect != null ) {         // Rectangle clicked
                System.out.println("Rect selected; begin line creating");

                hasSelected = true;
                selectedRectangle = findRect;
            } else if (findShape != null){  // Shape clicked
                System.out.println("Shape selected; begin line creating");

                hasSelected = true;
                selectedShape = findShape;
            } else {                        // No objects clicked
                System.out.println("No objects clicked.");

                hasSelected = false;
                selectedRectangle = null;
                selectedShape = null;

                // No Object Selected at all - Make an Object

                String label = javax.swing.JOptionPane.showInputDialog("Enter Description:");
                // Generate Shape object to Draw
                System.out.println("Draw " + repo.getShapeSelection() + " at " + x + ", " + y);
                switch(repo.getShapeSelection()) {
                    case "RectangleToolMethod":
                        repo.add(new RectangleToolMethod(x,y, label));
                        break;
                    case "RectangleStandard":
                        repo.add(new RectangleStandard(x,y, label));
                        break;
                    case "Parallelogram":
                        repo.add(new Parallelogram(x,y, label));
                        break;
                    case "RectangleToolVariable":
                        repo.add(new RectangleToolVariable(x,y, label));
                        break;
                    case "Diamond":
                        repo.add(new Diamond(x,y,label));
                        break;
                }
            }
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Implement moving objects

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}

