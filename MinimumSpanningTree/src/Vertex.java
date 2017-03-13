import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class Vertex {
    static List<String> read = ReadInput.getLines();
    static List<Integer> vertex = new ArrayList<>();

    // Adds vertices to a list
    public static List addVertex(){
        for (int i = 0; i < read.size(); i++) {
            int start = Character.getNumericValue(read.get(i).charAt(0));
            vertex.add(start);;
        }
        return vertex;
    }

    public static void main (String[] args) throws java.lang.Exception {
    }
}
