package Shapes;
import java.awt.*;
/**
 * This Shapes.Parallelogram class represents the parallelogram objects on the JPanel
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
        xPointsBase = new int[]{-45, -25, 45, 25};
        yPointsBase = new int[]{20, -20, -20, 20};
        updatePoints(x1, y1);
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "Shapes.Parallelogram";
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
