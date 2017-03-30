package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shivani Shinde on 16-03-2017.
 */

public class Boruvkas {
    static HashMap<List,Integer> finalMap = new HashMap<>();
    static HashMap<Integer, List> createdMap = CreateGraph.createdMap();
    static List<Integer> vertex = Vertex.addVertex();
    static List<List<Integer>> sets = new ArrayList<>();
    static List<Integer> set1;
    static List<Integer> set2;
    static int start;
    static int end;

    // Merges two components into one
    public static boolean Merge(List<Integer> edge){
        for(int i=0;i<sets.size();i++){
            if(sets.get(i).contains(edge.get(0))){
                set1 = sets.get(i);
            }
        }
        for(int i=0;i<sets.size();i++){
            if(sets.get(i).contains(edge.get(1))){
                set2 = sets.get(i);
            }
        }
        if(!set1.equals(set2)){
            set1.addAll(set2);
            sets.add(set1);
            sets.remove(set1);
            sets.remove(set2);
            return true;
        }
        else{
            return false;
        }
    }

    // Finds another component for merging
    // Edge with min weight connects these two components
    public static List<Integer> minAnotherSet(List<Integer> set){
        int low = Integer.MAX_VALUE;
        for(int i=0;i<set.size();i++){
            List<List<Integer>> list = createdMap.get(set.get(i));
            for (int j=0;j<list.size();j++){
                List<Integer> temp = list.get(j);
                if(!set.contains(temp.get(0))){
                    if(temp.get(1) < low){
                        low = temp.get(1);
                        end = temp.get(0);
                        start = set.get(i);
                    }
                }
            }
        }
        List<Integer> edge = new ArrayList<>();
        edge.add(start);
        edge.add(end);
        edge.add(low);
        return edge;
    }

    // Creates components with single elements
    public static void createSet(){
        for (int i=0;i<vertex.size();i++){
            List<Integer> set = new ArrayList<>();
            set.add(vertex.get(i));
            sets.add(set);
        }
    }

    // Creates MST
    public static HashMap<List,Integer> MST(){
        createSet();
        while(sets.size() > 1){
            List<List<Integer>> edgeList = new ArrayList<>();
            for(int i=0;i<sets.size();i++){
               List<Integer> edge = minAnotherSet(sets.get(i));
               List<Integer> edgereverse = new ArrayList<>();
               edgereverse.add(edge.get(1));
               edgereverse.add(edge.get(0));
               if(!edgeList.contains(edge) && !edgeList.contains(edgereverse)){
                   edgeList.add(edge);
               }
            }
            for(int j=0;j<edgeList.size();j++){
                if(Merge(edgeList.get(j)) == true){
                    List<Integer> edge = new ArrayList<>();
                    edge.add(edgeList.get(j).get(0));
                    edge.add(edgeList.get(j).get(1));
                    finalMap.put(edge, edgeList.get(j).get(2));
                }
            }
        }
        return finalMap;
    }
    public static void main (String[] args) throws Exception {
    }
}
