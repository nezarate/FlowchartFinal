import com.google.gson.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


/**
 * Referenced from https://www.baeldung.com/gson-list
 */
public class LineDeserializer implements JsonDeserializer<ConnectingLine> {
    private Gson gson;

    public LineDeserializer() {
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }



    @Override
    public ConnectingLine deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject shapeObject = json.getAsJsonObject();

        Class[] types = {int.class, int.class, String.class};

        ConnectingLine sh = gson.fromJson(shapeObject, type);

        try {
            Constructor<ConnectingLine> conStr = ConnectingLine.class.getConstructor(types);
            Repository.getInstance().add(conStr.newInstance(sh.id1, sh.id2, sh.label));
            return conStr.newInstance(sh.id1, sh.id2, sh.label);
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

    }
}
