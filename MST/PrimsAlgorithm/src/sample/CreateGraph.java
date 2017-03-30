package sample;

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
        edge.add(start);
        edge.add(end);
        if(!edges.contains(edge)){
            edges.add(edge);
            edgesWithWeights.put(edge, weight);
        }
    }

    // Trims unwanted data
    public static void trim(String line){
        List<Integer> list = new ArrayList();
        int i = 0;
        String start = "";
        while(Character.isDigit(line.charAt(i))){
            start = start + line.charAt(i);
            i++;
        }
        while(i<line.length()) {
            String digits= "";
            while(Character.isDigit(line.charAt(i))) {
                digits = digits + line.charAt(i);
                i++;
            }
            if(digits != ""){
                list.add(Integer.parseInt(digits));
            }
            i++;
        }
        for(int j=0;j<list.size();j=j+2){
            int end = list.get(j);
            int weight = list.get(j+1);
            addEdge(Integer.parseInt(start), end, weight);
        }
    }

    // Sorts the edges by weights
    public static HashMap sortMap(){
        for(int i=0;i<read.size();i++){
            trim(read.get(i));
        }
        System.out.println("Graph has been created!!");
        return edgesWithWeights;
    }

    public static void main (String[] args) throws Exception {
        edgesWithWeights = sortMap();
        Set set = edgesWithWeights.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mapVal = (Map.Entry) iterator.next();
            System.out.println("Edge in MST: " + mapVal.getKey() + " with weight: " + mapVal.getValue());
        }
    }
}
