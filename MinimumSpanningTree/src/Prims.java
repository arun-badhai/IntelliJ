import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class Prims {
    static HashMap<Integer,List> hMapPrims = SortForPrims.sortForPrims();
    static List<Integer> vertex = Vertex.addVertex();
    static HashMap<Integer,Integer> temp = new HashMap();
    static HashMap<Integer,Integer> parent = new HashMap();
    static HashMap<Integer,Integer> visited = new HashMap();
    static HashMap<List, Integer> finalMap = new HashMap();
    static int totalWeight = 0;

    public static int node(){
        int key = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<visited.size();i++){
            if(visited.get(i) == 0 && min > temp.get(i)){
                key = temp.get(i);
            }
        }
        return key;
    }

    public static HashMap MST(){
        temp.put(vertex.get(0), 0);
        visited.put(vertex.get(0), 0);
        for(int i=1;i<vertex.size();i++){
            temp.put(vertex.get(i),Integer.MAX_VALUE);
            visited.put(vertex.get(i),0);
        }
        int i=0;
        while(i<vertex.size()-1){
            int key = node();
            visited.put(key, 1);
            for (int j=0;j<vertex.size();j++){
                List edge = new ArrayList();
                edge.add(key);
                edge.add(vertex.get(j));
                if (edgeList.contains(edge) && visited.get(vertex.get(j)) == 0 && edgeMap.get(edge) < temp.get(key)) {
                    parent.put(vertex.get(j), key);
                    temp.put(vertex.get(j), edgeMap.get(edge));

                }
            }
            i++;
        }

        /*myMST.add(vertex.get(0));
        int min = Integer.MAX_VALUE;
        int start = myMST.get(0);
        int end = myMST.get(0);
        if(myMST.size() != vertex.size()){
            for(int i=0;i<myMST.size();i++){
                for(Object key : hMapPrims.keySet()) {
                    if(key == myMST.get(i)){
                        System.out.println("The key is: " +key);
                    }

                }
                *//*Set set = hMapPrims.entrySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    Map.Entry mapVal = (Map.Entry) iterator.next();
                    System.out.println("sndjs  " + mapVal.getKey() + "   " + myMST.get(i));
                }*//*
            }
            *//*List edge =new ArrayList();
            for (int i=0;i<myMST.size();i++) {
                List list = new ArrayList();
                Set set = hMapPrims.entrySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    Map.Entry mapVal = (Map.Entry) iterator.next();
                    System.out.println("sndjs  "+mapVal.getKey()+"   "+myMST.get(i));
                    if (mapVal.getKey() == myMST.get(i)) {
                        list = (List) mapVal.getValue();
                        for (int j = 0; j < list.size(); j++) {
                            List<Integer> listTemp = (List) list.get(j);
                            if (!myMST.contains(listTemp.get(0)) && listTemp.get(1) < min) {
                                start = myMST.get(i);
                                min = listTemp.get(1);
                                end = listTemp.get(0);
                            }
                        }
                    }
                }
            }
            totalWeight = totalWeight + min;
            myMST.add(end);
            edge.add(start);
            edge.add(end);
            finalMap.put(edge, min);
            *//*
        }*/
        System.out.println("Minimum Spanning Tree created with minimum total weight: "+totalWeight);
        return finalMap;

    }
    public static void main(String[] args) throws java.lang.Exception {
    }
}
