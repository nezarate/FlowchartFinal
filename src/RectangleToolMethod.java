import java.awt.*;

public class RectangleToolMethod extends RectangleTool{

    public RectangleToolMethod(int x1, int y1, String label) {
        super(x1, y1, label);
        xPoints = new int[]{x1-50, x1+50, x1+50, x1-50};
        yPoints = new int[]{y1-50, y1-50, y1+50, y1+50};
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "RectangleToolMethod";
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(color);
        g.fillRect(x1-50, y1-50, 100, 100);

        g.setColor(Color.BLACK);

        if(label != null){
            g.drawString(label, x1+((100)/8),y1);
        }

        g.drawLine(x1-40, y1-50, x1-40, y1+50);
        g.drawLine(x1+40, y1-50, x1+40, y1+50);

    }
}
