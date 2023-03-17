import java.awt.*;

public abstract class RectangleTool implements Rectangle{
    protected Rectangle rectangle;

    public void add(Rectangle d){
        rectangle = d;
    }

    public void draw(Graphics g) {
        rectangle.draw(g);
    }
}
