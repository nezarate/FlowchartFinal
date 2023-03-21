import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;

public class ControlHandler implements ActionListener, MouseListener, MouseMotionListener {
    boolean hasSelected = false;

    int shapeExists = -1;
    int rectExists = -1;

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
    private int shapeSelected(MouseEvent e){
        int shapeIndex = -1;
        for (int i = 0; i < Repository.getInstance().shapeSize(); i++){
            if(Repository.getInstance().getShape(i).checkClick(e.getX(), e.getY())){
                System.out.println("BRUH" + Repository.getInstance().getShape(i).getX());
                shapeIndex = i;
            }
        }
        System.out.println("SHAPE Selcted"+ shapeIndex);
        return shapeIndex;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (shapeSelected(e) == -1){
            String label = JOptionPane.showInputDialog("Enter Description:");
            int x = e.getX();
            int y = e.getY();
            System.out.println("Draw " + Repository.getInstance().getShapeSelection() + " at " + x + ", " + y);
            switch (Repository.getInstance().getShapeSelection()) {
                case "RectangleToolMethod" ->
                        Repository.getInstance().add((Shape) new RectangleToolMethod(x, y, label));
                case "RectangleStandard" ->
                        Repository.getInstance().add((Shape) new RectangleStandard(x, y, label));
                case "Parallelogram" ->
                        Repository.getInstance().add(new Parallelogram(x, y, label));
                case "RectangleToolVariable" ->
                        Repository.getInstance().add((Shape) new RectangleToolVariable(x, y, label));
                case "Diamond" ->
                        Repository.getInstance().add(new Diamond(x, y, label));
            }
        }

    }


//    @Override
//    public void mouseClicked(MouseEvent e) {
//        int x = e.getX();
//        int y = e.getY();
//        Repository repo = Repository.getInstance();
//
//        Rectangle findRect = repo.checkWithinRectangle(x, y);
//        Shape findShape = repo.checkWithinShape(x, y, repo.getShapes());
//        Shape findUnremovable = repo.checkWithinShape(x, y, repo.getUnremovableShape());
//
//        if (hasSelected){
//
//        } else {
//            // No Object Selected Before
//            if (findUnremovable != null) {
//                System.out.println("Unremovable shape selected; begin line creating");
//                hasSelected = true;
//                selectedShape = findShape;
//
//            } else if (findRect != null ) {         // Rectangle clicked
//                System.out.println("Rect selected; begin line creating");
//
//                hasSelected = true;
//                selectedRectangle = findRect;
//            } else if (findShape != null){  // Shape clicked
//                System.out.println("Shape selected; begin line creating");
//
//                hasSelected = true;
//                selectedShape = findShape;
//            } else {                        // No objects clicked
//                System.out.println("No objects clicked.");
//
//                hasSelected = false;
//                selectedRectangle = null;
//                selectedShape = null;
//
//
//                String label = javax.swing.JOptionPane.showInputDialog("Enter Description:");
//                // Generate Shape object to Draw
//                System.out.println("Draw " + repo.getShapeSelection() + " at " + x + ", " + y);
//                switch(repo.getShapeSelection()) {
//                    case "RectangleToolMethod":
//                        repo.add((Rectangle) new RectangleToolMethod(x,y, repo.getSelectedColor(),label));
//                        break;
//                    case "RectangleStandard":
//                        repo.add((Rectangle) new RectangleStandard(x,y, repo.getSelectedColor(),label));
//                        break;
//                    case "Parallelogram":
//                        repo.add(new Parallelogram(x,y, repo.getSelectedColor(),label));
//                        break;
//                    case "RectangleToolVariable":
//                        repo.add((Rectangle) new RectangleToolVariable(x,y, repo.getSelectedColor(),label));
//                        break;
//                    case "Diamond":
//                        repo.add(new Diamond(x,y, repo.getSelectedColor(),label));
//                        break;
//                }
//            }
//        }
//
//
//    }

    @Override
    public void mousePressed(MouseEvent e) {
        shapeExists = shapeSelected(e);
        //rectExists = rectSelected(e);


        if (shapeExists >= 0) {
            Shape shape = Repository.getInstance().getShape(shapeExists);

            shape.relocate(e.getX(), e.getY());

            Repository.getInstance().moved();


        }
//        else if (shapeExists == -1 && rectExists >= 0){
//            Rectangle rect = Repository.getInstance().getRect(rectExists);
//            rect.relocate(e.getX(), e.getY());
//            Repository.getInstance().moved();
//            rectExists = rectSelected(e);
//            System.out.println("H2");
//        }
        else{

            return;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shapeExists = shapeSelected(e);

        if (shapeExists != -1 ) {
            Shape shape = Repository.getInstance().getShape(shapeExists);

            shape.relocate(e.getX(), e.getY());
            Repository.getInstance().moved();
            shapeExists = shapeSelected(e);

        }
//        else if (shapeExists == -1 && rectExists >= 0){
//            Rectangle rect = Repository.getInstance().getRect(rectExists);
//            rect.relocate(e.getX(), e.getY());
//            Repository.getInstance().moved();
//            rectExists = rectSelected(e);
//        }
        else{

            return;
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (shapeExists != -1 ) {
            Shape shape = Repository.getInstance().getShape(shapeExists);
            shape.relocate(e.getX(), e.getY());

            Repository.getInstance().moved();

            System.out.println(Repository.getInstance().getShape(shapeExists).getX());
        }
//        else if (shapeExists == -1 && rectExists >= 0){
//            Rectangle rect = Repository.getInstance().getRect(rectExists);
//            rect.relocate(e.getX(), e.getY());
//            Repository.getInstance().moved();
//
//        }
        else{
            System.out.println("YO");
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

