import java.awt.*;

public class RectangleToolVariable extends RectangleTool{

    public RectangleToolVariable(int x1, int y1, String label) {
        super(x1, y1, label);
        xPoints = new int[]{x1-40, x1+40, x1+40, x1-40};
        yPoints = new int[]{y1-40, y1-40, y1+40, y1+40};
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "RectangleToolVariable";
    }

    @Override
    public void relocate(int x, int y) {
        this.xPoints = new int[]{x-50, x+50, x+50, x-50};
        this.yPoints = new int[]{y-50, y-50, y+50, y+50};
        this.x1 = x;
        this.y1 = y;
    }
    public boolean checkClick(int x, int y) {
        Point p = new Point(x, y);
        shape = new Polygon(this.xPoints, this.yPoints, this.numPoints);
        return shape.contains(p);
    }
    
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(x1-35, y1-40, x1-35, y1+40);
        g.drawLine(x1-40, y1-35, x1+40, y1-35);
    }
}
