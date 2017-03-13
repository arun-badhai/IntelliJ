import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shivani Shinde on 12-03-2017.
 */
public class CreateGraph {
    static List<Integer> vertex = new ArrayList<>();
    static List<List<Integer>> edges = new ArrayList<>();
    static HashMap<Integer,List> edgesWithWeights = new HashMap<>();
    public static void addVertex(int val){
        if(!vertex.contains(val)){
            vertex.add(val);
        }
    }
    public static void addEdge(int start, int end, int weight){
        List<Integer> edge = new ArrayList<>();
        List<Integer> edgereverse = new ArrayList<>();
        edge.add(start); edge.add(end);
        edgereverse.add(end); edgereverse.add(start);
        if(!edges.contains(edge) && !edges.contains(edgereverse)){
            edges.add(edge);
            edgesWithWeights.put(weight, edge);
        }
    }
    public static void trim(String line){
        String value = line.replaceAll("[^0-9]","");
        int start = Character.getNumericValue(line.charAt(0));
        addVertex(start);
        for(int i=1;i<value.length();i=i+2){
            int end = Character.getNumericValue(line.charAt(i));
            int weight = Character.getNumericValue(line.charAt(i+1));
            addEdge(start, end, weight);
        }
    }
    public static void main (String[] args) throws java.lang.Exception {
        for(int i=0;i<ReadInput.lines.size();i++){
            trim(ReadInput.lines.get(i));
        }
    }
}
