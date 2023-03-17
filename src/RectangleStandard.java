import java.awt.*;

public class RectangleStandard extends Rectangle{
    public RectangleStandard(int x1, int y1, int x2, int y2, Color color, String label) {
        super(x1, y1, x2, y2, color, label);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(color);
        g.drawRect(x1, y1, x2, y2);
        if(label != null){
            g.drawString(label, x1+((x2-x1)/8),y1+(y2-y1));
        }
    }
}
