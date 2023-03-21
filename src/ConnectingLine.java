import com.google.gson.annotations.Expose;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class ConnectingLine{
    @Expose
    int x1, y1, x2, y2;
    @Expose
    String label;

    Color color = Color.BLACK;

    public ConnectingLine(int x1, int y1, int x2, int y2, String label){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        //this.color = color;
        this.label = label;
    }

    public void draw(Graphics g) {
        // This straight up does not work, arrowheads suck
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double angle = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        if(angle < 0){
            angle += 360;
        }
        angle = angle * Math.PI/180;
        g2.drawLine(x1, y1, x2, y2);
        g2.rotate(angle);
        g2.rotate(135*Math.PI/180);
        g2.drawLine(x2, y2, x2+15, y2);
        g2.rotate(-270*Math.PI/180);
        g2.drawLine(x2, y2, x2+15, y2);
    }
}
