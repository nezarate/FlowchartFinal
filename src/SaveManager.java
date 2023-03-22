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

    ShapeDeserializer shapeDeserializer;

    private static SaveManager saveManager;
    private SaveManager() {
        repo = Repository.getInstance();
        setupDeserializer();
        gsonShape = new GsonBuilder()
                .registerTypeHierarchyAdapter(Shape.class, shapeDeserializer)
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
        shapeDeserializer = new ShapeDeserializer("type");
        shapeDeserializer.registerShapeType("Diamond", Diamond.class);
        shapeDeserializer.registerShapeType("Parallelogram", Parallelogram.class);
        shapeDeserializer.registerShapeType("RectangleStandard", RectangleStandard.class);
        shapeDeserializer.registerShapeType("RectangleToolMethod", RectangleToolMethod.class);
        shapeDeserializer.registerShapeType("RectangleToolVariable", RectangleToolVariable.class);
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
