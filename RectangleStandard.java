import java.awt.*;

public class RectangleStandard implements Rectangle{
    int x1;
    int y1;
    Color color;
    String label;
    public RectangleStandard(int x1, int y1, Color color, String label) {
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
        this.label = label;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x1-50, y1-50, x1+50, y1+50);
        if(label != null){
            g.drawString(label, x1+((100)/8),y1);
        }
    }
}
