import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Shivani Shinde on 12-03-2017.
 */

public class ReadInput {
    static List<String> lines;
    public static void main (String[] args) throws java.lang.Exception {
        lines = Files.readAllLines(Paths.get("./resources/input.txt"));
    }
}
