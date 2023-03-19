import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Repository extends Observable {

    private List<Shape> shapeList = new ArrayList<>();
    private List<Rectangle> rectList = new ArrayList<>();
    private List<ConnectingLine> lineList = new ArrayList<>();
    private static Repository repo;

    public static Repository getInstance(){
        if(repo == null)
            repo = new Repository();
        return repo;
    }

    public void add (Shape shape){
        shapeList.add(shape);
        setChanged();
        notifyObservers();
    }

    public void add (Rectangle rect){
        rectList.add(rect);
        setChanged();
        notifyObservers();
    }
    public void add (ConnectingLine line){

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


    public void clear(){
        shapeList.clear();
        rectList.clear();
        lineList.clear();
    }












}
