import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class Kruskals {
    static List vertex = Vertex.addVertex();
    static HashMap finalEdges = new HashMap();
    static List<Integer> finalVertex = new ArrayList();
    static int totalweight = 0;

    // Creates a MST
    public static HashMap MST(HashMap sorted){
        Set set = sorted.entrySet();
        Iterator iterator = set.iterator();
        while (!vertex.isEmpty()){
            if(iterator.hasNext()){
                Map.Entry mapVal = (Map.Entry)iterator.next();
                List key = (List) mapVal.getKey();
                if(vertex.contains(key.get(0)) && vertex.contains(key.get(1))){
                    finalVertex.add((int)key.get(0));
                    finalVertex.add((int)key.get(1));
                    vertex.remove(key.get(0));
                    vertex.remove(key.get(1));
                    finalEdges.put(key, (int) mapVal.getValue());
                    totalweight = totalweight + (int) mapVal.getValue();
                }
                else if(vertex.contains(key.get(0)) || vertex.contains(key.get(1))){
                    if(vertex.contains(key.get(0))){
                        finalVertex.add((int)key.get(0));
                        vertex.remove(key.get(0));
                    }
                    else{
                        finalVertex.add((int)key.get(1));
                        vertex.remove(key.get(1));
                    }
                    finalEdges.put(key, (int) mapVal.getValue());
                    totalweight = totalweight + (int) mapVal.getValue();
                }
            }
        }
        System.out.println("Minimum Spanning Tree created with minimum total weight: "+totalweight);
        return finalEdges;
    }

    public static void main (String[] args) throws java.lang.Exception {
    }
}
