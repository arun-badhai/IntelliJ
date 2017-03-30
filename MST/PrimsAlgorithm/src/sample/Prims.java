package sample;

import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class Prims {
    static HashMap<List,Integer> edgeList = CreateGraph.sortMap();
    static List<Integer> vertex = Vertex.addVertex();
    static HashMap<Integer,Integer> weight = new HashMap();
    static HashMap<Integer,Integer> parent = new HashMap();
    static HashMap<Integer,Integer> visited = new HashMap();
    static HashMap<List, Integer> finalMap = new HashMap();

    public static int node(){
        int key = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<vertex.size();i++){
            if(visited.get(vertex.get(i)) != 1 && min > weight.get(vertex.get(i))){
                min = weight.get(vertex.get(i));
                key = vertex.get(i);
            }
        }
        return key;
    }

    public static HashMap MST(){
        visited.put(vertex.get(0), 0);
        weight.put(vertex.get(0), 0);
        parent.put(vertex.get(0), Integer.MIN_VALUE);
        for(int i=1;i<vertex.size();i++){
            visited.put(vertex.get(i), 0);
            weight.put(vertex.get(i), Integer.MAX_VALUE);
        }
        for(int i=0;i<vertex.size()-1;i++){
            int key = node();
            visited.put(key, 1);
            for (int j=0;j<vertex.size();j++){
                List edge = new ArrayList();
                List edgerev = new ArrayList();
                edge.add(key);
                edge.add(vertex.get(j));
                edgerev.add(vertex.get(j));
                edgerev.add(key);
                if (edgeList.containsKey(edge)){
                    if(visited.get(vertex.get(j)) == 0 && weight.get(vertex.get(j)) > edgeList.get(edge)) {
                        parent.put(vertex.get(j), key);
                        weight.put(vertex.get(j), edgeList.get(edge));
                    }
                }
                else if (edgeList.containsKey(edgerev)){
                    if(visited.get(vertex.get(j)) == 0 && weight.get(vertex.get(j)) > edgeList.get(edgerev)) {
                        parent.put(vertex.get(j), key);
                        weight.put(vertex.get(j), edgeList.get(edgerev));
                    }
                }
            }
        }
        for (int k=0;k<vertex.size();k++){
            List list = new ArrayList();
            list.add(parent.get(vertex.get(k)));
            list.add(vertex.get(k));
            if(weight.get(vertex.get(k)) != 0){
                finalMap.put(list, weight.get(vertex.get(k)));
            }
        }
        return finalMap;
    }
    public static void main(String[] args) throws Exception {
    }
}
