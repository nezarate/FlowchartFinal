import com.google.gson.annotations.Expose;

import java.awt.*;

public abstract class Shape {
    @Expose
    String type = "Shape";
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
