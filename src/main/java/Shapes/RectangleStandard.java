package Shapes;
import java.awt.*;

/**
 * This class represents the standard Shapes.Rectangle and how it
 * should be drawn.
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class RectangleStandard extends Shape implements Rectangle {

    /**
     * Public constructor for the Shapes.RectangleStandard object
     * @param x1 The x position of the center of the Shapes.Rectangle
     * @param y1 The y position of the center of the Shapes.Rectangle
     * @param label The label to be drawn on the Shapes.Rectangle
     */
    public RectangleStandard(int x1, int y1, String label) {
        super(x1, y1, label);
        xPointsBase = new int[]{-40, 40, 40, -40};
        yPointsBase = new int[]{-40, -40, 40, 40};
        updatePoints(x1, y1);
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "RectangleStandard";
    }



    /**
     * Draw method that specifies how the rectangle should be
     * drawn on the workspace
     * @param g The Graphics object to be drawn on
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1-40, y1-40, 80, 80);
        if(label != null){
            g.setColor(Color.BLACK);
            if (label != null) {
                int maxLength = 11;
                int y = y1-20;
                int i;
                for (i = 0; i + maxLength < label.length(); i += maxLength) {
                    String segment = label.substring(i, i+maxLength);
                    if (!segment.endsWith(" ") && label.charAt(i+maxLength)!=' ') {
                        segment = segment + "-";
                    }
                    if(segment.startsWith(" "))
                        segment = segment.substring(1);
                    g.drawString(segment, x1 - 40 + ((80) / 8), y);
                    y += 10;
                }
                String finalSegment = label.substring(i);
                if(finalSegment.startsWith(" "))
                    finalSegment = finalSegment.substring(1);
                g.drawString(finalSegment,x1 - 40 + ((80) / 8), y);
            }
        }
    }
}
