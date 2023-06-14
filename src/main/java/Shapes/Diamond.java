package Shapes;
import java.awt.*;
/**
 * This Diamond class represents the diamond objects on the JPanel
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
        xPointsBase = new int[]{-40, 0, 40, 0};
        yPointsBase = new int[]{0, -30, 0, 30};
        updatePoints(x1, y1);
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "Diamond";
        title = "Condition";
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
