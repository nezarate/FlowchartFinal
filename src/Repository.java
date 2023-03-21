import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Repository extends Observable {

    private List<Shape> shapeList = new ArrayList<>();
    private List<Shape> unremovableShapesList = new ArrayList<>();
    private List<Rectangle> rectList = new ArrayList<>();
    private List<ConnectingLine> lineList = new ArrayList<>();
    private String currentShapeSelection = "RectangleStandard";
    private Color selectedColor = Color.LIGHT_GRAY;
    private static Repository repo;

    public static Repository getInstance(){
        if(repo == null)
            repo = new Repository();
        return repo;
    }

    public String getShapeSelection(){return currentShapeSelection;}
    public  void setShapeSelection(String selection){currentShapeSelection = selection;}

    public Color getSelectedColor(){return selectedColor;}
    public void setSelectedColor(Color color){selectedColor = color;}


    public void addUnremovableShape(Shape shape){unremovableShapesList.add(shape);}
    public List<Shape> getUnremovableShape(){return this.unremovableShapesList;}

    public void add (Shape shape) {
        shapeList.add(shape);
        setChanged();
        notifyObservers();
    }
    public void add(List<Shape> shapes) {
        shapeList.addAll(shapes);
        setChanged();
        notifyObservers();
    }
//    public void add (Rectangle rect) {
//        rectList.add(rect);
//        setChanged();
//        notifyObservers();
//    }
    public void add (ConnectingLine line) {

        lineList.add(line);
        setChanged();
        notifyObservers();
    }

    public Shape getShape(int index){ return shapeList.get(index);}
    public List<Shape> getShapes(){return this.shapeList;}

    public Rectangle getRect(int index) {return rectList.get(index);}
    public List<Rectangle> getRects() {return this.rectList;}
    public ConnectingLine getLine(int index) {return lineList.get(index);}
    public List<ConnectingLine> getLines() {return this.lineList;}

    public int shapeSize(){ return shapeList.size();}
    public int rectSize(){ return rectList.size();}
    public int lineSize(){ return lineList.size();}

    public Rectangle checkWithinRectangle(int x, int y) {
        for (Rectangle r : rectList) {
            Shape s = (Shape)r;
            if (s.checkClick(x, y)) {
                System.out.println("Clicked inside rectangle");
                return r;
            }
        }
        return null;
    }

    public Shape checkWithinShape(int x, int y, List<Shape> shapeList){

        for (Shape s : shapeList) {
            if (s.checkClick(x, y)) {
                System.out.println("Clicked inside shape (non-rect)");
                return s;
            }
        }
        return null;
    }


    public void moved(){
        setChanged();
        notifyObservers();
        System.out.println("HERE in REPO" + Repository.getInstance().getShape(0).getX());
    }

    public void clear(){
        shapeList.clear();
        rectList.clear();
        lineList.clear();
        setChanged();
        notifyObservers();
    }












}
