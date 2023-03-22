import java.awt.*;
/**
 * This Parallelogram class represents the parallelogram objects on the JPanel
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class Parallelogram extends Shape{
    /**
     * Constructor
     * @param x1
     * @param y1
     * @param label
     */
    public Parallelogram(int x1, int y1, String label) {
        super(x1, y1, label);
        xPoints = new int[]{x1 - 45, x1 - 25, x1 + 45, x1 + 25};
        yPoints = new int[]{y1 + 20, y1 - 20, y1 - 20, y1 + 20};
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "Parallelogram";
    }

    /**
     * relocate method, will move parallelogram to x,y
     * @param x
     * @param y
     */
    @Override
    public void relocate(int x, int y) {
        this.xPoints = new int[]{x - 45, x - 25, x + 45, x + 25};
        this.yPoints = new int[]{y + 20, y - 20, y - 20, y + 20};
        this.x1 = x;
        this.y1 = y;
    }

    /**
     * checkClick method, will return true if shape is within x,y
     * false otherwise
     * @param x
     * @param y
     * @return
     */
    public boolean checkClick(int x, int y) {
        Point p = new Point(x, y);
        shape = new Polygon(this.xPoints, this.yPoints, this.numPoints);
        return shape.contains(p);
    }

    /**
     * draw method, will draw parallelogram onto Graphics
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);

        g.fillPolygon(xPoints, yPoints, numPoints);
        g.setColor(Color.BLACK);
        if(label != null)
            g.drawString(label, x1 - 20, y1 + 5);
    }
}
