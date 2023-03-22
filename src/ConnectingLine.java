import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class ConnectingLine{
    int x1;
    int y1;
    int x2;
    int y2;
    Color color;
    String label;
    public ConnectingLine(int x1, int y1, int x2, int y2, Color color, String label){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.label = label;
    }

    public void draw(Graphics g) {
        // This straight up does not work, arrowheads suck
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
