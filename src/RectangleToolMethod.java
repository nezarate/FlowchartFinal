import java.awt.*;

public class RectangleToolMethod extends RectangleTool{
    int x1;
    int y1;
    Color color;
    String label;
    public RectangleToolMethod(int x1, int y1, Color color, String label) {
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
        this.label = label;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x1-40, y1-50, x1-40, y1+50);
        g.drawLine(x1+40, y1-50, x1+40, y1+50);
        super.draw(g);
    }
}
