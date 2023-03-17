import java.awt.*;

public class RectangleToolMethod extends RectangleTool{
    public RectangleToolMethod(int x1, int y1, int x2, int y2, Color color, String label) {
        super(x1, y1, x2, y2, color, label);
    }

    @Override
    public void draw(Graphics g) {
        int x = (x2-x1)/10;
        g.drawLine(x1+x, y1, x1+x, y2);
        g.drawLine(x2-x, y1, x2-x, y2);
        super.draw(g);
    }
}
