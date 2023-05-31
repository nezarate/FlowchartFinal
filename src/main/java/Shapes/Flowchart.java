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
        attachLineShapes();
    }

    private void attachLineShapes() {
        for (ConnectingLine l : lineList) {
            l.attachShapes(this);
        }
    }

    /**
     * Loops through all the line connections and its two adjacent shapes, and checks whether
     * @param expected expected result of the flowchart
     */
    public List<ConnectingLine> compare(Flowchart expected) {
        // A list of line connections that should have been included
        List<ConnectingLine> problemLines = new ArrayList<>();


        for (ConnectingLine iLine : expected.getLines()) {
            boolean matchFound = false;
            String type1, type2;
            type1 = iLine.getType1();
            type2 = iLine.getType2();

            for (ConnectingLine jLine : lineList) {
                String type1Exp, type2Exp;
                type1Exp = jLine.getType1();
                type2Exp = jLine.getType2();

                if ((type1.equals(type1Exp) && type2.equals(type2Exp)) ||
                        (type1.equals(type2Exp) && type2.equals(type1Exp))) {
                    matchFound = true;
                }

            }
            if (!matchFound) {
                problemLines.add(iLine);
            }
        }

        for (ConnectingLine iLine : lineList) {
            boolean matchFound = false;
            String type1, type2;
            type1 = iLine.getType1();
            type2 = iLine.getType2();

            for (ConnectingLine jLine : expected.getLines()) {
                String type1Exp, type2Exp;
                type1Exp = jLine.getType1();
                type2Exp = jLine.getType2();

                if ((type1.equals(type1Exp) && type2.equals(type2Exp)) ||
                        (type1.equals(type2Exp) && type2.equals(type1Exp))) {
                    matchFound = true;
                }

            }
            if (!matchFound) {
                problemLines.add(iLine);
            }
        }

        System.out.println("Found " + problemLines.size() + " cases where a connection wasn't matched with the expected problem");
        return problemLines;
    }

    public void add(Shape shape) {
        shapeList.add(shape);
    }

    public void add(ConnectingLine line) {
        lineList.add(line);
    }

    public void replaceShapes(List<Shape> s) {
        shapeList = s;
    }

    public void replaceLines(List<ConnectingLine> l) {
        lineList = l;
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
