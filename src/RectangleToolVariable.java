import java.awt.*;

public class RectangleToolVariable extends RectangleTool{

    public RectangleToolVariable(int x1, int y1, Color color, String label) {
        super(x1, y1, color, label);
        xPoints = new int[]{x1-40, x1+40, x1+40, x1-40};
        yPoints = new int[]{y1-40, y1-40, y1+40, y1+40};
        shape = new Polygon(xPoints, yPoints, numPoints);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(x1-35, y1-40, x1-35, y1+40);
        g.drawLine(x1-40, y1-35, x1+40, y1-35);
    }
}
