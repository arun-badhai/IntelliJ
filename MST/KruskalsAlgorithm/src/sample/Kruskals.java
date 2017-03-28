package sample;

import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class Kruskals {
    static HashMap<List,Integer> finalMap = new HashMap<>();
    static HashMap<List,Integer> sorted = CreateGraph.sortMap();
    static List<Integer> vertex = Vertex.addVertex();
    static List<Set<Integer>> sets = new ArrayList<>();
    static List<List<Integer>> edgeList = new ArrayList<>();
    static Set<Integer> set1;
    static Set<Integer> set2;

	// Merges the two sets
    public static boolean Merge(List<Set<Integer>> list){
        if(list.get(0) == list.get(1)){
            return false;
        }
        else{
            Set<Integer> set1 = list.get(0);
            Set<Integer> set2 = list.get(1);
            set1.addAll(set2);
            sets.add(set1);
            sets.remove(list.get(0));
            sets.remove(list.get(1));

            return true;
        }
    }
	
	// Finds the two sets 
    public static List<Set<Integer>> Find(int start, int end){
        List<Set<Integer>> list = new ArrayList<>();
        for (int i=0;i<sets.size();i++){
            if(sets.get(i).contains(start)){
                set1 = sets.get(i);
            }
        }
        for (int i=0;i<sets.size();i++){
            if(sets.get(i).contains(end)){
                set2 = sets.get(i);
            }
        }
        list.add(set1);
        list.add(set2);
        return list;
    }

    // Creates a MST
    public static HashMap<List, Integer> MST(){
        for (int i=0;i<vertex.size();i++){
            Set<Integer> set = new HashSet<>();
            set.add(vertex.get(i));
            sets.add(set);
        }
        int i = 0;
        Set set = sorted.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            if(i < vertex.size()-1){
                Map.Entry mapVal = (Map.Entry) iterator.next();
                List<Integer> temp = (List) mapVal.getKey();
                boolean val = Merge(Find(temp.get(0), temp.get(1)));
                if(val == true){
                    edgeList.add(temp);
                    finalMap.put(temp, (int) mapVal.getValue());
                    i++;
                }
            }
            else{
                break;
            }
        }
        return finalMap;
    }

    public static void main (String[] args) throws Exception {
    }
}
