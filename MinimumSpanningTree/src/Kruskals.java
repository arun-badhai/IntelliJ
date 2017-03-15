import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class Kruskals {
    static HashMap<List,Integer> sorted = CreateGraph.sortMap();
    static List<Integer> vertex = Vertex.addVertex();
    static HashMap<List,Integer> finalMap = new HashMap<>();
    static HashMap<Integer,Integer> parent = new HashMap<>();

    // Creates a MST
    public static HashMap<List, Integer> MST(){
        List edges = new ArrayList<>();
        Set set = sorted.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mapVal = (Map.Entry) iterator.next();
            edges.add(mapVal.getKey());
        }
        for (int i=0;i<vertex.size();i++){
            parent.put(vertex.get(i), vertex.get(i));
        }
        int i=0;
        while(i<vertex.size()-1){
            Set set2 = sorted.entrySet();
            Iterator iterator2 = set2.iterator();
            while(iterator2.hasNext()) {
                Map.Entry mapVal = (Map.Entry) iterator2.next();
                if(edges.contains(mapVal.getKey())){
                    List<Integer> temp = (List) mapVal.getKey();
                    if(parent.get(temp.get(0)) != parent.get(temp.get(1))){
                        edges.remove(mapVal.getKey());
                        parent.put(temp.get(1), temp.get(0));
                        finalMap.put(temp, (int) mapVal.getValue());
                        break;
                    }
                }
            }
            i++;
        }
        /*Set set1 = parent.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()) {
            Map.Entry mapVal = (Map.Entry) iterator1.next();
            System.out.println(mapVal.getKey()+"      "+mapVal.getValue());
        }*/
        /*Set set = sorted.entrySet();
        Iterator iterator = set.iterator();
        List temp = vertex;
        while (!temp.isEmpty()){
            while(!vertex.isEmpty()){
                if(iterator.hasNext()){
                    Map.Entry mapVal = (Map.Entry)iterator.next();
                    List key = (List) mapVal.getKey();
                    if(vertex.contains(key.get(0)) && vertex.contains(key.get(1))){
                        finalVertex.add((int)key.get(0));
                        finalVertex.add((int)key.get(1));
                        vertex.remove(key.get(0));
                        vertex.remove(key.get(1));
                        //finalEdges.put(key, (int) mapVal.getValue());
                        totalweight = totalweight + (int) mapVal.getValue();
                    }
                    else if(vertex.contains(key.get(0)) || vertex.contains(key.get(1))){
                        if(vertex.contains(key.get(0))){
                            //finalVertex.add((int)key.get(0));
                            vertex.remove(key.get(0));
                        }
                        else{
                            finalVertex.add((int)key.get(1));
                            vertex.remove(key.get(1));
                        }
                        //finalEdges.put(key, (int) mapVal.getValue());
                        totalweight = totalweight + (int) mapVal.getValue();
                    }
                }
            }
        }*/
        return finalMap;
    }

    public static void main (String[] args) throws java.lang.Exception {
    }
}
