package Shapes;
import java.awt.*;
/**
 * This Shapes.Diamond class represents the diamond objects on the JPanel
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class Diamond extends Shape{
    /**
     * Constructor
     * @param x1
     * @param y1
     * @param label
     */
    public Diamond(int x1, int y1, String label) {
        super(x1, y1, label);
        xPoints = new int[]{x1 - 40, x1, x1 + 40, x1};
        yPoints = new int[]{y1, y1 - 30, y1, y1 + 30};
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "Shapes.Diamond";
    }

    /**
     * Relocate method, will move Shapes.Diamond appropriately
     * @param x
     * @param y
     */
    @Override
    public void relocate(int x, int y) {
        this.xPoints = new int[]{x - 40, x, x + 40, x};
        this.yPoints = new int[]{y, y - 30, y, y + 30};
        this.x1 = x;
        this.y1 = y;
    }

    /**
     * checkClick method, will return true if shape is within x,y
     * false otherwise
     * @param x
     * @param y
     * @return boolean
     */
    public boolean checkClick(int x, int y) {
        Point p = new Point(x, y);
        shape = new Polygon(this.xPoints, this.yPoints, this.numPoints);
        return shape.contains(p);
    }

    /**
     * draw method, will draw diamond onto Graphics
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);

        g.fillPolygon(xPoints, yPoints, numPoints);
        g.setColor(Color.BLACK);
        if(label != null)
            g.drawString(label, x1 - 20, y1 + 5);
    }


}
