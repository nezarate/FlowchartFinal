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

    public void undoShape() {
        if (!shapeList.isEmpty()) {
            shapeList.remove(shapeList.size() - 1);
        }
    }

    public void undoLine() {
        if (!lineList.isEmpty()) {
            lineList.remove(lineList.size() - 1);
        }
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
            type1 = iLine.getTitle1();
            type2 = iLine.getTitle2();

            for (ConnectingLine jLine : lineList) {
                String type1Exp, type2Exp;
                type1Exp = jLine.getTitle1();
                type2Exp = jLine.getTitle2();

                if (type1.equals(type1Exp) && type2.equals(type2Exp)) {
                    matchFound = true;
                }

            }
            if (!matchFound) {
                problemLines.add(iLine);
            }
        }


        //System.out.println("Found " + problemLines.size() + " cases where a connection wasn't matched with the expected problem.\n"+
        //        "Make sure you're connecting a \n" + problemLines.get(0).getType1() + " to a " + problemLines.get(0).getType2());
        return problemLines;
    }

    private List<Shape> findShapeIssues(Flowchart expected) {
        List<Shape> issues = new ArrayList<>();

        for (Shape iShape : expected.getShapes()) {
            for (Shape jShape : getShapes()) {
                if (!iShape.getType().equals(jShape.getType())) {
                    issues.add(iShape);
                }
            }
        }

        return issues;
    }

    public String generateHint(Flowchart expected) {
        List<ConnectingLine> issues = compare(expected);
        List<Shape> shapeIssues = findShapeIssues(expected);

        int fSize = getShapes().size();
        int eSize = expected.getShapes().size();
        String shapeStr = "";
        if (!shapeIssues.isEmpty()) {
            shapeStr = "<br>Make sure you include a " + shapeIssues.get(0).getTitle();
        }
        if (fSize > eSize) {
            return "Too many shapes!<br>Found " + fSize + ", expected " + eSize + shapeStr;
        } else if (fSize < eSize) {
            return "Not enough shapes!<br>Found " + fSize + ", expected " + eSize + shapeStr;
        }
        else if (issues.size() > 0) {
            return "Found " + issues.size() + " cases where a connection wasn't matched with the expected flowchart<br>"+
                    "Make sure you're connecting a " + issues.get(0).getTitle1() + " to a " + issues.get(0).getTitle2();
        } else if (!shapeIssues.isEmpty()) {
            return "Incorrect shapes!" + shapeStr;
        }
        else {
            return null;
        }
    }

}
