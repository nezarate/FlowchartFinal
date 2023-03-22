import com.google.gson.annotations.Expose;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

/**
 * This class represents the line that will be drawn between various
 * shapes to represent a connection.
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class ConnectingLine{
//    @Expose
//    int x1, y1, x2, y2;
    @Expose
    String label;
    Shape firstShape;
    Shape secondShape;
    Color color = Color.BLACK;

    /**
     * Public constructor for a ConnectingLine object, takes in the
     * shapes it is connecting and a label.
     * @param firstShape The first shape in the connection
     * @param secondShape The second shape in the connection
     * @param label The label to be written on the ConnectingLine
     */
    public ConnectingLine(Shape firstShape, Shape secondShape, String label){
        this.firstShape = firstShape;
        this.secondShape = secondShape;
        this.label = label;
    }

    /**
     * Draw method that specifies how the ConnectingLine is
     * to be drawn in the workspace.
     * @param g The Graphics object to draw on
     */
    public void draw(Graphics g) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x1 = firstShape.getX();
        int y1 = firstShape.getY();
        int x2 = secondShape.getX();
        int y2 = secondShape.getY();

        double angle = Math.toDegrees(Math.atan2(y1 - y2, x1 - x2));
        if(angle < 0){
            angle += 360;
        }
        g2.drawLine(x1, y1, x2, y2);
        double angle1 = angle + 45;
        double angle2 = angle - 45;
        int x3 = (int)(15*Math.cos(Math.toRadians(angle1)));
        int y3 = (int)(15*Math.sin(Math.toRadians(angle1)));
        int x4 = (int)(15*Math.cos(Math.toRadians(angle2)));
        int y4 = (int)(15*Math.sin(Math.toRadians(angle2)));
        g2.drawLine(x2, y2, x2+x3, y2+y3);
        g2.drawLine(x2, y2, x2+x4, y2+y4);
        if(label!=null)
            g2.drawString(label, x1+(x2-x1)/3, y1+(y2-y1)/3);
    }
}
