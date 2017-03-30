package sample;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Shivani Shinde on 18-03-2017.
 */
public class GraphRef {
    static List<Integer> vertex = Vertex.vertex;
    static HashMap<Integer,Integer> ref = new HashMap<>();

    public static HashMap<Integer,Integer> setNodeValues(){
        for(int i=0;i<vertex.size();i++){
            ref.put(vertex.get(i), 100*(i+1));
        }
        return ref;
    }
}
