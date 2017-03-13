import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Shivani Shinde on 11-03-2017.
 */
class GraphCreation {
    static int v;
    static List<Integer>  vertex = new ArrayList<Integer>(); // List of vertices
    static List<HashMap> unsort = new ArrayList<>(); // List will be used in Prims to get the edges in sorted order
    static HashMap<Integer,HashMap> unsorted; // HashMap used to store edges with their weights
    static List<HashMap> edges = new ArrayList<>(); // HashMap used to store just the edges
    static HashMap<Integer, Integer> edge; // Temporary edge, to check for duplication

    public static void addVertex(int key){
        vertex.add(key);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        GraphCreation graph = new GraphCreation();
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
        for(int j=0;j<vertex.size();j++){
            System.out.println("Enter the number of out-going edges from "+vertex.get(j));
            int e = sc.nextInt();
            System.out.println("Enter all the ending vertices with edge weights");
            List<HashMap> list = new ArrayList<>();
            HashMap<Integer, Integer> innerMap = new HashMap<>();
            for(int i=0;i<e;i++){
                int end = sc.nextInt();
                int weight = sc.nextInt();
                if(vertex.get(j) != end){
                    if(vertex.contains(end)){
                        edge = new HashMap<>();
                        edge.put(vertex.get(j), end);
                        if(!edges.contains(edge)){
                            unsorted = new HashMap<>();
                            unsorted.put(weight, edge);
                            unsort.add(unsorted);
                            edges.add(edge);
                        }
                        else{
                            System.out.println("Edge already exists in the graph");
                            i--;
                        }
                    }
                    else{
                        System.out.println("End vertex not present in the graph");
                        i--;
                    }
                }
                else{
                    System.out.println("Start and end vertex is the same");
                    i--;
                }
            }
        }
        System.out.println("Graph created");
    }
}
