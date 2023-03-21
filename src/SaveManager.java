import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Singleton
 */
public class SaveManager {

    //String filepath = "test";
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
    public void save(String filename) {

        jsonShapes = gsonShape.toJson(repo.getShapes());
        System.out.println("Shapes json: " + jsonShapes);
        //jsonLines = gsonShape.toJson(repo.getLines());
    }

    public void load(String filename) {

        Type listType = new TypeToken<List<Shape>>(){}.getType();

        List<Shape> shapes = gsonShape.fromJson(jsonShapes, listType);

        //repo.add(shapes);

    }
}
