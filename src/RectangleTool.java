import java.awt.*;

public abstract class RectangleTool extends Rectangle{
    protected Rectangle rectangle;
    public RectangleTool(int x1, int y1, int x2, int y2, Color color, String label) {
        super(x1, y1, x2, y2, color, label);
    }

    public void add(Rectangle d){
        rectangle = d;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        rectangle.draw(g);
    }
}
