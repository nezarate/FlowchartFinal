import com.google.gson.*;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


/**
 * Referenced from https://www.baeldung.com/gson-list
 */
public class ShapeDeserializer implements JsonDeserializer<Shape> {
    private String shapeTypeElementName;
    private Gson gson;
    private Map<String, Class<? extends Shape>> shapeTypeRegistry;

    public ShapeDeserializer(String shapeTypeElementName) {
        this.shapeTypeElementName = shapeTypeElementName;
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        shapeTypeRegistry = new HashMap<>();
    }

    public void registerShapeType(String shapeTypeName, Class<? extends Shape> shapeType) {
        shapeTypeRegistry.put(shapeTypeName, shapeType);
    }

    @Override
    public Shape deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject shapeObject = json.getAsJsonObject();
        JsonElement shapeTypeElement = shapeObject.get(shapeTypeElementName);
        //System.out.println(shapeTypeElement)

        Class<? extends Shape> shapeType = shapeTypeRegistry.get(shapeTypeElement.getAsString());


        Class[] types = {int.class, int.class, String.class};

        //List<Shape> shapes = Collections.singletonList(gson.fromJson(shapeObject, shapeType));

        Shape sh = gson.fromJson( shapeObject,shapeType);


        try {
            Constructor<? extends Shape> conStr = shapeType.getConstructor(types);
            Repository.getInstance().add(conStr.newInstance(sh.x1, sh.y1, sh.label));
            return conStr.newInstance(sh.x1, sh.y1, sh.label);
            //return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        // Class[] types = {Integer.class, Integer.class, Color.class, String.class};
        //shapeType.new
        //Constructor<? extends Shape> cons = shapeType.getConstructor(Integer.class, Integer.class, Color.class, String.class);
        //return cons.newInstance(50, 50, Color.BLACK, "test");

        //return gson.fromJson(shapeObject, shapeType);
        //return new Diamond(50, 50, Color.BLACK, "test");//gson.fromJson(shapeObject, shapeType);
    }
}
