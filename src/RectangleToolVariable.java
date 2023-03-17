import java.awt.*;

public class RectangleToolVariable extends RectangleTool{
    int x1;
    int y1;
    Color color;
    String label;
    public RectangleToolVariable(int x1, int y1, Color color, String label) {
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
        this.label = label;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(x1-40, y1-50, x1-40, y1+50);
        g.drawLine(x1-50, y1-40, x1+50, y1-40);
        super.draw(g);
    }
}
