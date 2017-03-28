package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class Vertex {
    static List<String> read = ReadInput.getLines();
    public static List<Integer> vertex = new ArrayList<>();

    public static int trim(String line) {
        int i = 0;
        String start = "";
        while (Character.isDigit(line.charAt(i))) {
            start = start + line.charAt(i);
            i++;
        }
        int begin = Integer.parseInt(start);
        return begin;
    }

    // Adds vertices to a list
    public static List addVertex(){
        for(int i=0;i<read.size();i++){
            vertex.add(trim(read.get(i)));
        }
        return vertex;
    }

    public static void main (String[] args) throws Exception {
    }
}
