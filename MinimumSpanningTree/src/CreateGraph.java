import java.util.*;

/**
 * Created by Shivani Shinde on 12-03-2017.
 */
public class CreateGraph {
    static List<String> read = ReadInput.getLines();
    static HashMap sortedMap;
    static List<Integer> vertex = new ArrayList<>(); // Stores all the vertices
    static List<List<Integer>> edges = new ArrayList<>(); // Store all the edges as a list
    static HashMap<List,Integer> edgesWithWeights = new HashMap<>(); // Stores edges with weights

    // Adds vertices to the list
    public static void addVertex(int val){
        if(!vertex.contains(val)){
            vertex.add(val);
        }
    }

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
        addVertex(start);
        for(int i=1;i<value.length();i=i+2){
            int end = Character.getNumericValue(value.charAt(i));
            int weight = Character.getNumericValue(value.charAt(i+1));
            addEdge(start, end, weight);
        }
    }

    public static HashMap sort(HashMap edgesWithWeights) {
        List sortedList = new ArrayList(edgesWithWeights.entrySet());
        Collections.sort(sortedList, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        HashMap sortedMap = new LinkedHashMap();
        Iterator iterator = sortedList.iterator();
        while(iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            sortedMap.put(mapEntry.getKey(), mapEntry.getValue());
        }
        return sortedMap;
    }

    public static void main (String[] args) throws java.lang.Exception {

        for(int i=0;i<read.size();i++){
            trim(read.get(i));
        }
        System.out.println("Graph has been created!!");
        sortedMap= new LinkedHashMap();
        sortedMap = sort(edgesWithWeights);
        Set set = sortedMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mapVal = (Map.Entry)iterator.next();
            System.out.println("key is: "+ mapVal.getKey() + " & Value is: " +mapVal.getValue());
        }
    }
}
