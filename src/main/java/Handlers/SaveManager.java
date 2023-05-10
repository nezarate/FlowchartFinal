package Handlers;
import Shapes.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 * Handlers.SaveManager (Singleton), allows saving and loading a file, serializes shapes and lines into json that is read back
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class SaveManager {

    String filePath = "";
    String delim = "~~~";
    String shapeExt = ".shape";
    String jsonShapes, jsonLines;
    Repository repo;
    Gson gsonShape, gsonLine;

    ShapeDeserializer shapeDeserializer;
    LineDeserializer lineDeserializer;

    private static SaveManager saveManager;
    private SaveManager() {
        repo = Repository.getInstance();
        setupDeserializer();
        gsonShape = new GsonBuilder()
                .registerTypeHierarchyAdapter(Shape.class, shapeDeserializer)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        gsonLine = new GsonBuilder()
                .registerTypeHierarchyAdapter(ConnectingLine.class, lineDeserializer)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    /**
     * Statically gets the current savemanager object
     * @return Handlers.SaveManager object
     */
    public static SaveManager getSaveManager() {
        if (saveManager == null) {
            saveManager = new SaveManager();
        }
        return saveManager;
    }

    private void setupDeserializer() {
        shapeDeserializer = new ShapeDeserializer("type");
        shapeDeserializer.registerShapeType("Shapes.Diamond", Diamond.class);
        shapeDeserializer.registerShapeType("Shapes.Parallelogram", Parallelogram.class);
        shapeDeserializer.registerShapeType("Shapes.RectangleStandard", RectangleStandard.class);
        shapeDeserializer.registerShapeType("Shapes.RectangleToolMethod", RectangleToolMethod.class);
        shapeDeserializer.registerShapeType("Shapes.RectangleToolVariable", RectangleToolVariable.class);

        lineDeserializer = new LineDeserializer();
    }

    /**
     * Serializes shapes and lines to json (using gson), then stores it in a file)
     * @param fileName the name of the file to create
     */
    public void save(String fileName) {

        try {

            FileWriter writer = new FileWriter(filePath + fileName + shapeExt);
            jsonShapes = gsonShape.toJson(repo.getShapes());
            jsonLines = gsonLine.toJson(repo.getLines());
            System.out.println(jsonShapes);

            System.out.println(jsonLines);
            writer.write(jsonShapes + delim + jsonLines);

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Reads a file then deserializes shapes and lines from json (using gson), which get added back to repo
     * @param fileName the name of the file to read
     */
    public void load(String fileName) {
        try {
            Path filePath = Path.of(fileName+shapeExt);

            String json = Files.readString(filePath);
            String[] jsonParts = json.split(delim);
            jsonShapes = jsonParts[0];
            jsonLines = jsonParts[1];

            repo.clear();
            Type listType = new TypeToken<List<Shape>>(){}.getType();

            if (!Objects.equals(jsonShapes, "[]")) {
                List<Shape> shapes = gsonShape.fromJson(jsonShapes, listType);
            }

            Type lineType = new TypeToken<List<ConnectingLine>>(){}.getType();


            if (!Objects.equals(jsonLines, "[]")) {
                List<ConnectingLine> lines = gsonLine.fromJson(jsonLines, lineType);
            }
        } catch (IOException e) {
            System.out.println("No file found with that name");
        }

    }
}
