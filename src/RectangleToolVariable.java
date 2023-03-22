import java.awt.*;

/**
 * Represents the variable decoration lines on a Rectangle object,
 * allows you to draw these specific decoration lines on any
 * Rectangle object by adding that object to this RectangleToolMethod.
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class RectangleToolVariable extends RectangleTool{
    /**
     * Public constructor of the RectangleToolVariable decoration
     * @param x1 The x coordinate of the center of this Rectangle
     * @param y1 The y coordinate of the center of this Rectangle
     * @param label The label to be drawn on the Rectangle
     */
    public RectangleToolVariable(int x1, int y1, String label) {
        super(x1, y1, label);
        xPoints = new int[]{x1-40, x1+40, x1+40, x1-40};
        yPoints = new int[]{y1-40, y1-40, y1+40, y1+40};
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "RectangleToolVariable";
    }

    /**
     * This method specifies how the lines should be drawn
     * along with drawing whatever other Rectangle it contains.
     * @param g The Graphics to be drawn on
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(x1-35, y1-40, x1-35, y1+40);
        g.drawLine(x1-40, y1-35, x1+40, y1-35);
    }
}
