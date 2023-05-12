package Shapes;
import Handlers.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

class ShapeTests {
    private static final int INITIAL_X = 0;
    private static final int INITIAL_Y = 0;
    public static final Shape[] BASIC_REPO_STEUP = new Shape[]{
            new Circle(INITIAL_X,INITIAL_Y, Color.BLACK,"Circle",Color.BLACK),
            new Diamond(INITIAL_X,INITIAL_Y,"Diamond"),
            new Parallelogram(INITIAL_X,INITIAL_Y,"Parallelogram"),
            new RectangleStandard(INITIAL_X,INITIAL_Y,"RectangleStandard"),
            new RectangleToolMethod(INITIAL_X,INITIAL_Y,"RectangleToolMethod"),
            new RectangleToolVariable(INITIAL_X,INITIAL_Y,"RectangleToolVariable")};

    @Test
    public void testGetter(){
        for(int i = 0; i < 6; i++){
            Assertions.assertEquals(INITIAL_X, BASIC_REPO_STEUP[i].getX());
            Assertions.assertEquals(INITIAL_Y, BASIC_REPO_STEUP[i].getY());
            Assertions.assertEquals(true,BASIC_REPO_STEUP[i].checkClick(INITIAL_X,INITIAL_Y));
            Assertions.assertEquals(true,BASIC_REPO_STEUP[i].checkClick(INITIAL_X + 5,INITIAL_Y + 5));
            Assertions.assertEquals(true,BASIC_REPO_STEUP[i].checkClick(INITIAL_X - 5,INITIAL_Y - 5));
            Assertions.assertEquals(true,BASIC_REPO_STEUP[i].checkClick(INITIAL_X + 10,INITIAL_Y + 10));
            Assertions.assertEquals(true,BASIC_REPO_STEUP[i].checkClick(INITIAL_X - 10,INITIAL_Y - 10 ));
            Assertions.assertEquals(false,BASIC_REPO_STEUP[i].checkClick(200,200));
        }
        Assertions.assertEquals("Circle", BASIC_REPO_STEUP[0].getLabel());
        Assertions.assertEquals("Diamond", BASIC_REPO_STEUP[1].getLabel());
        Assertions.assertEquals("Parallelogram", BASIC_REPO_STEUP[2].getLabel());
        Assertions.assertEquals("RectangleStandard", BASIC_REPO_STEUP[3].getLabel());
        Assertions.assertEquals("RectangleToolMethod", BASIC_REPO_STEUP[4].getLabel());
        Assertions.assertEquals("RectangleToolVariable", BASIC_REPO_STEUP[5].getLabel());
    }
    @Test
    public void testSetter(){
        int CHANGE_X = 200;
        int CHANGE_Y = 200;
        for(int i = 1; i < 6; i++){
            BASIC_REPO_STEUP[i].relocate(CHANGE_X,CHANGE_Y);
            Assertions.assertEquals(CHANGE_X,BASIC_REPO_STEUP[i].getX());
            Assertions.assertEquals(CHANGE_Y,BASIC_REPO_STEUP[i].getY());
            Assertions.assertEquals(false,BASIC_REPO_STEUP[i].checkClick(INITIAL_X,INITIAL_Y));
            Assertions.assertEquals(true,BASIC_REPO_STEUP[i].checkClick(CHANGE_X,CHANGE_Y));
        }
    }
    @Test
    public void testLines(){
        Repository testRepo = Repository.getInstance();
        testRepo.add(BASIC_REPO_STEUP[0]);
        testRepo.add(BASIC_REPO_STEUP[1]);
        ConnectingLine lineOne = new ConnectingLine(BASIC_REPO_STEUP[0],BASIC_REPO_STEUP[1],"TestLine" );
        Assertions.assertEquals(BASIC_REPO_STEUP[0],lineOne.getFirstShape());
        Assertions.assertEquals(BASIC_REPO_STEUP[1],lineOne.getSecondShape());
    }

}