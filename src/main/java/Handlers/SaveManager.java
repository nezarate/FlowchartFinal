package Handlers;
import Shapes.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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

    public void modifyFilePath(String newFilePath){
        filePath = newFilePath;
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
        shapeDeserializer.registerShapeType("Diamond", Diamond.class);
        shapeDeserializer.registerShapeType("Parallelogram", Parallelogram.class);
        shapeDeserializer.registerShapeType("RectangleStandard", RectangleStandard.class);
        shapeDeserializer.registerShapeType("RectangleToolMethod", RectangleToolMethod.class);
        shapeDeserializer.registerShapeType("RectangleToolVariable", RectangleToolVariable.class);

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

    public String saveAsString() {

        jsonShapes = gsonShape.toJson(repo.getShapes());
        jsonLines = gsonLine.toJson(repo.getLines());
        System.out.println(jsonShapes);

        System.out.println(jsonLines);
        return jsonShapes + delim + jsonLines;


    }

    /**
     * Reads a file then deserializes shapes and lines from json (using gson), which get added back to repo
     * @param fileName the name of the file to read
     */
    public Flowchart load(String fileName) {
        try {
            Path filePath = Path.of(fileName+shapeExt);

            String json = Files.readString(filePath);
            return loadJson(json);

        } catch (IOException e) {
            System.out.println("No file found with the name: " + fileName);
        }

        return null;
    }

    public Flowchart loadJson(String json) {
        try {

            String[] jsonParts = json.split(delim);
            jsonShapes = jsonParts[0];
            jsonLines = jsonParts[1];

            //repo.clear();
            Type listType = new TypeToken<List<Shape>>(){}.getType();


            List<Shape> shapes = new ArrayList<>();
            if (!Objects.equals(jsonShapes, "[]")) {
                shapes = gsonShape.fromJson(jsonShapes, listType);
            }

            Type lineType = new TypeToken<List<ConnectingLine>>(){}.getType();

            List<ConnectingLine> lines = new ArrayList<>();
            if (!Objects.equals(jsonLines, "[]")) {
                lines = gsonLine.fromJson(jsonLines, lineType);
                //System.out.println(lines);
            }

            return new Flowchart(shapes, lines);
            //Repository.getInstance().add(new Flowchart(shapes, lines));

        } catch (Exception e) {
            System.out.println("Error loading from json provided");
        }

        return null;
    }

    public Flowchart loadWithString(String savedDiagramm) {

        if (savedDiagramm == null) {
            return load("test");
        }

            String[] jsonParts = savedDiagramm.split(delim);
            jsonShapes = jsonParts[0];
            jsonLines = jsonParts[1];

            //repo.clear();
            Type listType = new TypeToken<List<Shape>>(){}.getType();


            List<Shape> shapes = new ArrayList<>();
            if (!Objects.equals(jsonShapes, "[]")) {
                shapes = gsonShape.fromJson(jsonShapes, listType);
            }

            Type lineType = new TypeToken<List<ConnectingLine>>(){}.getType();

            List<ConnectingLine> lines = new ArrayList<>();
            if (!Objects.equals(jsonLines, "[]")) {
                lines = gsonLine.fromJson(jsonLines, lineType);
                //System.out.println(lines);
            }

            return new Flowchart(shapes, lines);
            //Repository.getInstance().add(new Flowchart(shapes, lines));

    }
}
