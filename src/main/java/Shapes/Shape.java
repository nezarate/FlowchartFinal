package Shapes;
import com.google.gson.annotations.Expose;
import java.awt.*;

/**
 * Shape
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public abstract class Shape {
    @Expose
    String type = "Shapes";
    String title;
    @Expose
    int x1, y1;
    @Expose(serialize = false, deserialize = false)
    Polygon shape;
    int[] xPoints, yPoints, xPointsBase, yPointsBase;
    int numPoints = 4;
    @Expose
    String label;

    Color color = Color.LIGHT_GRAY;
    public Shape(int x1, int y1, String label){
        xPoints = new int[4];
        yPoints = new int[4];
        this.x1 = x1;
        this.y1 = y1;
        this.label = label;

    }

    protected void updatePoints(int x, int y) {
        for (int i = 0; i < xPointsBase.length; i++) {
            xPoints[i] = x + xPointsBase[i];
            yPoints[i] = y + yPointsBase[i];
        }
    }
    public void relocate(int x, int y){
        updatePoints(x, y);
        this.x1 = x;
        this.y1 = y;
    }

    public int getX(){return this.x1;}
    public int getY(){return this.y1;}

    public String getType() { return type; };

    public void setLabel(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

    public String getTitle() { return this.title; }

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void draw(Graphics g);

    /**
     * checkClick method, will return true if shape is within x,y
     * false otherwise
     * @param x
     * @param y
     * @return whether shape clicked or not
     */
    public boolean checkClick(int x, int y) {
        Point p = new Point(x, y);
        shape = new Polygon(this.xPoints, this.yPoints, this.numPoints);
        return shape.contains(p);
    }


}
