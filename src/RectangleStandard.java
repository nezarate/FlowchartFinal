import java.awt.*;

public class RectangleStandard extends Shape implements Rectangle{

    public RectangleStandard(int x1, int y1, String label) {
        super(x1, y1, label);
        xPoints = new int[]{x1-50, x1+50, x1+50, x1-50};
        yPoints = new int[]{y1-50, y1-50, y1+50, y1+50};
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "RectangleStandard";
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1-50, y1-50, 100, 100);
        if(label != null){
            g.setColor(Color.BLACK);
            g.drawString(label, x1+((100)/8),y1);
        }
    }
}
