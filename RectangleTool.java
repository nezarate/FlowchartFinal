import java.awt.*;

public abstract class RectangleTool extends Shape implements Rectangle{
    protected Rectangle rectangle;

    public RectangleTool(int x1, int y1, Color color, String label) {
        super(x1, y1, color, label);
    }

    public void add(Rectangle d){
        rectangle = d;
    }



}
