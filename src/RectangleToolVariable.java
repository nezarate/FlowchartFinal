import java.awt.*;

public class RectangleToolVariable extends RectangleTool{
    public RectangleToolVariable(int x1, int y1, int x2, int y2, Color color, String label) {
        super(x1, y1, x2, y2, color, label);
    }

    @Override
    public void draw(Graphics g) {
        int x = (x2-x1)/10;
        int y = (y2-y1)/10;
        g.drawLine(x1+x, y1, x1+x, y2);
        g.drawLine(x1, y1+y, x2, y1+y);
        super.draw(g);
    }
}
