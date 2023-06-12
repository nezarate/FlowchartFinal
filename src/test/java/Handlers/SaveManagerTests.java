package Handlers;

import Shapes.*;
import Shapes.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class SaveManagerTests {

    // Different test points for Save/Load
    private static final int X_1 = 0;
    private static final int X_2 = 25;
    private static final int X_3 = 50;
    private static final int Y_1 = 0;
    private static final int Y_2 = 25;
    private static final int Y_3 = 50;
    private static final String SAVE_FILE = "SAVE_LOAD_TEST";
    private static final String FILE_PATH = "src/test/java/Handlers/";
    public static final Shape[] SAVE_REPO_SETUP = new Shape[]{
            new Circle(X_1,Y_3, Color.BLACK,"Circle",Color.BLACK),
            new Diamond(X_2,Y_2,"Diamond"),
            new Parallelogram(X_3,Y_1,"Parallelogram"),
            new RectangleStandard(X_1,Y_3,"RectangleStandard"),
            new RectangleToolMethod(X_2,Y_2,"RectangleToolMethod"),
            new RectangleToolVariable(X_3,Y_3,"RectangleToolVariable")};

    // Adds the shape setup into repo, and creates two lines
    private void setUpRepo(Repository repo, Shape[] setup){
        for(Shape shape: setup){
            repo.add(shape);
        }
        repo.add(new ConnectingLine(repo.getShape(0),repo.getShape(4),"testConnectionOne"));
        repo.add(new ConnectingLine(repo.getShape(1),repo.getShape(2),"testConnectionTwo"));
    }
    @Test
    public void testSaveAndLoad() throws IOException {
        SaveManager saver = SaveManager.getSaveManager();
        saver.modifyFilePath(FILE_PATH);

        // set up repo and Save
        Repository testRepo = Repository.getInstance();
        setUpRepo(testRepo,SAVE_REPO_SETUP);
        saver.save(SAVE_FILE);

        // clear Repo
        testRepo.clear();
        Assertions.assertEquals(0,testRepo.shapesSize());
        Assertions.assertEquals(0,testRepo.linesSize());

        //Path filePath = Path.of(FILE_PATH+SAVE_FILE+".shape");
        //System.out.println(Files.readString(filePath));


        // load file
        /*
        saver.load(FILE_PATH+SAVE_FILE);
        Assertions.assertEquals(6,testRepo.shapesSize());
        Assertions.assertEquals(2,testRepo.linesSize());
        for(int i = 0; i < SAVE_REPO_SETUP.length; i ++){
            Assertions.assertEquals(SAVE_REPO_SETUP[i],testRepo.getShape(i));
        }
        ConnectingLine lineOne = testRepo.getLine(0);
        ConnectingLine lineTwo = testRepo.getLine(1);
        Assertions.assertEquals(SAVE_REPO_SETUP[0], lineOne.getFirstShape());
        Assertions.assertEquals(SAVE_REPO_SETUP[4], lineOne.getSecondShape());
        Assertions.assertEquals(SAVE_REPO_SETUP[1], lineTwo.getFirstShape());
        Assertions.assertEquals(SAVE_REPO_SETUP[2], lineTwo.getSecondShape());

        */
        Files.deleteIfExists(Path.of(FILE_PATH+SAVE_FILE+".shape"));
    }

}