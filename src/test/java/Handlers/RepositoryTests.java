package Handlers;
import Shapes.*;
import Shapes.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.*;

class RepositoryTests {
    private static final int INITIAL_X = 0;
    private static final int INITIAL_Y = 0;
    public static final Shape[] BASIC_REPO_STEUP = new Shape[]{
            new Circle(INITIAL_X,INITIAL_Y,Color.BLACK,"Circle",Color.BLACK),
            new Diamond(INITIAL_X,INITIAL_Y,"Diamond"),
            new Parallelogram(INITIAL_X,INITIAL_Y,"Parallelogram"),
            new RectangleStandard(INITIAL_X,INITIAL_Y,"RectangleStandard"),
            new RectangleToolMethod(INITIAL_X,INITIAL_Y,"RectangleToolMethod"),
            new RectangleToolVariable(INITIAL_X,INITIAL_Y,"RectangleToolVariable")};

    public void insertShapesInRepo(Repository repo, Shape[] setup){
        for(Shape shape : setup) {
            repo.add(shape);
        }
    }
    @Test
    public void testRepoSetUp(){
        Repository testRepo = Repository.getInstance();
        Assertions.assertEquals(0,testRepo.shapesSize());
        Assertions.assertEquals(0,testRepo.linesSize(),0);

        insertShapesInRepo(testRepo,BASIC_REPO_STEUP);
        Assertions.assertEquals(6,testRepo.shapesSize());

        Shape shape1 = testRepo.getShape(0);
        Shape shape2 = testRepo.getShape(1);
        Assertions.assertEquals(BASIC_REPO_STEUP[0],shape1);
        Assertions.assertEquals(BASIC_REPO_STEUP[1],shape2);

        testRepo.add(new ConnectingLine(shape1,shape2,"Test Connection"));
        Assertions.assertEquals(1,testRepo.linesSize());

        testRepo.clear();
        Assertions.assertEquals(0,testRepo.shapesSize());
        Assertions.assertEquals(0,testRepo.linesSize());
    }
}