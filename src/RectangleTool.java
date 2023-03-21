import java.awt.*;

public abstract class RectangleTool extends Shape implements Rectangle{
    protected Rectangle rectangle;

    public RectangleTool(int x1, int y1, String label) {
        super(x1, y1, label);
    }

    public void add(Rectangle d){
        rectangle = d;
    }



}
