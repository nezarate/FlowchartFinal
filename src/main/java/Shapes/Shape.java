package Shapes;
import com.google.gson.annotations.Expose;
import java.awt.*;

/**
 * Shapes.Shape
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public abstract class Shape {
    @Expose
    String type = "Shapes";
    @Expose
    int x1, y1;
    @Expose(serialize = false, deserialize = false)
    Polygon shape;
    int[] xPoints, yPoints;
    int numPoints = 4;
    @Expose
    String label;
    Color color = Color.LIGHT_GRAY;
    public Shape(int x1, int y1, String label){
        this.x1 = x1;
        this.y1 = y1;
        this.label = label;

    }

    public void relocate(int x, int y){
        this.x1 = x;
        this.y1 = y;
    }

    public int getX(){return this.x1;}
    public int getY(){return this.y1;}

    public void setLabel(String label){
        this.label = label;
    }

    public String getLabel(String label){
        return this.label;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void draw(Graphics g);

    public boolean checkClick(int x, int y) {
        Point p = new Point(x, y);
        shape = new Polygon(this.xPoints, this.yPoints, this.numPoints);
        return shape.contains(p);
    }

//    public boolean isThere(int x, int y){
//        if(this.x1 == x && this.y1 == y){
//            return true;
//        }else{
//            return false;
//        }
//    }
}
