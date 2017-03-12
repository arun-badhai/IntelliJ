import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Shivani Shinde on 11-03-2017.
 */
public class Graph {
    static int v;
    static int e;
    static List<Integer>  vertex = new ArrayList<Integer>();
    static HashMap<Integer, Integer> edge = new HashMap<>();
    static HashMap<Integer, HashMap> mainMap = new HashMap<>();
    static HashMap<Integer, Integer> innerMap = new HashMap<>();

    public static void addVertex(int key){
        vertex.add(key);
    }

    public static void addEdge(int start, int end, int weight){
        innerMap.put(end, weight);
        mainMap.put(start, innerMap);
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Graph graph = new Graph();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        v = sc.nextInt();
        System.out.println("Enter all the vertices");
        for(int i=0;i<v;i++){
            int key = sc.nextInt();
            if (vertex.contains(key)) {
                System.out.println("Vertex already present in the graph");
                i--;
            }
            else{
                graph.addVertex(key);
            }
        }
        System.out.println("Enter number of edges");
        e = sc.nextInt();
        System.out.println("Enter all the edges with their weights");
        for(int i=0;i<e;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            if(!edge.containsKey(start) && !edge.containsValue(end)){
                if(vertex.contains(start) && vertex.contains(end)){
                    edge.put(start, end);
                    graph.addEdge(start, end, weight);
                }
                else{
                    System.out.println("One of the vertices not present in the graph");
                    i--;
                }
            }
            else{
                System.out.println("Edge already present in the graph");
                i--;
            }
        }
        System.out.println("Graph created");
    }
}
