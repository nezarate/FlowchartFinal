import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class ConnectingLine extends Shape{
    public ConnectingLine(int x1, int y1, int x2, int y2, Color color, String label){
        super(x1, y1, x2, y2, color, label);
    }

    @Override
    public void draw(Graphics g) {
        // This straight up does not work, arrowheads suck
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
        double thetaRads = Math.atan2(y2-y1, x2-x1);
        double line1Rads = -(thetaRads + Math.PI/4);
        double line2Rads = -(thetaRads - Math.PI/4);
        int x3 = x2+(int)(15*Math.cos(line1Rads));
        int y3 = y2+(int)(15*Math.sin(line1Rads));
        int x4 = x2+(int)(15*Math.cos(line2Rads));
        int y4 = y2+(int)(15*Math.sin(line2Rads));
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x2, y2, x4, y4);
    }
}
