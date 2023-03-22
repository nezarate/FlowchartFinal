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
                String saveFile = JOptionPane.showInputDialog("Enter File Name:");
                SaveManager.getSaveManager().save(saveFile);
                break;
            case "Load file":
                String loadFile = JOptionPane.showInputDialog("Enter File to Load:");
                SaveManager.getSaveManager().load(loadFile);
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
                //System.out.println("BRUH" + Repository.getInstance().getShape(i).getX());
                shapeIndex = i;
            }
        }
        //System.out.println("SHAPE Selcted"+ shapeIndex);
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
                case "RectangleToolMethod":
                    Rectangle rect =  new RectangleStandard(x, y, label);
                    RectangleToolMethod rect1 = new RectangleToolMethod(x,y, label);
                    rect1.add(rect);
                    Repository.getInstance().add(rect1);
                    break;
                case "RectangleStandard":
                    Repository.getInstance().add(new RectangleStandard(x,y, label));
                    break;
                case "Parallelogram":
                    Repository.getInstance().add(new Parallelogram(x,y ,label));
                    break;
                case "RectangleToolVariable":
                    Rectangle rect2 =  new RectangleStandard(x, y, repo.getSelectedColor(), label);
                    RectangleToolVariable rect3 = new RectangleToolVariable(x,y ,label);
                    rect3.add(rect2);
                    Repository.getInstance().add(rect3);
                    break;
                case "Diamond":
                    Repository.getInstance().add(new Diamond(x,y,label));
                    break;
            }
        }

    }


    }

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

