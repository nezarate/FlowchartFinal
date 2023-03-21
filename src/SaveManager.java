import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Singleton
 */
public class SaveManager {

    String filePath = "";
    String shapeExt = ".shape";
    String jsonShapes, jsonLines;
    Repository repo;
    Gson gsonShape;

    ShapeDeserializer deserializer;

    private static SaveManager saveManager;
    private SaveManager() {
        repo = Repository.getInstance();
        setupDeserializer();
        gsonShape = new GsonBuilder()
                .registerTypeHierarchyAdapter(Shape.class, deserializer)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }
    public static SaveManager getSaveManager() {
        if (saveManager == null) {
            saveManager = new SaveManager();
        }
        return saveManager;
    }

    private void setupDeserializer() {
        deserializer = new ShapeDeserializer("type");
        deserializer.registerShapeType("Diamond", Diamond.class);
        deserializer.registerShapeType("Parallelogram", Parallelogram.class);
        deserializer.registerShapeType("RectangleStandard", RectangleStandard.class);
        deserializer.registerShapeType("RectangleToolMethod", RectangleToolMethod.class);
        deserializer.registerShapeType("RectangleToolVariable", RectangleToolVariable.class);
    }
    public void save(String fileName) {

        try {
            FileWriter writer = new FileWriter(filePath + fileName + shapeExt);
            jsonShapes = gsonShape.toJson(repo.getShapes());
            writer.write(jsonShapes);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //PrintWriter writer = new PrintWriter(fileName + ".shape", "UTF-8");

        //System.out.println("Shapes json: " + jsonShapes);
        //jsonLines = gsonShape.toJson(repo.getLines());
    }

    public void load(String fileName) {
        try {

            FileReader reader = new FileReader(filePath + fileName + shapeExt);

            repo.clear();
            Type listType = new TypeToken<List<Shape>>(){}.getType();

            List<Shape> shapes = gsonShape.fromJson(reader, listType);
            reader.close();
        } catch (IOException e) {
            System.out.println("No file found with that name");
        }
        //repo.add(shapes);

    }
}
