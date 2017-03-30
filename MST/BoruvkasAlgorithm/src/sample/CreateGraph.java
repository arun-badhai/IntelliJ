package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shivani Shinde on 12-03-2017.
 */
public class CreateGraph {
    static List<String> read = ReadInput.getLines();
    static HashMap sortedMap;
    static List<List<Integer>> edges = new ArrayList<>(); // Store all the edges as a list
    static HashMap<Integer, List> edgesWithWeights = new HashMap<>(); // Stores edges with weights

    // Check if an edge already exists
    public static boolean addEdge(int start, int end, int weight){
        List<Integer> edge = new ArrayList<>();
        edge.add(start);
        edge.add(end);
        if(!edges.contains(edge)){
            edges.add(edge);
            return true;
        }
        return false;
    }

    // Trims unwanted data
    public static void trim(String line){
        List<Integer> list = new ArrayList();
        List<List<Integer>> adj = new ArrayList<>();
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
            if(addEdge(Integer.parseInt(start), end, weight) == true){
                List<Integer> temp = new ArrayList<>();
                temp.add(end);
                temp.add(weight);
                adj.add(temp);
            }
        }
        edgesWithWeights.put(Integer.parseInt(start),adj);
    }

    // Sorts the edges by weights
    public static HashMap createdMap(){
        for(int i=0;i<read.size();i++){
            trim(read.get(i));
        }
        System.out.println("Original graph has been created!!");
        return edgesWithWeights;
    }

    public static void main (String[] args) throws Exception {
    }
}
