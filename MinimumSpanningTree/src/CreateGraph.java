import java.util.*;

/**
 * Created by Shivani Shinde on 12-03-2017.
 */
public class CreateGraph {
    static List<String> read = ReadInput.getLines();
    static HashMap sortedMap;
    static List<List<Integer>> edges = new ArrayList<>(); // Store all the edges as a list
    static HashMap<List,Integer> edgesWithWeights = new HashMap<>(); // Stores edges with weights

    // Adds edges to the lists
    public static void addEdge(int start, int end, int weight){
        List<Integer> edge = new ArrayList<>();
        List<Integer> edgereverse = new ArrayList<>();
        edge.add(start);
        edge.add(end);
        edgereverse.add(end); edgereverse.add(start);
        if(!edges.contains(edge) && !edges.contains(edgereverse)){
            edges.add(edge);
            edgesWithWeights.put(edge, weight);
        }
    }

    // Trims unwanted data
    public static void trim(String line){
        String value = line.replaceAll("[^0-9]","");
        int start = Character.getNumericValue(line.charAt(0));
        for(int i=1;i<value.length();i=i+2){
            int end = Character.getNumericValue(value.charAt(i));
            int weight = Character.getNumericValue(value.charAt(i+1));
            addEdge(start, end, weight);
        }
    }

    // Sorting the edges by weights
    public static HashMap sortMap(){
        for(int i=0;i<read.size();i++){
            trim(read.get(i));
        }
        System.out.println("Original graph has been created!!");
        sortedMap= new LinkedHashMap();
        sortedMap = SortedMap.sort(edgesWithWeights);
        return sortedMap;
    }

    public static void main (String[] args) throws java.lang.Exception {
    }
}
