import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Node> nodeList = new ArrayList<>();
    private static Repository repo;

    public static Repository getInstance(){
        if(repo == null)
            repo = new Repository();
        return repo;
    }

    public void add (Node node){
        nodeList.add(node);
    }

    public void clear(){
        nodeList.clear();
    }








}
