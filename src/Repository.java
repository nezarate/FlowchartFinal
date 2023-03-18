import java.util.ArrayList;
import java.util.List;

public class Repository {

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
    }

    public void add (Rectangle rect){rectList.add(rect);}
    public void add (ConnectingLine line){
        lineList.add(line);
    }

    public Shape getShape(int index){ return shapeList.get(index);}

    public Rectangle getRect(int index) {return rectList.get(index);}

    public ConnectingLine getLine(int index) {return lineList.get(index);}

    public int shapeSize(){ return shapeList.size();}
    public int rectSize(){ return rectList.size();}
    public int lineSize(){ return lineList.size();}


    public void clear(){
        shapeList.clear();
        rectList.clear();
        lineList.clear();
    }












}
