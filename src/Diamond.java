import java.awt.*;

public class Diamond extends Shape{

    public Diamond(int x1, int y1, Color color, String label) {
        super(x1, y1, color, label);
        xPoints = new int[]{x1 - 40, x1, x1 + 40, x1};
        yPoints = new int[]{y1, y1 - 30, y1, y1 + 30};
        shape = new Polygon(xPoints, yPoints, numPoints);
    }

    @Override
    public void relocate(int x, int y) {
        this.xPoints = new int[]{x - 40, x, x + 40, x};
        this.yPoints = new int[]{y, y - 30, y, y + 30};
        this.x1 = x;
        this.y1 = y;
    }

    public boolean checkClick(int x, int y) {
        Point p = new Point(x, y);
        //shape = new Polygon(this.xPoints, this.yPoints, this.numPoints);
        return shape.contains(p);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);

        g.fillPolygon(xPoints, yPoints, numPoints);
        g.setColor(Color.BLACK);
        if(label != null)
            g.drawString(label, x1 - 20, y1 + 5);
    }


}
