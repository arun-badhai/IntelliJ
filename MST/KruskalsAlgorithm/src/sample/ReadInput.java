package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivani Shinde on 12-03-2017.
 */

public class ReadInput {

    public static List<String> lines;

    // Reads input from the file
    public static List getLines(){
        if(lines == null){
            lines = new ArrayList<>();
            try {
                lines = Files.readAllLines(Paths.get("./resources/testGraph.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    public static void main (String[] args) throws Exception {

    }
}
