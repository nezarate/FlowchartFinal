package Handlers;

import Shapes.ConnectingLine;
import Shapes.RectangleToolMethod;
import Shapes.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Handlers.Repository - holds data for shapes and lines, and allows processing
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class Repository extends Observable {

    private List<Shape> shapeList = new ArrayList<>();
    private List<Shape> unremovableShapesList = new ArrayList<>();
    private List<Shapes.Rectangle> rectList = new ArrayList<>();
    private List<ConnectingLine> lineList = new ArrayList<>();
    private String currentShapeSelection = "Shapes.RectangleStandard";
    private Color selectedColor = Color.LIGHT_GRAY;
    private static Repository repo;

    /**
     * Singleton - gets the static repository instance
     * @return repository
     */
    public static Repository getInstance(){
        if(repo == null)
            repo = new Repository();
        return repo;
    }

    /**
     * Gets the currently selected shape
     * @return currently selected shape
     */
    public String getShapeSelection(){return currentShapeSelection;}

    /**
     * sets the currently selected shape
     * @param selection new shape to be selected
     */
    public  void setShapeSelection(String selection){currentShapeSelection = selection;}

    /**
     * Adds an unremovable shape to the unremovable list
     * @param shape unremovable shape
     */
    public void addUnremovableShape(Shape shape){unremovableShapesList.add(shape);}

    /**
     * Gets all the unremovable shapes
     * @return list of shapes
     */
    public List<Shape> getUnremovableShape(){return this.unremovableShapesList;}

    /**
     * Gets an unremovable shape from an index
     * @param index
     * @return an unremovable shape
     */
    public Shape getUnremovableShape(int index){
        return unremovableShapesList.get(index);
    }

    /**
     * Adds a shape to the shapelist, repaints w/ observers
     * @param shape new shape to add
     */
    public void add (Shape shape) {
        shapeList.add(shape);
        setChanged();
        notifyObservers();
    }

    /**
     * Adds a line to the linelist, repaints with observers
     * @param line new line to add
     */
    public void add (ConnectingLine line) {
        lineList.add(line);
        setChanged();
        notifyObservers();
    }

    /**
     * Gets a shape from the shapelist from an index
     * @param index
     * @return a shape object
     */
    public Shape getShape(int index) { return shapeList.get(index); }

    /**
     * gets the list of shapes
     * @return a list of shapes
     */
    public List<Shape> getShapes() { return this.shapeList; }




   // public List<Shapes.Rectangle> getRects() {return this.rectList;}

    /**
     * Gets the list of all current connectinglines
     * @return list of lines
     */
    public List<ConnectingLine> getLines() {return this.lineList;}

    /**
     * gets the size of the shapelist
     * @return
     */
    public int shapesSize(){ return shapeList.size();}
    public int linesSize(){ return lineList.size();}

    /*
    public Shapes.Rectangle checkWithinRectangle(int x, int y) {
        for (Shapes.Rectangle r : rectList) {
            Shapes.Shape s = (Shapes.Shape)r;
            if (s.checkClick(x, y)) {
                System.out.println("Clicked inside rectangle");
                return r;
            }
        }
        return null;
    }

    public Shapes.Shape checkWithinShape(int x, int y, List<Shapes.Shape> shapeList){

        for (Shapes.Shape s : shapeList) {
            if (s.checkClick(x, y)) {
                System.out.println("Clicked inside shape (non-rect)");
                return s;
            }
        }
        return null;
    }
*/

    /**
     * Updates observers
     */
    public void moved(){
        setChanged();
        notifyObservers();
    }

    /**
     * Clears all shapes and lines, updates observers
     */
    public void clear(){
        shapeList.clear();
        lineList.clear();
        setChanged();
        notifyObservers();
    }


    /*
    public void add(RectangleToolMethod rectangleToolMethod) {
    } */
}
