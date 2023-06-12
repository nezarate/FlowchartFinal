package Shapes;
import Handlers.Repository;
import com.google.gson.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;


/**
 * GSON: Deserializes a Shapes.ConnectingLine and creates a new object when loaded, sent to repo
 *
 * Referenced from https://www.baeldung.com/gson-list
 *
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class LineDeserializer implements JsonDeserializer<ConnectingLine> {
    private Gson gson;

    /**
     * Constructs a Line Deserializer for the Handlers.SaveManager
     */
    public LineDeserializer() {
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }


    /**
     * Deserializes and then adds new lines to the repository
     * @param json
     * @param type
     * @param context
     * @return a new constructed line obj
     * @throws JsonParseException
     */
    @Override
    public ConnectingLine deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject shapeObject = json.getAsJsonObject();

        Class[] types = {int.class, int.class, String.class};

        ConnectingLine sh = gson.fromJson(shapeObject, type);

        try {
            Constructor<ConnectingLine> conStr = ConnectingLine.class.getConstructor(types);
            //Repository.getInstance().add(conStr.newInstance(sh.id1, sh.id2, sh.label));
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
