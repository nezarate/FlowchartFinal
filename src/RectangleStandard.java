import java.awt.*;

public class RectangleStandard extends Shape implements Rectangle{

    public RectangleStandard(int x1, int y1, String label) {
        super(x1, y1, label);
        xPoints = new int[]{x1-40, x1+40, x1+40, x1-40};
        yPoints = new int[]{y1-40, y1-40, y1+40, y1+40};
        shape = new Polygon(xPoints, yPoints, numPoints);
        type = "RectangleStandard";
    }


    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1-40, y1-40, 80, 80);
        if(label != null){
            g.setColor(Color.BLACK);
            if(label != null) {
                if(label.length()>33){
                    if(label.charAt(11)!=' ' && label.charAt(10)!=' ')
                        g.drawString(label.substring(0, 11)+"-", x1 - 40 + ((80) / 8), y1-15);
                    else
                        g.drawString(label.substring(0, 11), x1 - 40 + ((80) / 8), y1-15);
                    if(label.charAt(22)!=' ' && label.charAt(21)!=' ')
                        g.drawString(label.substring(11, 22)+"-", x1 - 40 + ((80) / 8), y1-5);
                    else
                        g.drawString(label.substring(11, 22), x1 - 40 + ((80) / 8), y1-5);
                    if(label.charAt(33)!=' ' && label.charAt(32)!=' ')
                        g.drawString(label.substring(22, 33)+"-", x1 - 40 + ((80) / 8), y1+5);
                    else
                        g.drawString(label.substring(22, 33), x1 - 40 + ((80) / 8), y1+5);
                    g.drawString(label.substring(33), x1 - 40 + ((80) / 8), y1+15);
                }else if(label.length()>22){
                    if(label.charAt(11)!=' ' && label.charAt(10)!=' ')
                        g.drawString(label.substring(0, 11)+"-", x1 - 40 + ((80) / 8), y1-10);
                    else
                        g.drawString(label.substring(0, 11), x1 - 40 + ((80) / 8), y1-10);
                    if(label.charAt(22)!=' ' && label.charAt(21)!=' ')
                        g.drawString(label.substring(11, 22)+"-", x1 - 40 + ((80) / 8), y1);
                    else
                        g.drawString(label.substring(11, 22), x1 - 40 + ((80) / 8), y1);
                    g.drawString(label.substring(22), x1 - 40 + ((80) / 8), y1+10);
                }else if(label.length()>11){
                    if(label.charAt(11)!=' ' && label.charAt(10)!=' ')
                        g.drawString(label.substring(0, 11)+"-", x1 - 40 + ((80) / 8), y1-5);
                    else
                        g.drawString(label.substring(0, 11), x1 - 40 + ((80) / 8), y1-5);
                    g.drawString(label.substring(11), x1 - 40 + ((80) / 8), y1+5);
                }else{
                    g.drawString(label, x1 - 40 + ((80) / 8), y1);
                }
            }
        }
    }
}
