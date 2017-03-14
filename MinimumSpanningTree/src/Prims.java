import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class Prims {
    static HashMap sorted = SortForPrims.sortForPrims();
    static List vertex = Vertex.addVertex();
    static HashMap MapMST = new HashMap();

    public static HashMap MST(HashMap sorted){
        while(!vertex.isEmpty()){
            Set set = sorted.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                Map.Entry mapVal = (Map.Entry)iterator.next();
            }
        }
        return MapMST;
    }
}
