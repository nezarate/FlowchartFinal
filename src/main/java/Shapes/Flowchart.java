package Shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Flowchart {
    private List<Shape> shapeList = new ArrayList<>();
    private List<ConnectingLine> lineList = new ArrayList<>();

    public Flowchart() {

    }

    public Flowchart(List<Shape> shapes, List<ConnectingLine> lines) {
        shapeList = shapes;
        lineList = lines;
    }

    public void add(Shape shape) {
        shapeList.add(shape);
    }

    public void add(ConnectingLine line) {
        lineList.add(line);
    }

    public void draw(Graphics g) {
        for(Shape shape : shapeList){
            shape.draw(g);
        }
        for(ConnectingLine line : lineList){
            line.draw(g);
        }
    }

    public List<Shape> getShapes() {
        return shapeList;
    }

    public List<ConnectingLine> getLines() {
        return lineList;
    }

}
